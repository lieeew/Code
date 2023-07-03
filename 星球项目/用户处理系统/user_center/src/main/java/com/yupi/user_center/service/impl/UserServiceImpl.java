package com.yupi.user_center.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.user_center.model.domain.User;
import com.yupi.user_center.service.UserService;
import com.yupi.user_center.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.yupi.user_center.contant.UserConstant.USER_LOGIN_STATE;

/**
 * @author leikooo
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-07-02 16:09:52
 */
@Service
@Slf4j // 可以加日志
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Resource
    private UserMapper userMapper;
    /**
     * 盐值
     * 快捷键 prsf
     */
    private static final String SALT = "yupi";


    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword) {
        // 一、 校验, 需要非空
        if (StringUtils.isAllBlank(userAccount, userPassword, checkPassword)) {
            // todo 这里需要使用自定义异常，进行返回
            return  -1;
        }
        // 二、 校验用户的账户、密码、校验密码，是否符合要求
        // 2. 账户长度不小于 4 位
        if (userAccount.length() < 4) {
            return -1;
        }
        // 3. 密码就不小于 8 位
        if (userPassword.length() < 8 || checkPassword.length() < 8) {
            return -1;
        }
        // 4. 账户不包含特殊字符
        String pattern = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Matcher matcher = Pattern.compile(pattern).matcher(userAccount);
        if (matcher.find()) {
            return -1;
        }

        // 5. 密码和校验密码相同
        if (!userPassword.equals(checkPassword)) {
            return -1;
        }

        // 6. 账户不能重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        long count = userMapper.selectCount(queryWrapper);
        if (count > 0) {
            return -1;
        }

        // 三、 插入数据
        // 对密码进行加盐
        User user = new User();

        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        user.setUserAccount(userAccount);
        user.setUserPassword(encryptPassword);

        // 保存用户
        boolean save = this.save(user);
        if (!save) {
            return -1;
        }
        // 返回注册的 ID 号
        return user.getId();
    }

    @Override
    public User userLogin(String userAccount, String userPassword, HttpServletRequest request) {
        // 一、 校验, 需要非空
        if (StringUtils.isAllBlank(userAccount, userPassword)) {
            return null;
        }

        // 二、 校验用户的账户、密码、校验密码，是否符合要求
        // 2. 账户长度不小于 4 位
        if (userAccount.length() < 4) {
            return null;
        }
        // 3. 密码就不小于 8 位
        if (userPassword.length() < 8) {
            return null;
        }
        // 4. 账户不包含特殊字符
        String pattern = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Matcher matcher = Pattern.compile(pattern).matcher(userAccount);
        if (matcher.find()) {
            return null;
        }

        // 三、 检查数据
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        // 查询数据库, 进行比对密码的操作
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        queryWrapper.eq("userPassword", encryptPassword);
        User user = userMapper.selectOne(queryWrapper);
        // 用户不存在
        if (user == null) {
            // 记录日志尽量使用英文，不容易出现乱码
            log.info("user login failed can not match password");
            return null;
        }

        // 这里重新生成一个对象，进行返回数据
        // 脱敏
        User saftyUser = new User();

        saftyUser.setId(user.getId());
        saftyUser.setUsername(user.getUsername());
        saftyUser.setUserAccount(userAccount);
        saftyUser.setAvatarUrl(user.getAvatarUrl());
        saftyUser.setGender(user.getGender());
        saftyUser.setPhone(user.getPhone());
        saftyUser.setEmail(user.getEmail());
        saftyUser.setUserStatus(user.getUserStatus());
        saftyUser.setCreateTime(user.getCreateTime());
        saftyUser.setIsDelete(user.getIsDelete());
        saftyUser.setUserRole(user.getUserRole());
        // 记录用户的登录状态
        request.getSession().setAttribute(USER_LOGIN_STATE, saftyUser);

        return saftyUser;
    }
}





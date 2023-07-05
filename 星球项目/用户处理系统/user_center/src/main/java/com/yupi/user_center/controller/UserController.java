package com.yupi.user_center.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yupi.user_center.model.domain.User;
import com.yupi.user_center.model.domain.request.UserLoginRequest;
import com.yupi.user_center.model.domain.request.UserRegisterRequest;
import com.yupi.user_center.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.yupi.user_center.contant.UserConstant.ADMIN_ROLE;
import static com.yupi.user_center.contant.UserConstant.USER_LOGIN_STATE;

/**
 * @author leikooo
 * @create 2023-07-03 12:42
 * @Package com.yupi.user_center.controller
 * @Description 用户接口，用户登录系统
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 用户注册
     *
     * @param userRegisterRequest 建议封装一个对象
     * @return userId
     */
    @PostMapping("/register")
    public Long userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        if (userRegisterRequest == null) {
            return null;
        }
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        // 稍微简单校验一下
        // controller 层一般是没有感情的校验，不涉及逻辑校验
        if (StringUtils.isAllBlank(userAccount, userPassword, checkPassword)) {
            return null;
        }

        return userService.userRegister(userAccount, userPassword, checkPassword);
    }

    @PostMapping("/login")
    public User userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        if (userLoginRequest == null) {
            return null;
        }
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();
        // 稍微简单校验一下
        // controller 层一般是没有感情的校验，不涉及逻辑校验
        if (StringUtils.isAllBlank(userAccount, userPassword)) {
            return null;
        }

        return userService.userLogin(userAccount, userPassword, request);
    }

    @GetMapping("/search")
    public List<User> searchUser(String username, HttpServletRequest request) {
        if (!isAdmin(request)) {
            // 返回一个空的集合
            return new ArrayList<>();
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNoneBlank(username)) {
            queryWrapper.like("username", username);
        }
        List<User> list = userService.list();
        // 这里逻辑要是很复杂的话，那么直接写在 service 里面
        return list.stream().map(user -> userService.getSafetyUser(user)
        ).collect(Collectors.toList());
    }

    @PostMapping("/delete")
    public boolean deleteUser(long id, HttpServletRequest request) {
        if (!isAdmin(request)) {
            return false;
        }
        if (id <= 0) {
            return false;
        }
        return userService.removeById(id);
    }

    /**
     * 获取用户当前的状态
     */
    @GetMapping("/current")
    public User getUserState(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(USER_LOGIN_STATE);
        User byId = userService.getById(user.getId());
        return userService.getSafetyUser(byId);
    }


    /**
     * 进行鉴权，仅管理员可以查询
     *
     * @param request request 请求
     * @return true-管理员   false-代表普通用户
     */
    private boolean isAdmin(HttpServletRequest request) {
        // 进行鉴权，仅管理员可以查询
        User user = (User) request.getSession().getAttribute(USER_LOGIN_STATE);
        return user != null && user.getUserRole() == ADMIN_ROLE;
    }

}

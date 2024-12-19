package com.yupi.user_center.mapper;

import com.yupi.user_center.model.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
* @author liang
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-07-02 16:09:52
* @Entity com.yupi.user_center.model.domain.User
*/
public interface UserMapper extends BaseMapper<User> {
    void insertUser(@Param("username") String username);
}





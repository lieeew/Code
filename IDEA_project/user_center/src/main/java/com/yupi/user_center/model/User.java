package com.yupi.user_center.model;

import lombok.Data;

/**
 * @author leikooo
 * @create 2023-07-02 9:39
 * @Package com.yupi.user_center.model
 * @Description
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
package com.hspedu.furns.entity;

/**
 * @Author: qxy
 * @Date: 2023/4/12
 * @Description: JavaBean
 */
public class Member {
    private Integer id;
    private String username;
    private String email;
    private String password;

    // 一定要提供无参构造器, 底层通过使用无参构造器
    public Member() {
    }

    public Member(Integer id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

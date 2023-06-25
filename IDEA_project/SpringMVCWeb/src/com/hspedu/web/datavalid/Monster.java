package com.hspedu.web.datavalid;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * @author leikooo
 * @create 2023-06-22 19:32
 * @Package com.hspedu.web.datavalid
 * @Description
 */
public class Monster {
    private Integer id;
    @Email
    @NotNull(message = "email 不能为空")
    private String email;
    /**
     * 表示接受的范围是 0 到 100 之间
     */
    @NotNull(message = "age 不能为空") // 为空时提示的信息
    @Range(min = 1,max = 100)
    private Integer age;
    /**
     * @NotEmpty
     * Asserts that the annotated string, collection, map or array is not null or empty
     */
    @NotEmpty
    private String name;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @NotNull
    @NumberFormat(pattern = "###,###.##")
    private Float salary;

    public Monster() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", salary=" + salary +
                '}';
    }
}

package com.hspedu.SpringMVC.datavalid;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author leikooo
 * @create 2023-06-25 21:17
 * @Package com.hspedu.SpringMVC.datavalid
 * @Description
 */
public class Monster {
    private Integer id;
    @NotEmpty
    // 属于格式化后的验证，必须在对应方法的新参上加一个注解 @Valid，切记！
    @Email(message = "email must be right ~~")
    private String email;
    @NotNull
    @Range(min = 0, max = 150, message = "请输入的年龄范围是 0 ~ 150 之间")
    private Integer age;

    @NotEmpty // 使用 @NotNull 不能满足需求
    private String name;
    // 这个属于格式化
    @NotNull
    @NumberFormat(pattern = "#,###.##")
    private Float salary;

    // 这个属于格式化
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

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

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }
}

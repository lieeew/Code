package com.leikooo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author leikooo
 * @create 2023-07-12 21:24
 * @Package com.leikooo.hspmybatis.entity
 * @Description
 * 老师解读
 * @Getter 就会给所有属性生成对应的 getter
 * @Setter 就会给所有属性生成对应的 setter
 * @ToString 生成 toString 方法
 * @NoArgsConstructor 生成无参构造器
 * @AllArgsConstructor 生成要给全参构造器
 * @Data 非常的全
 */
@Data
@AllArgsConstructor // 只是使用这个，那么无参构造器就会消失
@NoArgsConstructor
public class Monster implements Serializable {

    private Integer id;
    private Integer age;
    private Date birthday;
    private String email;
    private Integer gender;
    private String name;
    private Double salary;

}


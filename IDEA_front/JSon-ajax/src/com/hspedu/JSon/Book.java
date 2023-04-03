package com.hspedu.JSon;

import java.io.Serializable;

/**
 * @Author: qxy
 * @Date: 2023/4/3
 * @Description:
 */
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;

    public Book() {

    }

    public Book(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

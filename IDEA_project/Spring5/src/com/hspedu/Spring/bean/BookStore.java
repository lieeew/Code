package com.hspedu.Spring.bean;

import java.util.List;

/**
 * ClassName: BookStore
 * Package: com.hspedu.Spring.bean
 *
 * @Author: leikooo
 * @Creat: 2023/5/18 - 16:55
 * @Description: 书店类
 */
public class BookStore {
    private List<String> bookList;

    // 没有其他的构造器 无参构造器默认有
    public BookStore() {
    }

    public List<String> getBookList() {
        return bookList;
    }

    public void setBookList(List<String> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "bookList=" + bookList +
                '}';
    }
}

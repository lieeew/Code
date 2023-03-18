package com.hspedu.servlet;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: qxy
 * @Date: 2023/3/18
 * @Description:
 */
public class Book {
    private String bookName;
    private String[] autors;
    private List<String> reader;
    private Map<String, String> topics;

    public Book() {
    }

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String[] getAutors() {
        return autors;
    }

    public void setAutors(String[] autors) {
        this.autors = autors;
    }

    public List<String> getReader() {
        return reader;
    }

    public void setReader(List<String> reader) {
        this.reader = reader;
    }

    public Map<String, String> getTopics() {
        return topics;
    }

    public void setTopics(Map<String, String> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", autors=" + Arrays.toString(autors) +
                ", reader=" + reader +
                ", topics=" + topics +
                '}';
    }
}

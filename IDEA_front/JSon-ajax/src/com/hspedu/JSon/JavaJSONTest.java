package com.hspedu.JSon;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: qxy
 * @Date: 2023/4/5
 * @Description:
 */
public class JavaJSONTest {
    public static void main(String[] args) {
        // 1. JavaBean  --> JSON
        Gson gson = new Gson();
        Book book = new Book(1, "神奇女侠");
        String StrBook = gson.toJson(book);
        System.out.println(StrBook);

        // 2. JSON --> JavaBean
        Book book1 = gson.fromJson(StrBook, Book.class);
        System.out.println(book1);

        // List --> Json
        List<Book> strings = new ArrayList<>();
        strings.add(new Book(2, "西厢记"));
        strings.add(new Book(3, "西游记"));

        String StrList = gson.toJson(strings);
        System.out.println(StrList);

        // JSON --> List

        List<Book> ListJson = gson.fromJson(StrList, new TypeToken<List<Book>>() {
        }.getType());

        System.out.println("ListJson = " + ListJson);

        // HashMap --> Json
        HashMap<Integer, Book> bookHashMap = new HashMap<Integer, Book>();
        bookHashMap.put(1, new Book(2, "西厢记"));
        bookHashMap.put(2, new Book(3, "西游记"));

        String s = gson.toJson(bookHashMap);
        System.out.println(s);

        // JSON --> HashMap

        HashMap<String, Book> o = gson.fromJson(s, new TypeToken<HashMap<String, Book>>() {
        }.getType());
        System.out.println(o);


    }

}

package com.hspedu.JSon;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qxy
 * @Date: 2023/4/3
 * @Description: 显示JavaBean 和 JSon字符串之间的转化
 */
public class JavaJson {
    public static void main(String[] args) {
        // creat Gson object
        Gson gson = new Gson();
        // creat JavaBean object
        Book book = new Book(100, "韩顺平教育");

        // 1. convert JavaBean object to JSON string
        String strBook = gson.toJson(book);
        System.out.println("strBook = " + strBook);

        // 2. convert JSON string to JavaBean object
        /*
            1. strBook就是json字符串
            2. Book.class 指定的是json字符串转化成Book对象
            3. 底层使用反射
         */
        Book book1 = gson.fromJson(strBook, Book.class);
        System.out.println("book1 =  " + book1);

        // 演示把list对象 --> json字符串
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(200, "hello world"));
        bookList.add(new Book(300, "hello leikooo"));

        // 把对象转给字符串, 相对比较简单, 底层只需要遍历, 按照json格式拼接返回
        String strBookList = gson.toJson(bookList);
        System.out.println("strBookList = " + strBookList);

        // 演示将 converted JSON  to List<Book>
        /*
            1. 如果需要转成把json字符串转成集合这样复杂的类型需要使用 gson提供的一个类
            2. TypeToken 是一个自定义泛型类 通过TypeToken来指定我们需要的类型
                public class TypeToken<T> {
                    final Class<? super T> rawType;
                    final Type type;
                    final int hashCode;

                    protected TypeToken() {
                        this.type = getSuperclassTypeParameter(this.getClass());
                        this.rawType = Types.getRawType(this.type);
                        this.hashCode = this.type.hashCode();
                    }
            3. Type type = new TypeToken<List<Book>>(){}.getType();
                // Type = java.util.List<com.hspedu.JSon.Book>
                System.out.println("Type = " + type);
                1. 返回类型的完整路径 java.util.List<com.hspedu.JSon.Book>
                2. gson 设计者需要得到类型完整路径然后进行底层反射

         */

        Type type = new TypeToken<List<Book>>() {
        }.getType();
        // Type = java.util.List<com.hspedu.JSon.Book>
        System.out.println("Type = " + type);
        List<Book> o = gson.fromJson(strBookList, type);
        System.out.println(o);
    }
}

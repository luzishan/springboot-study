package com.lu.factory;

import com.lu.domain.Book;

/**
 * 静态工厂创建bean
 *
 * @author lzs
 * @version 1.0
 * @date 2020/12/1 10:58
 */
public class StaticFactoryBean {

    public static Book getStaticBook(String author) {
        System.out.println("静态工厂创建对象~~~");
        Book book = new Book();
        book.setAuthor(author);
        book.setBookName("西游记");
        book.setPrice(30);
        return book;
    }
}

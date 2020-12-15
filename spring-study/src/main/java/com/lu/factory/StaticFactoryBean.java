package com.lu.factory;

import com.lu.domain.BookBean;

/**
 * 静态工厂创建bean
 *
 * @author lzs
 * @version 1.0
 * @date 2020/12/1 10:58
 */
public class StaticFactoryBean {

    public static BookBean getStaticBook(String author) {
        System.out.println("静态工厂创建对象~~~");
        BookBean book = new BookBean();
        book.setAuthor(author);
        book.setBookName("西游记");
        book.setPrice(30);
        return book;
    }
}

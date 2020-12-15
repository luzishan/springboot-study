package com.lu.factory;

import com.lu.domain.BookBean;

/**
 * 实例工厂创建对象
 *
 * @author lzs
 * @version 1.0
 * @date 2020/12/1 11:16
 */
public class InstanceFactoryBean {

    public BookBean getInstanceBook(String author) {
        System.out.println("实例工厂创建对象~~~");
        BookBean book = new BookBean();
        book.setAuthor(author);
        book.setBookName("西游记");
        book.setPrice(30);
        return book;
    }
}

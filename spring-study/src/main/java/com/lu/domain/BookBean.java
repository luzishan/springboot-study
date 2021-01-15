package com.lu.domain;

import lombok.Data;

/**
 *
 * @author lzs
 * @version 1.0
 * @date 2020/12/1 10:24
 */
@Data
public class BookBean {

    private String bookName;

    private Integer price;

    private String author;

   public BookBean(String bookName, Integer price){
        System.out.println("通过有参bookName,price构造器给对象属性赋值");
        this.bookName = bookName;
        this.price = price;
    }

    public BookBean(String author){
        System.out.println("通过有参author构造器给对象属性赋值");
        this.author = author;
    }

    public BookBean(String bookName, Integer price, String author){
        System.out.println("通过有参bookName,price,author构造器给对象属性赋值");
        this.bookName = bookName;
        this.price = price;
        this.author = author;
    }

    public BookBean(){
        System.out.println("通过构造器给对象属性赋值");
    }

}

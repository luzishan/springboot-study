package com.lu.test;

import com.lu.domain.Book;
import com.lu.domain.Cat;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author lzs
 * @version 1.0
 * @date 2020/12/1 11:19
 */
public class BookTest {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:IOC2.xml");

    @Test
    public void getStaticBook(){
        Book getBook = (Book)applicationContext.getBean("getBook");
        System.out.println(getBook);
    }

    @Test
    public void instancebook(){
        Book instancebook = (Book)applicationContext.getBean("instancebook");
        System.out.println(instancebook);
    }

    @Test
    public void springFactoryBean(){
        Cat springFactoryBean = (Cat)applicationContext.getBean("springFactoryBean");
        System.out.println(springFactoryBean);
    }
}

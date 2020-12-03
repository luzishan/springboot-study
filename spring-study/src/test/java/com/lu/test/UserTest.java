package com.lu.test;

import com.lu.domain.Book;
import com.lu.domain.UserInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 * @author lzs
 * @version 1.0
 * @date 2020/11/30 10:55
 */
public class UserTest {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:IOC.xml");

    @Test
    public void user1(){
        UserInfo userTest = (UserInfo)applicationContext.getBean("userTest");
        System.out.println(userTest);

    }

    @Test
    public void book01(){
        Book book01 = (Book)applicationContext.getBean("book01");
        System.out.println(book01);
    }

    @Test
    public void userTest02(){
        UserInfo userInfo = (UserInfo)applicationContext.getBean("userTest02");
        System.out.println(userInfo);
    }

    @Test
    public void user2(){
        UserInfo bean = applicationContext.getBean(UserInfo.class);
        System.out.println(bean);
    }

}

package com.lu.test;

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

    @Test
    public void user1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:IOC.xml");
        UserInfo userTest = (UserInfo)applicationContext.getBean("userTest");
        System.out.println(userTest);

    }

}

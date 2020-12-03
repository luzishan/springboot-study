package com.lu.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author lzs
 * @version 1.0
 * @date 2020/12/3 11:48
 */
public class Car02Test {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:IOC6.xml");

    @Test
    public void test01(){
        Object car = applicationContext.getBean("car");
        System.out.println(car);
    }
}

package com.lu.test;

import com.lu.service.Calculate;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lzs
 * @version 1.0
 * @date 2020/12/10 14:46
 */
public class AopXmlTest {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:IOC10.xml");

    @Test
    public void test01(){
        Calculate calculateNumber = (Calculate)applicationContext.getBean("calculateNumber");
        calculateNumber.add(1,0);
        calculateNumber.dev(1,0);
    }
}

package com.lu.test;

import com.lu.domain.Cat;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author lzs
 * @version 1.0
 * @date 2020/12/1 11:50
 */
public class CatTest {



    @Test
    public void cat01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:IOC3.xml");
        Cat cat01 = (Cat)applicationContext.getBean("cat01");
        System.out.println(cat01);
    }


}

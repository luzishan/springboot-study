package com.lu.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 *
 * @author lzs
 * @version 1.0
 * @date 2020/12/3 11:04
 */
public class DataSourceTest {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:IOC5.xml");



    @Test
    public void test01(){
        DataSource dataSource = (DataSource)applicationContext.getBean("dataSource");
        System.out.println(dataSource);
    }

}

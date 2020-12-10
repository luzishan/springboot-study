package com.lu.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author lzs
 * @version 1.0
 * @date 2020/12/3 11:04
 */
public class DataSourceAopTest {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:IOC9.xml");



    @Test
    public void test01(){
        DataSource dataSource = (DataSource)applicationContext.getBean("dataSource");
        try {
            Connection connection = dataSource.getConnection();

            connection.close();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println(dataSource);
    }

}

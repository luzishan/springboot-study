package com.lu.test;

import com.lu.domain.Car;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 对象创建的生命周期测试
 *
 * @author lzs
 * @version 1.0
 * @date 2020/12/2 11:32
 */
public class CarTest {

    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:IOC4.xml");

    @Test
    public void carTest() {
        Car car01 = (Car) applicationContext.getBean("car01");
        System.out.println(car01);
        applicationContext.close();
    }
}

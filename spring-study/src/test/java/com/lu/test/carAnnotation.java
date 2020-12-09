package com.lu.test;

import com.lu.controller.CarController;
import com.lu.service.CarService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lzs
 * @version 1.0
 * @date 2020/12/3 15:15
 */
public class carAnnotation {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:IOC7.xml");

    /*根据类的类型获取bean,如果你有多个则报错
    * No qualifying bean of type 'com.lu.controller.CarController'
    * available: expected single matching bean but found 2: carController,redCarController
    * */
    @Test
    public void test01(){
        CarController bean = applicationContext.getBean(CarController.class);
        bean.carSave();
    }

    /**
     * 根据类的字首字母小写获取，例如CarController > carController
     * 如果有多个同名字的类则报错：non-compatible bean definition of same name and class（同名的不兼容class）
     */
    @Test
    public void test02(){
        CarController bean = (CarController)applicationContext.getBean("carController");
        bean.carSave();
    }

    @Test
    public void test03(){
        CarService bean = (CarService)applicationContext.getBean("carService");
        bean.carSave();
    }
}

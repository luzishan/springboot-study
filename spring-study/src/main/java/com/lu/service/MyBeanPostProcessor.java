package com.lu.service;


import com.lu.domain.Car;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author lzs
 * @version 1.0
 * @date 2020/12/2 11:36
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    //对象的初始化前执行
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization" + beanName + "将要初始化");
        if(bean instanceof Car){
            ((Car) bean).setName("奔驰");
        }
        return bean;
    }

    //对象的初始化后执行
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization" + beanName + "初始化完成");
        if(bean instanceof Car){
            ((Car) bean).setName("奇瑞");
        }
        return bean;
    }
}

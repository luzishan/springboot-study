package com.lu.domain;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 测试bean的生命周期
 * @author lzs
 * @version 1.0
 * @date 2020/12/2 11:20
 */
@Data
public class Car{

    private String name;

    private int price;

    private CarColor carColor;

    public void carInit(){
        System.out.println("car开始初始化");
    }

    public  void carDestroy(){
        System.out.println("car销毁");
    }

    public Car(CarColor carColor) {
        this.carColor = carColor;
    }
}

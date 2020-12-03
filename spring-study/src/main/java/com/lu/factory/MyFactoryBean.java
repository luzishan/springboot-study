package com.lu.factory;

import com.lu.domain.Cat;
import org.springframework.beans.factory.FactoryBean;

/**
 * 实现spring FactoryBean
 * @author lzs
 * @version 1.0
 * @date 2020/12/2 11:07
 */
public class MyFactoryBean implements FactoryBean<Cat> {


    public Cat getObject() throws Exception {
        Cat cat = new Cat();
        cat.setAnimalName("猫11");
        cat.setNickName("加菲猫11");
        cat.setTags(4);
        return cat;
    }

    public Class<?> getObjectType() {
        return Cat.class;
    }

    public boolean isSingleton() {
        return true;
    }
}

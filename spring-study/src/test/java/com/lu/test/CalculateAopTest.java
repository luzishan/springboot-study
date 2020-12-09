package com.lu.test;

import com.lu.service.Calculate;
import com.lu.service.CalculateNumber;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lzs
 * @version 1.0
 * @date 2020/12/8 11:30
 */
public class CalculateAopTest {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:IOC8.xml");

    /*
    方法执行前
    方法执行后
    方法执行返回 */
    /*方法执行前
    方法执行返回
    方法执行后*/
    //spring的版本不同，通知方法的执行顺序也会有所不同
    //spring4版本正常情况：@Before 》 目标方法 》 @After 》 @AfterRetuning
            //  异常情况：@Before 》 目标方法 》 @After 》 @AfterThrowing

    //spring5版本正常情况：@Before 》 目标方法 》 @AfterRetuning 》@After
                //异常情况：@Before 》 目标方法 》 @AfterThrowing 》@After

    //被代理类实现了接口，则使用jdk的动态代理
    @Test
    public void aopTest1() {
        Calculate calculateNumber = (Calculate) applicationContext.getBean("calculateNumber");
        calculateNumber.add(1, 2);
        System.out.println("==========================================");
        calculateNumber.dev(2, 0);
        System.out.println(calculateNumber.getClass());
    }

    //被代理类没有实现任何接口，则使用cglib的动态代理
    @Test
    public void aopTest2(){
        Calculate calculateNumber = (Calculate)applicationContext.getBean("calculateNumber");
        calculateNumber.add(1,2);
        System.out.println("=============================================");
        calculateNumber.dev(1,1);
        //System.out.println(calculateNumber.getClass());
    }
}

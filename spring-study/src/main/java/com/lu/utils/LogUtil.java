package com.lu.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 记录日志类
 * @author lzs
 * @version 1.0
 * @date 2020/12/8 11:03
 */
@Aspect//标注这是个切面类
@Component
public class LogUtil {
    /*
     *1.编写切面类，并添加注解@Component到srping容器中,添加注解@Aspect表示这是一个切面类
     *2.在IOC8.xml配置文件中，开启注解包的扫描和开启aop的自动代理功能
     *3.在通知方法上添加通知时机的注解
     * 3.1@Before前置通知
     * 3.2@After后置通知
     * 3.3@AfterRetuning 后置返回通知
     * 3.4@AfterThrowing 后置异常通知
     * 3.5@Around 环绕通知
     *通知注解里面的表达式（执行器（方法的权限 方法的返回值 类的全路径.方法名（参数列表）））
     *  "*":可以表示:方法的权限/方法的返回值/类的全路径,表示一个或多个
     * "..":匹配任意数量、任意类型的参数
     *
     *
     * */

    @Before("execution(public * com.lu.service.CalculateNumber.*(..))")
    public void methodStart(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"方法执行前,参数分别是："+ Arrays.asList(joinPoint.getArgs()));
    }

    @After("execution(public * com.lu.service.CalculateNumber.*(..))")
    public void methodEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"方法执行后");
    }

    @AfterThrowing("execution(public * com.lu.service.CalculateNumber.*(..))")
    public void methodThrow(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"方法执行抛出异常");
    }

    @AfterReturning(value = "execution(public * com.lu.service.CalculateNumber.*(..))",returning = "result")
    public void methodReturn(JoinPoint joinPoint,Object result){
        System.out.println(joinPoint.getSignature().getName()+"方法执行返回结果是："+result);
    }


    public void methodRound(){
        System.out.println("环绕通知");
    }
}

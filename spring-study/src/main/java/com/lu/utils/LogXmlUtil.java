package com.lu.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 记录日志类
 *
 * @author lzs
 * @version 1.0
 * @date 2020/12/8 11:03
 */
public class LogXmlUtil {
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

    //抽取公用的切入点表达式
    //@Pointcut("execution(public * com.lu.service.CalculateNumber.*(..))")
    public void logPointCut() {

    }

    //@Before("logPointCut()")
    public void methodStart(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "方法执行前,参数分别是：" + Arrays.asList(joinPoint.getArgs()));
    }

    //@After("logPointCut()")
    public void methodEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "方法执行后");
    }

    //@AfterThrowing("logPointCut()")
    public void methodThrow(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "方法执行抛出异常");
    }

    //@AfterReturning(value = "logPointCut()", returning = "result")
    public void methodReturn(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName() + "方法执行返回结果是：" + result);
    }


    /*环绕通知是所有通知类型中功能最为强大的，能够全面地控制连接点，甚至可以控制是否执行连接点。
     *对于环绕通知来说，连接点的参数类型必须是ProceedingJoinPoint。它是 JoinPoint的子接口，允许控制何时执行，是否执行连接点。
     *在环绕通知中需要明确调用ProceedingJoinPoint的proceed()方法来执行被代理的方法。如果忘记这样做就会导致通知被执行了，但目标方法没有被执行。
     *注意：环绕通知的方法需要返回目标方法执行之后的结果，即调用 joinPoint.proceed();的返回值，否则会出现空指针异常
     *
     * */
    //@Around("logPointCut()")
    public Object methodRound(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("环绕通知前置");
        Object[] args = proceedingJoinPoint.getArgs();
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed(args);

            System.out.println("环绕通知返回:"+proceed);
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("环绕通知异常");
            throw new RuntimeException(e);
        } finally {
            System.out.println("环绕通知后置");
        }
        return proceed;
    }
}

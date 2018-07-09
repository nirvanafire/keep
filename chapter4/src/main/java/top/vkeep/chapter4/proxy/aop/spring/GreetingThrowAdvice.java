package top.vkeep.chapter4.proxy.aop.spring;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 抛出增强
 * 统一将异常信息记录到日志中，也可以持久化到数据库中
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.0
 * <p>@date: 2018-07-08
 **/
@Component
public class GreetingThrowAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, Exception e) {
        System.out.println("--------------Throw Exception--------------");
        System.out.println("Target Class: " + target.getClass().getName());
        System.out.println("Method Name: " + method.getName());
        System.out.println("Exception Message: " + e.getMessage());
        System.out.println("-------------------------------------------");
    }
}

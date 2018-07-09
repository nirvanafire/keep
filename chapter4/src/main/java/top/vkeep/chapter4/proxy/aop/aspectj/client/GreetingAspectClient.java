package top.vkeep.chapter4.proxy.aop.aspectj.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.vkeep.chapter4.proxy.aop.GreetingImpl;

/**
 * 基于注解
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@version: v1.0
 * <p>@date: 2018-07-09
 **/
public class GreetingAspectClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-aspectj.xml");
        GreetingImpl greetingImpl = (GreetingImpl) context.getBean("greetingImpl");
        greetingImpl.sayHello("aspectj");
        greetingImpl.goodMorning("aspectj");
        greetingImpl.goodNight("aspectj");
    }
}

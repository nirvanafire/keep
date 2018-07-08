package top.vkeep.chapter4.proxy.aop.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.vkeep.chapter4.proxy.aop.GreetingImpl;

/**
 * <p>@author: Zhourl
 * <p>@description: keep
 * <p>@version: v1.0
 * <p>@date: 2018/7/8
 **/
public class SpringAopAspectClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-aspect.xml");
        GreetingImpl greetingImpl = (GreetingImpl) context.getBean("greetingProxy");
        greetingImpl.sayHello("say hello");
        System.out.println("------------分割线--------------");
        greetingImpl.goodMorning("say good morning");
        System.out.println("------------分割线--------------");
        greetingImpl.goodNight("say good night");
    }
}

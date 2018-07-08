package top.vkeep.chapter4.proxy.aop.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.vkeep.chapter4.proxy.aop.Greeting;

/**
 * Spring AOP通过配置文件
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@version: v1.0
 * <p>@date: 2018-07-08
 **/
public class SpringConfigAopClient {
    public static void main(String[] args) {
        // 获取Spring Context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        // 从Context中根据id获取Bean对象（其实就是一个代理）
        Greeting greeting = (Greeting) context.getBean("greetingProxy");
        // 调用代理的方法
        greeting.sayHello("spring config aop");
    }
}

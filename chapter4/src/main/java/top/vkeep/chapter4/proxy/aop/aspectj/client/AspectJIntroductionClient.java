package top.vkeep.chapter4.proxy.aop.aspectj.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.vkeep.chapter4.proxy.aop.Greeting;
import top.vkeep.chapter4.proxy.aop.GreetingImpl;
import top.vkeep.chapter4.proxy.aop.spring.Apology;

/**
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.0
 * <p>@date: 2018-07-09
 **/
public class AspectJIntroductionClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-aspectj.xml");
        Greeting greeting = (GreetingImpl) context.getBean("greetingImpl");
        greeting.sayHello("View");

        Apology apology = (Apology) greeting;
        apology.saySorry("View");
    }
}

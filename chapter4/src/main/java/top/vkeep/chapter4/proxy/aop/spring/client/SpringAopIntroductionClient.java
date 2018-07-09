package top.vkeep.chapter4.proxy.aop.spring.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.vkeep.chapter4.proxy.aop.GreetingImpl;
import top.vkeep.chapter4.proxy.aop.spring.Apology;

/**
 * 引入增强
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.0
 * <p>@date: 2018-07-08
 **/
public class SpringAopIntroductionClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-introduction.xml");
        GreetingImpl greetingImpl = (GreetingImpl) context.getBean("greetingProxy");
        greetingImpl.sayHello("Spring Introduction Aop");

        // 将目标类强制向上转型为Apology接口
        // （这是引入增强给我们带来的特性，也就是"接口动态实现"功能）
        Apology apology = (Apology) greetingImpl;
        apology.saySorry("Spring Introduction Aop");
    }
}

package top.vkeep.chapter4.proxy.aop.client;

import org.springframework.aop.framework.ProxyFactory;
import top.vkeep.chapter4.proxy.aop.Greeting;
import top.vkeep.chapter4.proxy.aop.GreetingImpl;
import top.vkeep.chapter4.proxy.aop.spring.GreetingAfterAdvice;
import top.vkeep.chapter4.proxy.aop.spring.GreetingBeforeAdvice;
import top.vkeep.chapter4.proxy.aop.spring.GreetingBeforeAndAfterAdvice;

/**
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@version: v1.0
 * <p>@date: 2018/7/8
 **/
public class SpringAopClient {
    public static void main(String[] args) {
        // 创建代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        // 射入目标类对象
        proxyFactory.setTarget(new GreetingImpl());
        // 添加前置增强
        proxyFactory.addAdvice(new GreetingBeforeAdvice());
        // 添加后置增强
        proxyFactory.addAdvice(new GreetingAfterAdvice());
        // 添加前置和后置集合的增强
        proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());

        // 从代理工厂中获取代理
        Greeting greeting = (Greeting) proxyFactory.getProxy();

        // 调用代理的方法
        greeting.sayHello("spring aop");
    }
}

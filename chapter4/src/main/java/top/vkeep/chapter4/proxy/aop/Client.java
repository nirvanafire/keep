package top.vkeep.chapter4.proxy.aop;

/**
 * 静态代理、动态代理测试
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@version: v1.0
 * <p>@date: 2018/7/8
 **/
public class Client {
    public static void main(String[] args) {
        GreetingProxy proxy = new GreetingProxy(new GreetingImpl());
        proxy.sayHello("proxy");

        Greeting greeting = new JdkDynamicProxy(new GreetingImpl()).getProxy();
        greeting.sayHello("jdk");

        Greeting cglibProxy = CGLibDynamicProxy.getInstance().getProxy(GreetingImpl.class);
        cglibProxy.sayHello("cglib");
    }
}

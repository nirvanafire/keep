package top.vkeep.chapter4.proxy.dynamic;

import top.vkeep.chapter4.proxy.hello.Hello;
import top.vkeep.chapter4.proxy.hello.HelloImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK-实现的动态代理
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@version: v1.0
 * <p>@date: 2018/7/6
 **/
public class DynamicProxy implements InvocationHandler {

    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    /**
     * 封装Proxy.newProxyInstance获取代理对象的方法，
     * 避免程序内到处都是该方法。
     * @param <T>
     * @return
     */
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }

    public static void main(String[] args) {
        // 被代理的对象
        Hello hello = new HelloImpl();
        // 动态代理对象
        DynamicProxy dynamicProxy = new DynamicProxy(hello);
        /**
         * Proxy.newProxyInstance 入参
         * 1.ClassLoader
         * 2.该实现类的所有接口
         * 3.动态代理对象
         */
        Hello helloProxy = (Hello) Proxy.newProxyInstance(hello.getClass().getClassLoader(),
                hello.getClass().getInterfaces(), dynamicProxy);

        helloProxy.say("jack");

        helloProxy = dynamicProxy.getProxy();
        helloProxy.say("John");
    }
}

package top.vkeep.chapter4.proxy.aop;

import org.springframework.stereotype.Component;

/**
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@version: v1.0
 * <p>@date: 2018/7/8
 **/
@Component
public class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("hello! " + name);

        // 抛出一个异常，测试抛出增强
//        throw new RuntimeException("Error");
    }

    @Override
    public void goodMorning(String name) {
        System.out.println("Good Morning! " + name);
    }

    @Override
    public void goodNight(String name) {
        System.out.println("Good Night! " + name);
    }
}

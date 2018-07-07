package top.vkeep.chapter4.proxy.hello;

/**
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@version: v1.0
 * <p>@date: 2018/7/6
 **/
public class HelloImpl implements Hello {
    @Override
    public void say(String name) {
        System.out.println("Hello! " + name);
    }
}

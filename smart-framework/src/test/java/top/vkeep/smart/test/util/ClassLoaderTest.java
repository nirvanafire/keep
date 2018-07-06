package top.vkeep.smart.test.util;

import org.junit.Before;
import org.junit.Test;
import top.vkeep.smart.test.util.model.ClassLoaderObject;

/**
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@version: v1.0
 * <p>@date: 2018/7/6
 **/
public class ClassLoaderTest {
    private static ClassLoader classLoader;
    private static String clsName;

    @Before
    public void init() {
        classLoader = Thread.currentThread().getContextClassLoader();
        clsName = ClassLoaderObject.class.getName();
    }


    @Test
    public void ClassForNameTest() {
        try {
            /**
             * Class.forName加载Class类时，如果参数initialize被设置为false，则不会加载类中的静态代码块。
             * 否则，会加载代码中静态代码块，但是不会加载代码块。
             * 代码块的加载会在Class类调用newInstance()方法是被执行。
             */
            Class<?> cls = Class.forName(clsName, false, classLoader);
            System.out.println("----------分割线------------");
            cls.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void ClassLoaderTest() {
        try {
            /**
             * ClassLoader在加载Class类时，不会加载任何代码块。只有调用newInstance()方法时，
             * 静态代码块和代码块将被加载。
             */
            Class<?> cls = classLoader.loadClass(clsName);
            System.out.println("----------分割线------------");
            // 调用newInstance
            cls.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}

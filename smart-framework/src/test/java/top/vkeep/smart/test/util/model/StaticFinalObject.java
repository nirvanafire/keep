package top.vkeep.smart.test.util.model;

/**
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@version: v1.0
 * <p>@date: 2018/7/6
 **/
public class StaticFinalObject {
    static {
        System.out.println(StaticFinalObject.class.getName() + " static code block loaded...");
    }

    {
        System.out.println(StaticFinalObject.class.getName() + " code block loaded...");
    }

}

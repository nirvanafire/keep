package top.vkeep.smart.test.util.model;

/**
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.0
 * <p>@date: 2018/7/6
 **/
public class StaticObject {
    static {
        System.out.println(StaticObject.class.getName() + " static code block loaded...");
    }

    {
        System.out.println(StaticObject.class.getName() + " code block loaded...");
    }

}

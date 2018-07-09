package top.vkeep.smart.test.util.model;

/**
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.0
 * <p>@date: 2018/7/6
 **/
public class ClassLoaderObject {
    public static final StaticFinalObject sfo = new StaticFinalObject();

    public static StaticObject so = new StaticObject();

    static {
        System.out.println("static code block loaded...");
    }

    {
        System.out.println("code block loaded...");
    }

}

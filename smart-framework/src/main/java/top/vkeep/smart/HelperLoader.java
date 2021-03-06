package top.vkeep.smart;

import top.vkeep.smart.helper.*;
import top.vkeep.smart.util.ClassUtil;

/**
 * 加载相应的Helper类
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.0
 * <p>@date: 2018/7/4
 **/
public class HelperLoader {
    public static void init() {
        Class<?>[] classList = {ClassHelper.class,
                BeanHelper.class,
                AopHelper.class,
                IocHelper.class,
                ControllerHelper.class};

        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(), true);
        }
    }
}

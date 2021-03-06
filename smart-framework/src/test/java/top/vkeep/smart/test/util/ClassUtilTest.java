package top.vkeep.smart.test.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

import static top.vkeep.smart.util.ClassUtil.getClassSet;

/**
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.0
 * <p>@date: 2018/7/5
 **/
public class ClassUtilTest {

    @Test
    public void getClassSetTest() {
        Set<Class<?>> classSet = getClassSet("top.vkeep.smart.test.util");
        Assert.assertEquals(5, classSet.size());
    }

}

package top.vkeep.smart.test.helper;

import org.junit.Assert;
import org.junit.Test;
import top.vkeep.smart.annotation.Controller;
import top.vkeep.smart.test.helper.model.ParentObject;

import java.util.Set;

import static top.vkeep.smart.helper.ClassHelper.*;

/**
 * ClassHelper Test
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-11
 **/
public class ClassHelperTest {

    @Test
    public void getClassSetBySuperTest() {
        System.out.println("-----Begin Test-----");
        Set<Class<?>> classSetBySuper = getClassSetBySuper(ParentObject.class);

        for (Class<?> cls : classSetBySuper) {
            System.out.println("Name: " + cls.getName());
        }

        Assert.assertEquals(2, classSetBySuper.size());
    }

    @Test
    public void getClassSetByAnnotationTest() {
        System.out.println("-----Begin Test-----");
        Set<Class<?>> classSetByAnnotation = getClassSetByAnnotation(Controller.class);

        for (Class<?> cls : classSetByAnnotation) {
            System.out.println("Name: " + cls.getName());
        }

        Assert.assertEquals(1, classSetByAnnotation.size());
    }
}

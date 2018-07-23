package top.vkeep.smart.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.vkeep.smart.annotation.Controller;
import top.vkeep.smart.annotation.Service;
import top.vkeep.smart.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

/**
 * 类操作助手类
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.0
 * <p>@date: 2018/7/3
 **/
public final class ClassHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassHelper.class);

    /**
     * 定义类集合（用于存放所加载的类）
     */
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);

        LOGGER.debug("CLASS_SET SIZE: " + CLASS_SET.size());
    }

    /**
     * 获取应用包名下的所有类
     */
    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    /**
     * 获取应用包名下所有Service类
     */
    public static Set<Class<?>> getServiceClassSet() {
        Set<Class<?>> classSet = new HashSet<>();

        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Service.class)) {
                classSet.add(cls);
            }
        }

        return classSet;
    }

    /**
     * 获取应用包名下所有Controller类
     */
    public static Set<Class<?>> getControllerClassSet() {
        Set<Class<?>> classSet = new HashSet<>();

        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Controller.class)) {
                classSet.add(cls);
            }
        }

        return classSet;
    }

    /**
     * 获取应用包名下所有Bean类（包括：Service、Controller等）
     */
    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> classSet = new HashSet<>();
        classSet.addAll(getServiceClassSet());
        classSet.addAll(getControllerClassSet());
        return classSet;
    }

    /**
     * 获取应用包名下某个父类（或接口）的所有子类（或实现类）
     */
    public static Set<Class<?>> getClassSetBySuper(Class<?> superClass) {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> cls : CLASS_SET) {
            /**
             * Determines if the class or interface represented by this Class object is either the same as,
             * or is a superclass or superinterface of, the class or interface represented by the specified Class parameter.
             *
             * 确定此Class对象表示的类或接口是否与指定的Class参数表示的类或接口相同，或者是它们的超类或超接口。
             */
            if (superClass.isAssignableFrom(cls) && !superClass.equals(cls)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包名下带有某个注解的所有类
     */
    public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotationClass) {
        Set<Class<?>> classSet = new HashSet<>();

        for (Class<?> cls : CLASS_SET) {
            /**
             * Returns true if an annotation for the specified type is present on this element, else false.
             * This method is designed primarily for convenient access to marker annotations.
             *
             * 如果此元素上存在指定类型的注释，则返回true，否则返回false。 此方法主要用于方便地访问标记注释。
             */
            if (cls.isAnnotationPresent(annotationClass)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }
}

package top.vkeep.smart.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.vkeep.smart.annotation.Aspect;
import top.vkeep.smart.annotation.Service;
import top.vkeep.smart.proxy.AspectProxy;
import top.vkeep.smart.proxy.Proxy;
import top.vkeep.smart.proxy.ProxyManager;
import top.vkeep.smart.proxy.TransactionProxy;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * AOP助手类
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-10
 **/
public class AopHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(AopHelper.class);

    static {
        try {
            Map<Class<?>, Set<Class<?>>> proxyMap = createProxyMap();
            Map<Class<?>, List<Proxy>> targetMap = createTargetMap(proxyMap);

            for (Map.Entry<Class<?>, List<Proxy>> targetEntry : targetMap.entrySet()) {
                Class<?> targetClass = targetEntry.getKey();
                List<Proxy> proxyList = targetEntry.getValue();
                Object proxy = ProxyManager.createProxy(targetClass, proxyList);
                BeanHelper.setBean(targetClass, proxy);
            }

            LOGGER.debug("ProxyMap size: " + proxyMap.size());
            LOGGER.debug("TargetMap size: " + targetMap.size());
        } catch (Exception e) {
            LOGGER.error("aop failure", e);
        }
    }


    /**
     * 获取@Aspect注解内value（标签）所注解的类集合
     */
    private static Set<Class<?>> createTargetClassSet(Aspect aspect) {
        Set<Class<?>> targetClassSet = new HashSet<>();
        Class<? extends Annotation> annotation = aspect.value();
        if (annotation != null && !annotation.equals(Aspect.class)) {
            targetClassSet.addAll(ClassHelper.getClassSetByAnnotation(annotation));
        }
        return targetClassSet;
    }

    /**
     * 一个代理类（切面类）可以对应多个目标类
     */
    private static Map<Class<?>, Set<Class<?>>> createProxyMap() {
        Map<Class<?>, Set<Class<?>>> proxyMap = new HashMap<>();
        addAspectProxy(proxyMap);
        addTransactionProxy(proxyMap);
        return proxyMap;
    }

    /**
     * 添加普通切面
     */
    private static void addAspectProxy(Map<Class<?>, Set<Class<?>>> proxyMap) {
        // 获取所有继承或实现当前类的子类或者实现
        Set<Class<?>> proxyClassSet = ClassHelper.getClassSetBySuper(AspectProxy.class);
        for (Class<?> proxyClass : proxyClassSet) {
            // 校验类上是否有@Aspect注解
            if (proxyClass.isAnnotationPresent(Aspect.class)) {
                Aspect aspect = proxyClass.getAnnotation(Aspect.class);
                // 获取指定注解所有Bean Set
                Set<Class<?>> targetClassSet = createTargetClassSet(aspect);
                proxyMap.put(proxyClass, targetClassSet);
            }
        }

    }

    /**
     * 添加事务切面
     */
    private static void addTransactionProxy(Map<Class<?>, Set<Class<?>>> proxyMap) {
        // 获取所有继承或实现当前类的子类或者实现
        Set<Class<?>> serviceClassSet = ClassHelper.getClassSetBySuper(Service.class);
        proxyMap.put(TransactionProxy.class, serviceClassSet);
    }

    /**
     *  代理类需要扩展AspectProxy抽象类，还需要Aspect注解，只有满足这两个条件，
     *  才能根据Aspect注解中所定义的注解属性去获取注解所对应的目标类结合。
     */
    private static Map<Class<?>, List<Proxy>> createTargetMap(Map<Class<?>, Set<Class<?>>> proxyMap) throws IllegalAccessException, InstantiationException {

        Map<Class<?>, List<Proxy>> targetMap = new HashMap<>();

        for (Map.Entry<Class<?>, Set<Class<?>>> proxyEntry : proxyMap.entrySet()) {
            Class<?> proxyClass = proxyEntry.getKey();
            Set<Class<?>> targetClassSet = proxyEntry.getValue();

            for (Class<?> targetClass : targetClassSet) {
                Proxy proxy = (Proxy) proxyClass.newInstance();
                if (targetMap.containsKey(targetClass)) {
                    targetMap.get(targetClass).add(proxy);
                } else {
                    List<Proxy> proxyList = new ArrayList<>();
                    proxyList.add(proxy);
                    targetMap.put(targetClass, proxyList);
                }
            }
        }
        return targetMap;
    }


}

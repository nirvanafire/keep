package top.vkeep.chapter4.proxy.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 基于注解
 * 通过AspectJ @annotation 表达式拦截方法
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.0
 * <p>@date: 2018-07-09
 **/
@Aspect
@Component
public class GreetingAspectWithAnnotation {
    @Around("@annotation(top.vkeep.chapter4.proxy.aop.aspectj.annotation.Tag)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        before();
        Object result = pjp.proceed();
        after();
        return result;
    }

    public void before() {
        System.out.println("Annotation Before");
    }

    public void after() {
        System.out.println("Annotation After");
    }
}

package top.vkeep.chapter4.proxy.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;
import top.vkeep.chapter4.proxy.aop.spring.Apology;

/**
 * 基于注解
 * 通过AspectJ execution表达式拦截方法
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.0
 * <p>@date: 2018-07-09
 **/
@Aspect
@Component
public class GreetingAspect {

    @DeclareParents(value = "top.vkeep.chapter4.proxy.aop.GreetingImpl",
    defaultImpl = ApologyImpl.class)
    private Apology apology;

    @Around("execution(* top.vkeep.chapter4.proxy.aop.GreetingImpl.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        before();
        Object result = pjp.proceed();
        after();
        return result;
    }

    public void before() {
        System.out.println("Before");
    }

    public void after() {
        System.out.println("After");
    }
}

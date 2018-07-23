package top.vkeep.chapter4.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.vkeep.smart.annotation.Aspect;
import top.vkeep.smart.annotation.Service;
import top.vkeep.smart.proxy.AspectProxy;

import java.lang.reflect.Method;

/**
 * Controller Aspect
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-10
 **/
@Aspect(Service.class)
public class ServiceAspect extends AspectProxy {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceAspect.class);

    private long begin;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        LOGGER.debug("---------- begin ----------");
        LOGGER.debug(String.format("class: %s", cls.getName()));
        LOGGER.debug(String.format("method: %s", method.getName()));
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
        LOGGER.debug(String.format("time: %dms", System.currentTimeMillis() - begin));
        LOGGER.debug("---------- end ----------");
    }
}

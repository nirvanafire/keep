package top.vkeep.smart.plugin.security;

import org.apache.shiro.web.env.EnvironmentLoaderListener;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

/**
 * Smart Security 插件
 *
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-18
 **/
public class SmartSecurityPlugin implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        // 设置初始化参数
        ctx.setInitParameter("shiroConfigLocations", "classpath:smart-security.ini");
        // 注册Listener
        ctx.addListener(EnvironmentLoaderListener.class);
        // 注册Filter
        FilterRegistration.Dynamic smartSecurityFilter = ctx.addFilter("SmartSecurityFilter", SmartSecurityFilter.class);
        smartSecurityFilter.addMappingForUrlPatterns(null, false, "/*");
    }
}

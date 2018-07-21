package top.vkeep.security.showcase.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.vkeep.security.showcase.service.impl.UserServiceImpl;
import top.vkeep.smart.annotation.Action;
import top.vkeep.smart.annotation.Controller;
import top.vkeep.smart.annotation.Inject;
import top.vkeep.smart.bean.Param;
import top.vkeep.smart.bean.View;
import top.vkeep.smart.plugin.security.SecurityHelper;
import top.vkeep.smart.plugin.security.exception.AuthcException;

/**
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-21
 **/
@Controller
public class SystemController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SystemController.class);

    @Inject
    private UserServiceImpl userService;

    /**
     * 进入首页界面
     */
    @Action("get:/")
    public View index() {
        return new View("index.jsp");
    }

    /**
     * 进入登录界面
     */
    @Action("get:/login")
    public View login() {
        return new View("login.jsp");
    }

    /**
     * 提交登录表单
     */
    @Action("post:/login")
    public View loginSubmit(Param param) {
        String username = param.getString("username");
        String password = param.getString("password");

        try {
            SecurityHelper.login(username, password);
        } catch (AuthcException e) {
            LOGGER.warn("用户名/密码错误", e);
            return  new View("/login");
        }

        return new View("/");
    }

    /**
     * 提交注销请求
     */
    @Action("get:/logout")
    public View logout() {
        SecurityHelper.logout();
        return new View("/");
    }

    @Action("get:/register")
    public View toRegister() {
        return new View("register.jsp");
    }

    @Action("post:/register")
    public View register(Param param) {
        String username = param.getString("username");
        String password = param.getString("password");

        userService.save(username, password);
        return new View("/");
    }

    @Action("get:/space")
    public View space() {
        return new View("space.jsp");
    }

    @Action("get:/setting")
    @top.vkeep.smart.plugin.security.annotation.User
    public View setting() {
        return new View("setting.jsp");
    }
}

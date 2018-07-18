package top.vkeep.chapter5.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.vkeep.smart.annotation.Action;
import top.vkeep.smart.annotation.Controller;
import top.vkeep.smart.bean.Param;
import top.vkeep.smart.bean.View;

/**
 * 处理系统请求
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-18
 **/
@Controller
public class SystemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemController.class);

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
        return new View("/customer");
    }

    /**
     * 提交注销请求
     */
    @Action("get:/logout")
    public View logout() {
        return new View("/");
    }
}

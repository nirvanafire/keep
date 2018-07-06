package top.vkeep.chapter3.controller;

import top.vkeep.chapter3.service.DemoService;
import top.vkeep.smart.annotation.Action;
import top.vkeep.smart.annotation.Controller;
import top.vkeep.smart.annotation.Inject;
import top.vkeep.smart.bean.Param;
import top.vkeep.smart.bean.View;

/**
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@version: v1.0
 * <p>@date: 2018/7/5
 **/
@Controller
public class DemoController {
    @Inject
    private DemoService demoService;

    @Action("get:/index")
    public View index(Param param) {
        demoService.sayHello();
        return new View("index.jsp");
    }
}

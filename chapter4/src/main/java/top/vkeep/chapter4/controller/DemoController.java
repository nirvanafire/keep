package top.vkeep.chapter4.controller;

import top.vkeep.chapter4.service.DemoService;
import top.vkeep.smart.annotation.Action;
import top.vkeep.smart.annotation.Controller;
import top.vkeep.smart.annotation.Inject;
import top.vkeep.smart.bean.Data;
import top.vkeep.smart.bean.Param;

/**
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-13
 **/
@Controller
public class DemoController {

    @Inject
    private DemoService demoService;

    @Action("get:/demo")
    public Data demo(Param param) {
        System.out.println("DemoController... demoService is not null:" + (demoService != null));
        demoService.demo();
        return new Data("Hello");
    }
}

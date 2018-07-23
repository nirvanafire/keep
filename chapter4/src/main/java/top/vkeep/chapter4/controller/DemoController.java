package top.vkeep.chapter4.controller;

import top.vkeep.chapter4.service.DemoService;
import top.vkeep.smart.annotation.Action;
import top.vkeep.smart.annotation.Controller;
import top.vkeep.smart.annotation.Inject;
import top.vkeep.smart.bean.Data;

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
    public Data demo() {
        // 如果请求没有参数，请务必不设置Param param参数
        System.out.println("DemoController... demoService is not null:" + (demoService != null));
        demoService.demo();
        return new Data("Hello");
    }
}

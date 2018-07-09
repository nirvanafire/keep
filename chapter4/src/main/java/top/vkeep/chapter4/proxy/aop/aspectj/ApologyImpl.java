package top.vkeep.chapter4.proxy.aop.aspectj;

import top.vkeep.chapter4.proxy.aop.spring.Apology;

/**
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.0
 * <p>@date: 2018-07-09
 **/
public class ApologyImpl implements Apology {
    @Override
    public void saySorry(String name) {
        System.out.println("Sorry! " + name);
    }
}

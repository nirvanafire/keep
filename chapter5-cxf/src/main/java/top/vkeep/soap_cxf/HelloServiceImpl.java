package top.vkeep.soap_cxf;

import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-27
 **/
@WebService
@Component
public class HelloServiceImpl implements HelloService {
    @Override
    public String say(String name) {
        return "hello, " + name;
    }

    @Override
    public String said(String name) {
        return "said hello, " + name;
    }
}

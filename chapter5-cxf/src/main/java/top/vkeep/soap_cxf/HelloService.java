package top.vkeep.soap_cxf;

import javax.jws.WebService;

/**
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-27
 **/
@WebService
public interface HelloService {

    String say(String name);

    String said(String name);
}

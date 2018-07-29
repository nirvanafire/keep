package top.vkeep.soap_cxf;

import org.apache.cxf.frontend.ServerFactoryBean;

/**
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-27
 **/
public class SimpleServer {
    public static void main(String[] args) {
        ServerFactoryBean factory = new ServerFactoryBean();
        factory.setAddress("http://localhost:9080/ws/soap/hello");
        factory.setServiceClass(HelloService.class);
        factory.setServiceBean(new HelloServiceImpl());

        factory.create();

        System.out.println("soap ws is published");
    }
}

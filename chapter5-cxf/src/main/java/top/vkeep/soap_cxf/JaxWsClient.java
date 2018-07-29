package top.vkeep.soap_cxf;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * 静态代理客户端
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-27
 **/
public class JaxWsClient {

    public static void main(String[] args) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

        factory.setAddress("http://localhost:9080/ws/soap/hello");
        factory.setServiceClass(HelloService.class);

        HelloService helloService = factory.create(HelloService.class);
        String result = helloService.say("world");

        System.out.println(result);

    }
}

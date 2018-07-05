package top.vkeep.smart;

/**
 * 提供相关配置项常量
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@version: v1.0
 * <p>@date: 2018/7/3
 **/
public interface ConfigConstant {

    /**
     * 配置文件名称
     */
    String CONFIG_FILE = "smart.properties";

    /**
     * JDBC Driver
     */
    String JDBC_DRIVER = "smart.framework.jdbc.driver";
    /**
     * JDBC URL
     */
    String JDBC_URL = "smart.framework.jdbc.url";
    /**
     * JDBC USERNAME
     */
    String JDBC_USERNAME = "smart.framework.jdbc.username";
    /**
     * JDBC PASSWORD
     */
    String JDBC_PASSWORD = "smart.framework.jdbc.password";

    /**
     * 默认扫描基础包
     */
    String APP_BASE_PAGE = "smart.framework.app.base_package";
    /**
     * 默认JSP页面存放路径
     */
    String APP_JSP_PATH = "smart.framework.app.jsp_path";
    /**
     * 默认静态文件存放路径
     */
    String APP_ASSERT_PATH = "smart.framework.app.assert_path";
}

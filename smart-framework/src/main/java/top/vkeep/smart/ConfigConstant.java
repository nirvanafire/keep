package top.vkeep.smart;

/**
 * 提供相关配置项常量
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@version: v1.0
 * <p>@date: 2018/7/3
 **/
public interface ConfigConstant {

    String CONFIG_FILE = "smart.properties";

    String JDBC_DRIVER = "smart.framework.jdbc.driver";
    String JDBC_URL = "smart.framework.jdbc.url";
    String JDBC_USERNAME = "smart.framework.jdbc.username";
    String JDBC_PASSWORD = "smart.framework.jdbc.password";

    String APP_BASE_PAGE = "smart.framework..app.base_package";
    String APP_JSP_PATH = "smart.framework.app.jsp_path";
    String APP_ASSERT_PATH = "smart.framework.app.assert_path";
}

package top.vkeep.smart.plugin.security.realm;

import org.apache.shiro.realm.jdbc.JdbcRealm;
import top.vkeep.smart.helper.DatabaseHelper;
import top.vkeep.smart.plugin.security.SecurityConfig;
import top.vkeep.smart.plugin.security.password.Md5CredentialsMatcher;

/**
 * 基于Smart的JDBC Realm（需要提供相关smart.plugin.security.jdbc.*配置项）
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-20
 **/
public class SmartJdbcRealm extends JdbcRealm {

    public SmartJdbcRealm() {
        super.setDataSource(DatabaseHelper.getDataSource());
        super.setAuthenticationQuery(SecurityConfig.getJdbcAuthcQuery());
        super.setUserRolesQuery(SecurityConfig.getJdbcRolesQuery());
        super.setPermissionsQuery(SecurityConfig.getJdbcPermissionsQuery());
        super.setPermissionsLookupEnabled(true);
        // 使用MD5加密
        super.setCredentialsMatcher(new Md5CredentialsMatcher());
    }
}

package top.vkeep.smart.plugin.security;

import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;

import java.util.HashSet;
import java.util.Set;

/**
 * 安全过滤器
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-18
 **/
public class SmartSecurityFilter extends ShiroFilter {
    @Override
    public void init() throws Exception {
        super.init();
        WebSecurityManager webSecurityManager = super.getSecurityManager();
        // 设置Realm，可同时支持多个Realm，并按照先后顺序用逗号分割

        // 设置Cache，用于减少数据库查询次数，降低I/O访问
    }

    public void setRealm(WebSecurityManager webSecurityManager) {
        // 读取smart.plugin.security.realm配置项
        String securityRealms = SecurityConfig.getRealms();
        if (securityRealms != null) {
            // 根据逗号进行拆分
            String[] securityRealmArray = securityRealms.split(",");
            if (securityRealmArray.length > 0) {
                // 事Realm具备唯一性与顺序性
                Set<Realm> realms = new HashSet<>();
                for (String securityRealm : securityRealmArray) {
                    if (securityRealm.equalsIgnoreCase(SecurityConstant.REALMS_JDBC)) {
                        // 添加基于JDBC的Realm，需配置相关SQL查询语句

                    } else if (securityRealm.equalsIgnoreCase(SecurityConstant.REALMS_CUSTOM)) {
                        // 添加基于定制化的Realm，需实现SmartSecurity接口
                    }
                }
                RealmSecurityManager realmSecurityManager = (RealmSecurityManager) webSecurityManager;
                realmSecurityManager.setRealms(realms);

            }
        }
    }

    private void addJdbcRealm(Set<Realm> realms) {
        // 添加自己实现的基于JDBC的Realm
        
    }
}

package top.vkeep.smart.plugin.security;

import java.util.Set;

/**
 * Smart Security接口
 * <br/>
 * 可在应用中实现该接口，或者在smart.properties文件中提供以下基于SQL的配置项：
 * <ul>
 *     <li>smart.plugin.security.jdbc.authc_query：根据用户名获取密码</li>
 *     <li>smart.plugin.security.jdbc.roles_query：根据用户名获取角色名集合</li>
 *     <li>smart.plugin.security.jdbc.permissions_query：根据角色名获取权限名集合</li>
 * </ul>
 *
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-17
 **/
public interface SmartSecurity {

    /**
     * 根据用户名获取密码
     * @param username 用户名
     * @return 密码
     */
    String getPassword(String username);

    /**
     * 根据用户名获取角色名集合
     * @param username 用户名
     * @return 角色名集合
     */
    Set<String> getRoleNameSet(String username);

    /**
     * 根据角色名获取权限名集合
     * @param roleName 角色名
     * @return 权限名集合
     */
    Set<String> getPermissionNameSet(String roleName);
}

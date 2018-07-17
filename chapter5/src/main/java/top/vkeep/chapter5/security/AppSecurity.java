package top.vkeep.chapter5.security;

import top.vkeep.smart.helper.DatabaseHelper;
import top.vkeep.smart.plugin.security.SmartSecurity;

import java.util.Set;

/**
 * 应用安全控制
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-17
 **/
public class AppSecurity implements SmartSecurity {
    @Override
    public String getPassword(String username) {
        String sql = "SELECT password FROM user WHERE username = ?";
        return DatabaseHelper.query(sql, username);
    }

    @Override
    public Set<String> getRoleNameSet(String username) {
        String sql = "select r.role_name from user u, user_role ur, role r where u.id = ur.user_id " +
                "and r.id = ur.role_id and u.username = ?";
        return DatabaseHelper.querySet(sql, username);
    }

    @Override
    public Set<String> getPermissionNameSet(String roleName) {
        String sql = "select p.permission_name from role r, role_permission rp, permission p where r.id = rp.role_id " +
                "and p.id = rp.permission_id and r.role_name = ?";
        return DatabaseHelper.querySet(sql, roleName);
    }
}

package top.vkeep.security.showcase.security;

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
        String sql = "SELECT r.role_name from user u, user_role ur, role r WHERE u.id = ur.user_id " +
                "AND r.id = ur.role_id AND u.username = ?";
        return DatabaseHelper.querySet(sql, username);
    }

    @Override
    public Set<String> getPermissionNameSet(String roleName) {
        String sql = "SELECT p.permission_name from role r, role_permission rp, permission p WHERE r.id = rp.role_id " +
                "AND p.id = rp.permission_id and r.role_name = ?";
        return DatabaseHelper.querySet(sql, roleName);
    }
}

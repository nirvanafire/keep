package top.vkeep.smart.plugin.security.tag;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.tags.PermissionTag;
import top.vkeep.smart.util.CollectionUtil;

import java.util.Arrays;
import java.util.List;

/**
 * 判断当前用户是否拥有某一种权限（逗号分隔，表示"或"的关系）
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-20
 **/
public class HasAnyPermissionsTag extends PermissionTag {

    private static final String PERMISSION_NAME_DELIMITER = ",";

    @Override
    protected boolean showTagBody(String permissions) {
        boolean hasAnyPermission = false;
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            List<String> permissionList = Arrays.asList(permissions.split(PERMISSION_NAME_DELIMITER));
            if (CollectionUtil.isNotEmpty(permissionList)) {
                for (String permission : permissionList) {
                    if (subject.isPermitted(permission)) {
                        hasAnyPermission = true;
                        break;
                    }
                }
            }
        }
        return hasAnyPermission;
    }
}

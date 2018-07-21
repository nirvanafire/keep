package top.vkeep.smart.plugin.security.tag;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.tags.PermissionTag;

/**
 * 判断当前用户是否拥有某一种权限（逗号分隔，表示"或"的关系）
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-20
 **/
public class HasAllPermissionsTag extends PermissionTag {

    private static final String PERMISSION_NAME_DELIMITER = ",";

    @Override
    protected boolean showTagBody(String permissions) {
        boolean hasAllPermission = false;
        Subject subject = getSubject();
        if (subject != null) {
            if (subject.isPermittedAll(permissions.split(PERMISSION_NAME_DELIMITER))) {
                hasAllPermission = true;
            }
        }
        return hasAllPermission;
    }
}

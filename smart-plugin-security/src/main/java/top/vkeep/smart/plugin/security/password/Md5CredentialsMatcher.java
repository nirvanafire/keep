package top.vkeep.smart.plugin.security.password;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import top.vkeep.smart.util.CodecUtil;

/**
 * MD5密码匹配器
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-20
 **/
public class Md5CredentialsMatcher implements CredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        // 获取从表单提交过来的密码、明文、尚未通过MD5加密
        String submitted = String.valueOf(((UsernamePasswordToken) token).getPassword());
        // 获取数据库中存储的密码，已通过MD5加密
        String encrypted = String.valueOf((char[]) info.getCredentials());
        return CodecUtil.md5(submitted).equals(encrypted);
    }
}

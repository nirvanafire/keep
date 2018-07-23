package top.vkeep.smart.plugin.security.exception;

/**
 * 授权异常（当权限无效时抛出）
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-18
 **/
public class AuthzException extends RuntimeException {
    public AuthzException() {
    }

    public AuthzException(String message) {
        super(message);
    }

    public AuthzException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthzException(Throwable cause) {
        super(cause);
    }
}

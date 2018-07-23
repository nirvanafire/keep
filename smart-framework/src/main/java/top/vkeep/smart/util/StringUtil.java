package top.vkeep.smart.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.0
 * <p>@date: 2018/7/1
 **/
public final class StringUtil {

    /**
     * 字符串分隔符
     */
    public static final String SEPARATOR = String.valueOf((char) 29);

    /**
     * 私有化构造器
     */
    private StringUtil() {
        super();
    }

    /**
     * 判断字符串是否为空return
     */
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否非空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 分割字符串
     */
    public static String[] splitString(String body, String s) {
        return body.split(s);
    }
}

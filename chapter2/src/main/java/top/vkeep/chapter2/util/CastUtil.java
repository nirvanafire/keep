package top.vkeep.chapter2.util;

/**
 * 转换操作工具类
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.0
 * <p>@date: 2018/7/1
 **/
public final class CastUtil {

    /**
     * 转为String型
     */
    public static String castString(Object obj) {
        return castString(obj, "");
    }

    /**
     * 转为String型（提供默认值）
     */
    public static String castString(Object obj, String defaultValue) {
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    /**
     * 转为double型
     */
    public static double castDouble(Object obj) {
        return CastUtil.castDouble(obj, 0);
    }

    /**
     * 转为double型（提供默认值）
     */
    public static double castDouble(Object obj, double defaultValue) {
        double doubleValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    doubleValue = Double.parseDouble(strValue);
                } catch (NumberFormatException e) {
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }

    /**
     * 转为long型
     */
    public static long caseLong(Object obj) {
        return caseLong(obj, 0);
    }

    /**
     * 转为long型（提供默认值）
     */
    public static long caseLong(Object obj, long defaultValue) {
        long longValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    longValue = Long.parseLong(strValue);
                } catch (NumberFormatException e) {
                    longValue = defaultValue;
                }
            }
        }
        return longValue;
    }

    /**
     * 转为int型
     */
    public static int caseInt(Object obj) {
        return CastUtil.caseInt(obj, 0);
    }

    /**
     * 转为int型（提供默认值）
     */
    public static int caseInt(Object obj, int defaultValue) {
        int intValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    intValue = Integer.parseInt(strValue);
                } catch (NumberFormatException e) {
                    intValue = defaultValue;
                }
            }
        }
        return intValue;
    }

    /**
     * 转为boolean型
     */
    public static boolean caseBoolean(Object obj) {
        return CastUtil.caseBoolean(obj, false);
    }

    /**
     * 转为boolean型（提供默认值）
     */
    public static boolean caseBoolean(Object obj, boolean defaultValue) {
        boolean booleanValue = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    booleanValue = Boolean.valueOf(strValue);
                } catch (NumberFormatException e) {
                    booleanValue = defaultValue;
                }
            }
        }
        return booleanValue;
    }
}

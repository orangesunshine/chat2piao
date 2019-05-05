package com.orange.chat2piao.utils;

public class BeanUtils {
    /**
     * 判断参数不为空
     * @param target
     */
    public static void checkNotNull(Object target) {
        if (null == target) throw new NullPointerException("target must not be null !");
    }

    /**
     * 判断多个参数不为空
     * @param targets
     */
    public static void checkNotNull(Object... targets) {
        if (null == targets) throw new NullPointerException("targets must not be null !");
        for (Object target : targets) {
            checkNotNull(target);
        }
    }
}

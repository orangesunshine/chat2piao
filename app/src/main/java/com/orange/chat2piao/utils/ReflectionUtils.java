package com.orange.chat2piao.utils;

import com.orange.chat2piao.base.ifc.callback.ILoadingNetCallback;
import com.orange.chat2piao.base.ifc.callback.IPullNetCallback;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectionUtils {
    /**
     * 获取泛型T的type
     *
     * @param callback
     * @param <T>
     * @return
     */
    public static <T> Type getGenericSuperclassActualTypeArgClass(IPullNetCallback<T> callback) {
        Preconditions.checkNotNull(callback, "null == callback");
        Type genericSuperclass = callback.getClass().getGenericSuperclass();
        if (null != genericSuperclass && genericSuperclass instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            if (null != actualTypeArguments && actualTypeArguments.length > 0)
                return actualTypeArguments[0];
        }
        return null;
    }

    /**
     * 获取泛型T的type
     *
     * @param callback
     * @param <T>
     * @return
     */
    public static <T> Type getGenericSuperclassActualTypeArgClass(ILoadingNetCallback<T> callback) {
        Preconditions.checkNotNull(callback, "null == callback");
        Type genericSuperclass = callback.getClass().getGenericSuperclass();
        if (null != genericSuperclass && genericSuperclass instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            if (null != actualTypeArguments && actualTypeArguments.length > 0)
                return actualTypeArguments[0];
        }
        return null;
    }
}

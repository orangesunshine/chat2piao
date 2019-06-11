package com.orange.chat2piao.utils;

import com.orange.chat2piao.base.demo.activity.BasePullNetActivityDemo;
import com.orange.chat2piao.base.ifc.callback.ILoadingNetCallback;
import com.orange.chat2piao.base.ifc.callback.IPullNetCallback;
import com.orange.chat2piao.base.impl.presenter.BasePresenter;
import com.orange.chat2piao.base.ui.activity.base.PresenterActivity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class ReflectionUtils {
    /**
     * 获取父类（IPullNetCallback）泛型实参类型
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
     * 获取父类（ILoadingNetCallback）泛型实参类型
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

    /**
     * 获取父类（PresenterActivity）泛型实参类型的实例
     *
     * @param presenterActivity
     * @param <P>
     * @return
     */
    public static <P extends BasePresenter> P getGenericSuperclassActualTypeArgInstance(PresenterActivity<P> presenterActivity) {
        Preconditions.checkNotNull(presenterActivity);
        Type genericSuperclass = presenterActivity.getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            if (null != actualTypeArguments && actualTypeArguments.length > 0) {
                Type actualTypeArgument = actualTypeArguments[0];
                try {
                    if (null != actualTypeArgument) {
                        String typeName = actualTypeArgument.toString();
                        if (!TextUtils.isEmpty(typeName))
                            return (P) Class.forName(typeName).newInstance();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}

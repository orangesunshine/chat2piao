package com.orange.chat2piao.base.mvp.model.net;

import com.orange.chat2piao.base.mvp.model.net.callback.INetCallback;
import com.orange.chat2piao.base.reponse.PullData;

import java.lang.reflect.Type;
import java.util.Map;

public interface IPrefixSuffixApi {
    /**
     * loading方式get网络请求
     *
     * @param prefix   一级路径
     * @param suffix   二级路径
     * @param params   参数
     * @param callback 回调
     * @param <T>      网络返回实体
     */
    <T> void get(String prefix, String suffix, Map<String, String> params, INetCallback<T> callback);

    /**
     * pull方式get网络请求
     *
     * @param params   参数
     * @param callback 回调
     * @param <T>      网络返回实体
     */
    <T extends PullData> void getPull(String prefix, String suffix, Map<String, String> params, Type type, INetCallback<T> callback);

    /**
     * loading方式get网络请求，带请求头
     *
     * @param headers  请求头
     * @param prefix   一级路径
     * @param suffix   二级路径
     * @param params   参数
     * @param callback 回调
     * @param <T>      网络返回实体
     */
    <T> void get(Map<String, String> headers, String prefix, String suffix, Map<String, String> params, INetCallback<T> callback);

    /**
     * pull方式get网络请求，带请求头
     *
     * @param headers  请求头
     * @param params   参数
     * @param callback 回调
     * @param <T>      网络返回实体
     */
    <T extends PullData> void getPull(Map<String, String> headers, String prefix, String suffix, Map<String, String> params, Type type, INetCallback<T> callback);

    /**
     * loading方式post网络请求
     *
     * @param prefix   一级路径
     * @param suffix   二级路径
     * @param params   参数
     * @param callback 回调
     * @param <T>      网络返回实体
     */
    <T> void post(String prefix, String suffix, Map<String, String> params, INetCallback<T> callback);

    /**
     * pull方式post网络请求
     *
     * @param params   参数
     * @param callback 回调
     * @param <T>      网络返回实体
     */
    <T extends PullData> void postPull(String prefix, String suffix, Map<String, String> params, Type type, INetCallback<T> callback);

    /**
     * loading方式post网络请求，带请求头
     *
     * @param headers  请求头
     * @param prefix   一级路径
     * @param suffix   二级路径
     * @param params   参数
     * @param callback 回调
     * @param <T>      网络返回实体
     */
    <T> void post(Map<String, String> headers, String prefix, String suffix, Map<String, String> params, INetCallback<T> callback);

    /**
     * pull方式post网络请求，带请求头
     *
     * @param headers  请求头
     * @param params   参数
     * @param callback 回调
     * @param <T>      网络返回实体
     */
    <T extends PullData> void postPull(Map<String, String> headers, String prefix, String suffix, Map<String, String> params, Type type, INetCallback<T> callback);
}

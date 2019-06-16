package com.orange.chat2piao.base.mvp.model.net;

import com.orange.chat2piao.base.mvp.model.net.callback.INetCallback;
import com.orange.chat2piao.base.reponse.PullData;

import java.lang.reflect.Type;
import java.util.Map;

public interface IUrlApi {
    /**
     * loading方式get网络请求
     *
     * @param url      全路径
     * @param params   参数
     * @param callback 回调
     * @param <T>      网络返回实体
     */
    <T> void get(String url, Map<String, String> params, INetCallback<T> callback);

    /**
     * pull方式get网络请求
     *
     * @param url      全路径
     * @param params   参数
     * @param callback 回调
     * @param <T>      网络返回实体
     */
    <T> void getPull(String url, Map<String, String> params, Type type, INetCallback<T> callback);

    /**
     * loading方式get网络请求，带请求头
     *
     * @param headers  请求头
     * @param url      全路径
     * @param params   参数
     * @param callback 回调
     * @param <T>      网络返回实体
     */
    <T> void get(Map<String, String> headers, String url, Map<String, String> params, INetCallback<T> callback);

    /**
     * pull方式get网络请求，带请求头
     *
     * @param headers  请求头
     * @param url      全路径
     * @param params   参数
     * @param callback 回调
     * @param <T>      网络返回实体
     */
    <T> void getPull(Map<String, String> headers, String url, Map<String, String> params, Type type, INetCallback<T> callback);

    /**
     * loading方式post网络请求
     *
     * @param url      全路径
     * @param params   参数
     * @param callback 回调
     * @param <T>      网络返回实体
     */
    <T> void post(String url, Map<String, String> params, INetCallback<T> callback);

    /**
     * pull方式post网络请求
     *
     * @param url      全路径
     * @param params   参数
     * @param callback 回调
     * @param <T>      网络返回实体
     */
    <T> void postPull(String url, Map<String, String> params, Type type, INetCallback<T> callback);

    /**
     * loading方式post网络请求，带请求头
     *
     * @param headers  请求头
     * @param url      全路径
     * @param params   参数
     * @param callback 回调
     * @param <T>      网络返回实体
     */
    <T> void post(Map<String, String> headers, String url, Map<String, String> params, INetCallback<T> callback);

    /**
     * pull方式post网络请求，带请求头
     *
     * @param headers  请求头
     * @param url      全路径
     * @param params   参数
     * @param callback 回调
     * @param <T>      网络返回实体
     */
    <T> void postPull(Map<String, String> headers, String url, Map<String, String> params, Type type, INetCallback<T> callback);
}

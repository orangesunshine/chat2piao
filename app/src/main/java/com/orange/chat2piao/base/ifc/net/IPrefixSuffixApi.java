package com.orange.chat2piao.base.ifc.net;

import com.orange.chat2piao.base.ifc.callback.ILoadingNetCallback;
import com.orange.chat2piao.base.ifc.callback.INoDataCallback;
import com.orange.chat2piao.base.ifc.callback.IPullNetCallback;

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
    <T> void get(String prefix, String suffix, Map<String, String> params, ILoadingNetCallback<T> callback);

    /**
     * pull方式get网络请求
     *
     * @param prefix         一级路径
     * @param suffix         二级路径
     * @param params         参数
     * @param callback       回调
     * @param noDataCallback 根据返回结果判断是不是有更多数据
     * @param <T>            网络返回实体
     */
    <T> void get(String prefix, String suffix, Map<String, String> params, IPullNetCallback<T> callback, INoDataCallback noDataCallback);

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
    <T> void get(Map<String, String> headers, String prefix, String suffix, Map<String, String> params, ILoadingNetCallback<T> callback);

    /**
     * pull方式get网络请求，带请求头
     *
     * @param headers        请求头
     * @param prefix         一级路径
     * @param suffix         二级路径
     * @param params         参数
     * @param callback       回调
     * @param noDataCallback 根据返回结果判断是不是有更多数据
     * @param <T>            网络返回实体
     */
    <T> void get(Map<String, String> headers, String prefix, String suffix, Map<String, String> params, IPullNetCallback<T> callback, INoDataCallback noDataCallback);

    /**
     * loading方式post网络请求
     *
     * @param prefix   一级路径
     * @param suffix   二级路径
     * @param params   参数
     * @param callback 回调
     * @param <T>      网络返回实体
     */
    <T> void post(String prefix, String suffix, Map<String, String> params, ILoadingNetCallback<T> callback);

    /**
     * pull方式post网络请求
     *
     * @param prefix         一级路径
     * @param suffix         二级路径
     * @param params         参数
     * @param callback       回调
     * @param noDataCallback 根据返回结果判断是不是有更多数据
     * @param <T>            网络返回实体
     */
    <T> void post(String prefix, String suffix, Map<String, String> params, IPullNetCallback<T> callback, INoDataCallback<T> noDataCallback);

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
    <T> void post(Map<String, String> headers, String prefix, String suffix, Map<String, String> params, ILoadingNetCallback<T> callback);

    /**
     * pull方式post网络请求，带请求头
     *
     * @param headers        请求头
     * @param prefix         一级路径
     * @param suffix         二级路径
     * @param params         参数
     * @param callback       回调
     * @param noDataCallback 根据返回结果判断是不是有更多数据
     * @param <T>            网络返回实体
     */
    <T> void post(Map<String, String> headers, String prefix, String suffix, Map<String, String> params, IPullNetCallback<T> callback, INoDataCallback noDataCallback);
}

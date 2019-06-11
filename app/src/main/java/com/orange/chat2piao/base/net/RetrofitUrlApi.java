package com.orange.chat2piao.base.net;

import com.orange.chat2piao.thirdParty.rxjava.LoadingResponseBodyObserver;
import com.orange.chat2piao.thirdParty.rxjava.PullResponseBodyObserver;
import com.orange.chat2piao.thirdParty.retrofit.IRetrofitCommonApiCallback;
import com.orange.chat2piao.thirdParty.retrofit.RetrofitClient;

import java.util.Map;

public class RetrofitUrlApi implements IUrlApi {
    private volatile static RetrofitUrlApi sInstance;

    public static RetrofitUrlApi getInstance() {
        if (null == sInstance) {
            synchronized (RetrofitUrlApi.class) {
                if (null == sInstance)
                    sInstance = new RetrofitUrlApi();
            }
        }
        return sInstance;
    }

    /**
     * loading方式get网络请求
     *
     * @param url      全路径
     * @param params   参数
     * @param callback 回调
     */
    @Override
    public <T> void get(String url, Map<String, String> params, ILoadingNetCallback<T> callback) {
        LoadingResponseBodyObserver.convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApiCallback.class).get(url, params), callback);
    }

    /**
     * pull方式get网络请求
     *
     * @param url            全路径
     * @param params         参数
     * @param callback       回调
     * @param noDataCallback 根据返回结果判断是不是有更多数据
     */
    @Override
    public <T> void get(String url, Map<String, String> params, INetCallback<T> callback, INoDataCallback noDataCallback) {
        PullResponseBodyObserver.convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApiCallback.class).get(url, params), callback, noDataCallback);
    }

    /**
     * loading方式get网络请求，带请求头
     *
     * @param headers  请求头
     * @param url      全路径
     * @param params   参数
     * @param callback 回调
     */
    @Override
    public <T> void get(Map<String, String> headers, String url, Map<String, String> params, ILoadingNetCallback<T> callback) {
        LoadingResponseBodyObserver.convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApiCallback.class).get(headers, url, params), callback);
    }

    /**
     * pull方式get网络请求，带请求头
     *
     * @param headers        请求头
     * @param url            全路径
     * @param params         参数
     * @param callback       回调
     * @param noDataCallback 根据返回结果判断是不是有更多数据
     */
    @Override
    public <T> void get(Map<String, String> headers, String url, Map<String, String> params, INetCallback<T> callback, INoDataCallback noDataCallback) {
        PullResponseBodyObserver.convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApiCallback.class).get(headers, url, params), callback, noDataCallback);
    }

    /**
     * loading方式post网络请求
     *
     * @param url      全路径
     * @param params   参数
     * @param callback 回调
     */
    @Override
    public <T> void post(String url, Map<String, String> params, ILoadingNetCallback<T> callback) {
        LoadingResponseBodyObserver.convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApiCallback.class).post(url, params), callback);
    }

    /**
     * pull方式post网络请求
     *
     * @param url            全路径
     * @param params         参数
     * @param callback       回调
     * @param noDataCallback 根据返回结果判断是不是有更多数据
     */
    @Override
    public <T> void post(String url, Map<String, String> params, INetCallback<T> callback, INoDataCallback noDataCallback) {
        PullResponseBodyObserver.convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApiCallback.class).post(url, params), callback, noDataCallback);
    }

    /**
     * loading方式post网络请求，带请求头
     *
     * @param headers  请求头
     * @param url      全路径
     * @param params   参数
     * @param callback 回调
     */
    @Override
    public <T> void post(Map<String, String> headers, String url, Map<String, String> params, ILoadingNetCallback<T> callback) {
        LoadingResponseBodyObserver.convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApiCallback.class).post(headers, url, params), callback);
    }

    /**
     * pull方式post网络请求，带请求头
     *
     * @param headers        请求头
     * @param url            全路径
     * @param params         参数
     * @param callback       回调
     * @param noDataCallback 根据返回结果判断是不是有更多数据
     */
    @Override
    public <T> void post(Map<String, String> headers, String url, Map<String, String> params, INetCallback<T> callback, INoDataCallback noDataCallback) {
        PullResponseBodyObserver.convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApiCallback.class).post(headers, url, params), callback, noDataCallback);
    }
}

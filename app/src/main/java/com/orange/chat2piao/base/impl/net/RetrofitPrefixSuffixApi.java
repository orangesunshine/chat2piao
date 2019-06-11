package com.orange.chat2piao.base.impl.net;

import com.orange.chat2piao.thirdParty.rxjava.LoadingResponseBodyObserver;
import com.orange.chat2piao.thirdParty.rxjava.PullResponseBodyObserver;
import com.orange.chat2piao.base.ifc.callback.ILoadingNetCallback;
import com.orange.chat2piao.base.ifc.callback.INoDataCallback;
import com.orange.chat2piao.base.ifc.callback.IPullNetCallback;
import com.orange.chat2piao.base.ifc.net.IPrefixSuffixApi;
import com.orange.chat2piao.thirdParty.retrofit.IRetrofitCommonApiCallback;
import com.orange.chat2piao.thirdParty.retrofit.RetrofitClient;

import java.util.Map;

public class RetrofitPrefixSuffixApi implements IPrefixSuffixApi {
    private volatile static RetrofitPrefixSuffixApi sInstance;

    public static RetrofitPrefixSuffixApi getInstance() {
        if (null == sInstance) {
            synchronized (RetrofitPrefixSuffixApi.class) {
                if (null == sInstance)
                    sInstance = new RetrofitPrefixSuffixApi();
            }
        }
        return sInstance;
    }

    /**
     * loading方式get网络请求
     *
     * @param prefix   一级路径
     * @param suffix   二级路径
     * @param params   参数
     * @param callback 回调
     */
    @Override
    public <T> void get(String prefix, String suffix, Map<String, String> params, ILoadingNetCallback<T> callback) {
        LoadingResponseBodyObserver.convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApiCallback.class).get(prefix, suffix, params), callback);
    }

    /**
     * pull方式get网络请求
     *
     * @param prefix         一级路径
     * @param suffix         二级路径
     * @param params         参数
     * @param callback       回调
     * @param noDataCallback 根据返回结果判断是不是有更多数据
     */
    @Override
    public <T> void get(String prefix, String suffix, Map<String, String> params, IPullNetCallback<T> callback, INoDataCallback noDataCallback) {
        PullResponseBodyObserver.convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApiCallback.class).get(prefix, suffix, params), callback, noDataCallback);
    }

    /**
     * loading方式get网络请求，带请求头
     *
     * @param headers  请求头
     * @param prefix   一级路径
     * @param suffix   二级路径
     * @param params   参数
     * @param callback 回调
     */
    @Override
    public <T> void get(Map<String, String> headers, String prefix, String suffix, Map<String, String> params, ILoadingNetCallback<T> callback) {
        LoadingResponseBodyObserver.convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApiCallback.class).get(headers, prefix, suffix, params), callback);
    }

    /**
     * pull方式get网络请求，带请求头
     *
     * @param headers        请求头
     * @param prefix         一级路径
     * @param suffix         二级路径
     * @param params         参数
     * @param callback       回调
     * @param noDataCallback 根据返回结果判断是不是有更多数据
     */
    @Override
    public <T> void get(Map<String, String> headers, String prefix, String suffix, Map<String, String> params, IPullNetCallback<T> callback, INoDataCallback noDataCallback) {
        PullResponseBodyObserver.convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApiCallback.class).get(headers, prefix, suffix, params), callback, noDataCallback);
    }

    /**
     * loading方式post网络请求
     *
     * @param prefix   一级路径
     * @param suffix   二级路径
     * @param params   参数
     * @param callback 回调
     */
    @Override
    public <T> void post(String prefix, String suffix, Map<String, String> params, ILoadingNetCallback<T> callback) {
        LoadingResponseBodyObserver.convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApiCallback.class).post(prefix, suffix, params), callback);
    }

    /**
     * pull方式post网络请求
     *
     * @param prefix         一级路径
     * @param suffix         二级路径
     * @param params         参数
     * @param callback       回调
     * @param noDataCallback 根据返回结果判断是不是有更多数据
     */
    @Override
    public <T> void post(String prefix, String suffix, Map<String, String> params, IPullNetCallback<T> callback, INoDataCallback<T> noDataCallback) {
        PullResponseBodyObserver.convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApiCallback.class).post(prefix, suffix, params), callback, noDataCallback);
    }

    /**
     * loading方式post网络请求，带请求头
     *
     * @param headers  请求头
     * @param prefix   一级路径
     * @param suffix   二级路径
     * @param params   参数
     * @param callback 回调
     */
    @Override
    public <T> void post(Map<String, String> headers, String prefix, String suffix, Map<String, String> params, ILoadingNetCallback<T> callback) {
        LoadingResponseBodyObserver.convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApiCallback.class).post(headers, prefix, suffix, params), callback);
    }

    /**
     * pull方式post网络请求，带请求头
     *
     * @param headers        请求头
     * @param prefix         一级路径
     * @param suffix         二级路径
     * @param params         参数
     * @param callback       回调
     * @param noDataCallback 根据返回结果判断是不是有更多数据
     */
    @Override
    public <T> void post(Map<String, String> headers, String prefix, String suffix, Map<String, String> params, IPullNetCallback<T> callback, INoDataCallback noDataCallback) {
        PullResponseBodyObserver.convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApiCallback.class).post(headers, prefix, suffix, params), callback, noDataCallback);
    }
}

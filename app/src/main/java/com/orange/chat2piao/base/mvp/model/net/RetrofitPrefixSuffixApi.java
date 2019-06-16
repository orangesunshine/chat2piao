package com.orange.chat2piao.base.mvp.model.net;

import com.orange.chat2piao.base.mvp.model.net.callback.INetCallback;
import com.orange.chat2piao.base.reponse.PullData;
import com.orange.chat2piao.thirdParty.retrofit.IRetrofitCommonApiCallback;
import com.orange.chat2piao.thirdParty.retrofit.RetrofitClient;
import com.orange.chat2piao.thirdParty.rxjava.LoadingResponseBodyObserver;
import com.orange.chat2piao.thirdParty.rxjava.PullResponseBodyObserver;

import java.lang.reflect.Type;
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
    public <T> void get(String prefix, String suffix, Map<String, String> params, INetCallback<T> callback) {
        LoadingResponseBodyObserver.convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApiCallback.class).get(prefix, suffix, params), callback);
    }

    /**
     * pull方式get网络请求
     *
     * @param prefix
     * @param suffix
     * @param params   参数
     * @param callback 回调
     */
    @Override
    public <T extends PullData> void getPull(String prefix, String suffix, Map<String, String> params, Type type, INetCallback<T> callback) {
        PullResponseBodyObserver.convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApiCallback.class).get(prefix, suffix, params), type, callback);
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
    public <T> void get(Map<String, String> headers, String prefix, String suffix, Map<String, String> params, INetCallback<T> callback) {
        LoadingResponseBodyObserver.convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApiCallback.class).get(headers, prefix, suffix, params), callback);
    }

    /**
     * pull方式get网络请求，带请求头
     *
     * @param headers  请求头
     * @param prefix
     * @param suffix
     * @param params   参数
     * @param callback 回调
     */
    @Override
    public <T extends PullData> void getPull(Map<String, String> headers, String prefix, String suffix, Map<String, String> params, Type type, INetCallback<T> callback) {
        PullResponseBodyObserver.convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApiCallback.class).get(headers, prefix, suffix, params), type, callback);
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
    public <T> void post(String prefix, String suffix, Map<String, String> params, INetCallback<T> callback) {
        LoadingResponseBodyObserver.convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApiCallback.class).post(prefix, suffix, params), callback);
    }

    /**
     * pull方式post网络请求
     *
     * @param prefix
     * @param suffix
     * @param params   参数
     * @param callback 回调
     */
    @Override
    public <T extends PullData> void postPull(String prefix, String suffix, Map<String, String> params, Type type, INetCallback<T> callback) {
        PullResponseBodyObserver.convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApiCallback.class).post(prefix, suffix, params), type, callback);
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
    public <T> void post(Map<String, String> headers, String prefix, String suffix, Map<String, String> params, INetCallback<T> callback) {
        LoadingResponseBodyObserver.convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApiCallback.class).post(headers, prefix, suffix, params), callback);
    }

    /**
     * pull方式post网络请求，带请求头
     *
     * @param headers  请求头
     * @param prefix
     * @param suffix
     * @param params   参数
     * @param callback 回调
     */
    @Override
    public <T extends PullData> void postPull(Map<String, String> headers, String prefix, String suffix, Map<String, String> params, Type type, INetCallback<T> callback) {
        PullResponseBodyObserver.convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApiCallback.class).post(headers, prefix, suffix, params), type, callback);
    }
}

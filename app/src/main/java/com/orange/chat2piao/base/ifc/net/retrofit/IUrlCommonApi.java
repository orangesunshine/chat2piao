package com.orange.chat2piao.base.ifc.net.retrofit;

import com.orange.chat2piao.base.ifc.callback.INetCallback;

import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.HeaderMap;

public interface IUrlCommonApi extends INoData {
    <T> void get(String url, Map<String, String> params, INetCallback<T> callback);

    <T> void get(@HeaderMap Map<String, String> headers, String url, Map<String, String> params, INetCallback<T> callback);

    <T> void post(String url, @Body Map<String, String> params, INetCallback<T> callback);

    <T> void post(@HeaderMap Map<String, String> headers, String url, @Body Map<String, String> params, INetCallback<T> callback);
}

package com.orange.chat2piao.base.ifc.net.retrofit;

import com.orange.chat2piao.base.ifc.callback.INetCallback;

import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.HeaderMap;

public interface IPrefixSuffixCommonApi {
    <T> void get(String prefix, String suffix, Map<String, String> params, INetCallback<T> callback);

    <T> void get(@HeaderMap Map<String, String> headers, String prefix, String suffix, Map<String, String> params, INetCallback<T> callback);

    <T> void post(String prefix, String suffix, @Body Map<String, String> params, INetCallback<T> callback);

    <T> void post(@HeaderMap Map<String, String> headers, String prefix, String suffix, @Body Map<String, String> params, INetCallback<T> callback);
}

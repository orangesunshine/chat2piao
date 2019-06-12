package com.orange.chat2piao.thirdParty.retrofit;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface IRetrofitCommonApiCallback{
    @GET("/{prefix}/{suffix}")
    Observable<ResponseBody> get(@Path("prefix") String prefix, @Path("suffix") String suffix, @QueryMap Map<String, String> params);

    @GET("/{prefix}/{suffix}")
    Observable<ResponseBody> get(@HeaderMap Map<String, String> headers, @Path("prefix") String prefix, @Path("suffix") String suffix, @QueryMap Map<String, String> params);

    @POST("/{prefix}/{suffix}")
    Observable<ResponseBody> post(@Path("prefix") String prefix, @Path("suffix") String suffix, @Body Map<String, String> params);

    @POST("/{prefix}/{suffix}")
    Observable<ResponseBody> post(@HeaderMap Map<String, String> headers, @Path("prefix") String prefix, @Path("suffix") String suffix, @Body Map<String, String> params);

    @GET("")
    Observable<ResponseBody> get(@Url String url, @QueryMap Map<String, String> params);

    @GET("")
    Observable<ResponseBody> get(@HeaderMap Map<String, String> headers, @Url String url, @QueryMap Map<String, String> params);

    @POST("")
    Observable<ResponseBody> post(@Url String url, @Body Map<String, String> params);

    @POST("")
    Observable<ResponseBody> post(@HeaderMap Map<String, String> headers, @Url String url, @Body Map<String, String> params);
}

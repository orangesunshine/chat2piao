package com.orange.chat2piao.base.ifc.net.retrofit;

import android.text.TextUtils;

import com.orange.chat2piao.base.constant.IFinalConst;
import com.orange.chat2piao.base.constant.IInitConst;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private volatile static Retrofit sInstance;

    public static Retrofit getRetrofitInstance() {
        if (null == sInstance) {
            synchronized (RetrofitClient.class) {
                if (null == sInstance) {
                    Retrofit.Builder client = new Retrofit.Builder()
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(newOkHttpClicentInstance());
                    String baseUrl = "";
                    String initBaseUrl = IInitConst.sBaseUrl;
                    if (TextUtils.isEmpty(baseUrl) && !TextUtils.isEmpty(initBaseUrl))
                        baseUrl = initBaseUrl;

                    String finalBaseUrl = IFinalConst.sBaseUrl;
                    if (TextUtils.isEmpty(baseUrl) && !TextUtils.isEmpty(finalBaseUrl))
                        baseUrl = finalBaseUrl;
                    if (TextUtils.isEmpty(baseUrl))
                        baseUrl = "http://127.0.0.1:8080";
                    client.baseUrl(baseUrl);
                    sInstance = client.build();
                }
            }
        }
        return sInstance;
    }

    private RetrofitClient() {

    }

    private static OkHttpClient newOkHttpClicentInstance() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }
}

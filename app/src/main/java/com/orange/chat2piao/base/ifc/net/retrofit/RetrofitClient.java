package com.orange.chat2piao.base.ifc.net.retrofit;

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
                if (null == sInstance)
                    sInstance = new Retrofit.Builder()
                            .baseUrl(IInitConst.sBaseUrl)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(newOkHttpClicentInstance())
                            .build();
            }
        }
        return sInstance;
    }

    private RetrofitClient() {

    }

    private static OkHttpClient newOkHttpClicentInstance() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor())
                .build();
    }
}

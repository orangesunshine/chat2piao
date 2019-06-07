package com.orange.chat2piao.base.ifc.net.retrofit;

import com.orange.chat2piao.base.constant.IInitConst;

import retrofit2.Retrofit;

public class RetrofitClient {
    private volatile static RetrofitClient sInstance;
    private Retrofit mRetrofit;

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IInitConst.sBaseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }
}

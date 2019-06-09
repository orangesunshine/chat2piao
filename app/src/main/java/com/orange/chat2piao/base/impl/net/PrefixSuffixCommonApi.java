package com.orange.chat2piao.base.impl.net;

import android.text.TextUtils;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.orange.chat2piao.base.constant.IFinalConst;
import com.orange.chat2piao.base.ifc.callback.INetCallback;
import com.orange.chat2piao.base.ifc.net.retrofit.IRetrofitCommonApi;
import com.orange.chat2piao.base.ifc.net.retrofit.IPrefixSuffixCommonApi;
import com.orange.chat2piao.base.ifc.net.retrofit.RetrofitClient;
import com.orange.chat2piao.utils.Preconditions;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class PrefixSuffixCommonApi implements IPrefixSuffixCommonApi {
    private volatile static PrefixSuffixCommonApi sInstance;

    public static PrefixSuffixCommonApi getInstance() {
        if (null == sInstance) {
            synchronized (PrefixSuffixCommonApi.class) {
                if (null == sInstance)
                    sInstance = new PrefixSuffixCommonApi();
            }
        }
        return sInstance;
    }

    private Gson gson = new Gson();

    @Override
    public <T> void get(String prefix, String suffix, Map<String, String> params, INetCallback<T> callback) {
        convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApi.class).get(prefix, suffix, params), callback);
    }

    @Override
    public <T> void get(Map<String, String> headers, String prefix, String suffix, Map<String, String> params, INetCallback<T> callback) {
        convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApi.class).get(headers, prefix, suffix, params), callback);
    }

    @Override
    public <T> void post(String prefix, String suffix, Map<String, String> params, INetCallback<T> callback) {
        convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApi.class).post(prefix, suffix, params), callback);
    }

    @Override
    public <T> void post(Map<String, String> headers, String prefix, String suffix, Map<String, String> params, INetCallback<T> callback) {
        convert(RetrofitClient.getRetrofitInstance().create(IRetrofitCommonApi.class).post(headers, prefix, suffix, params), callback);
    }

    private <T> void convert(Observable<ResponseBody> observable, INetCallback<T> callback) {
        Preconditions.checkNotNull(callback, "null == observable");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (null != callback)
                            callback.onNetStart();
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        if (null == responseBody) return;
                        T result = null;
                        int code = IFinalConst.CODE_ERROR;
                        StringBuilder errorMsg = new StringBuilder();
                        String responseMsg = "";
                        try {
                            String body = responseBody.string();
                            if (null == body) {
                                errorMsg.append("null == body");
                                return;
                            }
                            JsonObject jsonObject = new JsonParser().parse(body).getAsJsonObject();
                            if (null == jsonObject) {
                                errorMsg.append("null == jsonObject");
                                return;
                            }

                            JsonElement codeElement = jsonObject.get("code");
                            if (null != codeElement)
                                code = codeElement.getAsInt();
                            JsonElement msgElement = jsonObject.get("msg");
                            if (null != msgElement && !(msgElement instanceof JsonNull))
                                responseMsg = msgElement.getAsString();

                            JsonElement data = jsonObject.get("data");
                            if (null != data) {
                                result = gson.fromJson(data, getGenericSuperclassActualTypeArgClass(callback));
                            }
                        } catch (Exception e) {
                            Throwable cause = e.getCause();
                            while (null != cause) {
                                errorMsg.append("cause: ");
                                errorMsg.append(cause.getMessage());
                                errorMsg.append(System.getProperty("line.separator"));
                            }
                        } finally {
                            if (null != callback && null != result) {
                                if (checkCodeSuccess(code)) {
                                    if (!TextUtils.isEmpty(responseMsg))
                                        ToastUtils.showShort(responseMsg);
                                    callback.onSuccess(result);
                                    return;
                                }
                                errorMsg.append("succuess code != 200");
                            }
                            if (null != callback) {
                                if (errorMsg.length() == 0) {
                                    errorMsg.append(TextUtils.isEmpty(responseMsg) ? "未知异常" : responseMsg);
                                }
                                callback.onError(code, new Throwable(errorMsg.toString()));
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        StringBuffer errorMsg = new StringBuffer();
                        if (null != e) {
                            Throwable cause = e.getCause();
                            while (null != cause) {
                                errorMsg.append(cause.getMessage());
                                cause = cause.getCause();
                            }
                        }
                        if (!TextUtils.isEmpty(errorMsg))
                            ToastUtils.showShort(errorMsg);
                        if (null != callback) {
                            callback.onError(IFinalConst.CODE_ERROR, e);
                            callback.onComplete();
                        }
                    }

                    @Override
                    public void onComplete() {
                        if (null != callback)
                            callback.onComplete();
                    }
                });
    }

    private <T> Type getGenericSuperclassActualTypeArgClass(INetCallback<T> callback) {
        Preconditions.checkNotNull(callback, "null == callback");
        Type genericSuperclass = callback.getClass().getGenericSuperclass();
        if (null != genericSuperclass && genericSuperclass instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            if (null != actualTypeArguments && actualTypeArguments.length > 0)
                return actualTypeArguments[0];
        }
        return null;
    }

    private boolean checkCodeSuccess(int code) {
        return IFinalConst.CODE_SUCCESS == code;
    }
}

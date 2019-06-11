package com.orange.chat2piao.thirdParty.rxjava;

import android.text.TextUtils;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.orange.chat2piao.constant.IFinalConst;
import com.orange.chat2piao.base.net.INetCallback;
import com.orange.chat2piao.utils.CommonUtils;
import com.orange.chat2piao.utils.ReflectionUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class PullResponseBodyObserver<T> implements Observer<ResponseBody> {
    private INetCallback<T> callback;
    private INoDataCallback noDataCallback;
    private boolean noData = false;
    private Gson gson = new Gson();

    public PullResponseBodyObserver(INetCallback<T> callback, INoDataCallback noDataCallback) {
        this.callback = callback;
        this.noDataCallback = noDataCallback;
    }

    public static <T> void convert(Observable<ResponseBody> observable, INetCallback<T> callback, INoDataCallback noDataCallback) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new PullResponseBodyObserver<>(callback, noDataCallback));
    }

    @Override
    public void onSubscribe(Disposable d) {
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
                result = gson.fromJson(data, ReflectionUtils.getGenericSuperclassActualTypeArgClass(callback));
            }
        } catch (Exception e) {
            Throwable cause = e.getCause();
            while (null != cause) {
                errorMsg.append("cause: ");
                errorMsg.append(cause.getMessage());
                errorMsg.append(System.getProperty("line.separator"));
            }
        } finally {
            if (null != noDataCallback)
                noData = noDataCallback.noData(result);
            if (null != callback && null != result) {
                if (CommonUtils.checkCodeSuccess(code)) {
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
        if (null != callback) {
            callback.onError(IFinalConst.CODE_ERROR, e);
            callback.onComplete(true);
        }
    }

    @Override
    public void onComplete() {
        if (null != callback)
            callback.onComplete(noData);
    }
}

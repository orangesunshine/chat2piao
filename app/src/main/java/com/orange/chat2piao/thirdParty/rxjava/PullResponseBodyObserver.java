package com.orange.chat2piao.thirdParty.rxjava;

import android.text.TextUtils;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.orange.chat2piao.base.reponse.PullData;
import com.orange.chat2piao.constant.IFinalConst;
import com.orange.chat2piao.base.mvp.model.net.callback.INetCallback;
import com.orange.chat2piao.utils.CommonUtils;
import com.orange.chat2piao.utils.ReflectionUtils;

import java.lang.reflect.Type;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class PullResponseBodyObserver<T> implements Observer<ResponseBody> {
    private INetCallback callback;
    private boolean mNoData = false;
    private boolean mEmpty = true;
    private Type mType;
    private Gson gson = new Gson();

    public <T> PullResponseBodyObserver(Type type, INetCallback<T> callback) {
        mType = type;
        this.callback = callback;
    }

    public static <T> void convert(Observable<ResponseBody> observable, Type type, INetCallback<T> callback) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new PullResponseBodyObserver(type, callback));
    }

    @Override
    public void onSubscribe(Disposable d) {
        callback.onNetStart();
    }

    @Override
    public void onNext(ResponseBody responseBody) {
        if (null == responseBody) return;
        Object result = null;
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
                if (null == mType)
                    mType = ReflectionUtils.getGenericActualTypeArg(callback);
                TypeToken<?> typeToken = TypeToken.get(mType);
                TypeAdapter<?> adapter = gson.getAdapter(typeToken);
                result = adapter.fromJson(data.toString());
            }
        } catch (Exception e) {
            Throwable cause = e.getCause();
            if (null != cause) {
                errorMsg.append("cause: ");
                errorMsg.append(cause.getMessage());
                errorMsg.append(System.getProperty("line.separator"));
            }
        } finally {
            if (null != result && result instanceof PullData) {
                mEmpty = ((PullData) result).empty();
                mNoData = ((PullData) result).noMoreData();
            }
            if (null != callback) {
                if (null != result && CommonUtils.checkCodeSuccess(code)) {
                    if (!TextUtils.isEmpty(responseMsg) && TextUtils.isEmpty(errorMsg))
                        ToastUtils.showShort(responseMsg);
                    callback.onSuccess(result);
                } else {
                    if (errorMsg.length() == 0)
                        errorMsg.append(TextUtils.isEmpty(responseMsg) ? "未知异常" : responseMsg);
                    callback.onError(code, new Throwable(errorMsg.toString()));
                }
            }
        }
    }

    @Override
    public void onError(Throwable e) {
        if (null != callback) {
            callback.onError(IFinalConst.CODE_ERROR, e);
            callback.onComplete(true, true);
        }
    }

    @Override
    public void onComplete() {
        if (null != callback)
            callback.onComplete(mNoData, mEmpty);
    }
}

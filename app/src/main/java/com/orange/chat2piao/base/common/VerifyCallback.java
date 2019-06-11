package com.orange.chat2piao.base.common;

public interface VerifyCallback<T> {

    /**
     * 验证条件
     *
     * @return
     */
    boolean verify(T data);
}

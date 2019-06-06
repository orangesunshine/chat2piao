package com.orange.chat2piao.base.ifc.callback;

public interface VerifyCallback<T> {

    /**
     * 验证条件
     *
     * @return
     */
    boolean verify(T sequence);
}

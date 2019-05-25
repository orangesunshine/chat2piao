package com.orange.chat2piao.base.ifc.callback;

public interface VerifyCallback {
    /**
     * 验证结果
     *
     * @param verfify
     * @return
     */
    void onVerify(boolean verfify);

    /**
     * 验证条件
     *
     * @return
     */
    boolean verify(CharSequence sequence);
}

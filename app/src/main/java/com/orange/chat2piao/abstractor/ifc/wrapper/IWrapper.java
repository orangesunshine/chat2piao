package com.orange.chat2piao.abstractor.ifc.wrapper;

public interface IWrapper<R,T> {
    //装饰
    IWrapper wrap(IWrapper wrapper);

    //调用方法
    void perform();

    T getArg();

    IWrapper setIfc(R ifc);
}

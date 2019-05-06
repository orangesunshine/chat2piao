package com.orange.chat2piao.other.wrapper;

public interface IDefinedWrapper<R,T> {
    //装饰
    IDefinedWrapper wrap(IDefinedWrapper wrapper);

    //调用方法
    void perform();

    T getArg();

    IDefinedWrapper setIfc(R ifc);
}

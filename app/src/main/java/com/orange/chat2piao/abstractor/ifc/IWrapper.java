package com.orange.chat2piao.abstractor.ifc;

public interface IWrapper<T> {
    //装饰
    IWrapper wrap(IWrapper wrapper);

    //调用方法
    void perform();
}

package com.orange.chat2piao.abstractor.adapter;

import com.orange.chat2piao.abstractor.ifc.IWrapper;

public abstract class WrapperAdater<P, T> implements IWrapper<T> {
    protected T mArg;
    protected P mIfc;

    @Override
    public IWrapper wrap(IWrapper wrapper) {
        perform();
        if (null != wrapper) {
            wrapper.perform();
        }
        return this;
    }

    public IWrapper setArg(T arg) {
        mArg = arg;
        return this;
    }

    public T getArg() {
        return mArg;
    }

    public IWrapper setIfc(P ifc) {
        mIfc = ifc;
        return this;
    }
}

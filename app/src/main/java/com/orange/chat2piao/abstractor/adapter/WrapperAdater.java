package com.orange.chat2piao.abstractor.adapter;

import com.orange.chat2piao.abstractor.ifc.wrapper.IWrapper;

public abstract class WrapperAdater<R, T> implements IWrapper<R,T> {
    protected T mArg;
    protected R mIfc;

    public WrapperAdater(T arg) {
        mArg = arg;
    }

    @Override
    public IWrapper wrap(IWrapper wrapper) {
        perform();
        if (null != wrapper) {
            wrapper.perform();
        }
        return this;
    }

    @Override
    public T getArg() {
        return mArg;
    }

    @Override
    public IWrapper setIfc(R ifc) {
        mIfc = ifc;
        return this;
    }
}

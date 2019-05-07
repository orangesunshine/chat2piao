package com.orange.chat2piao.other;

import com.orange.chat2piao.other.wrapper.IDefinedWrapper;

public abstract class DefinedWrapperAdater<R, T> implements IDefinedWrapper<R, T> {
    protected T mArg;
    protected R mIfc;

    public DefinedWrapperAdater(T arg) {
        mArg = arg;
    }

    @Override
    public IDefinedWrapper wrap(IDefinedWrapper wrapper) {
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
    public IDefinedWrapper setIfc(R ifc) {
        mIfc = ifc;
        return this;
    }
}

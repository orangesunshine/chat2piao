package com.orange.chat2piao.base.mvp.model.net.pull;

import java.util.List;

public interface IPullNetResultCallback<DATA, ITEM> {
    boolean parseNoData(DATA data);

    List<ITEM> parseList(DATA data);

}

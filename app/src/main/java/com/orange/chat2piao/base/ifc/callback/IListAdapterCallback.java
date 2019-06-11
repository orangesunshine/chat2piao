package com.orange.chat2piao.base.ifc.callback;

import java.util.List;

public interface IListAdapterCallback<DATA, ITEM> {

    List<ITEM> parselist(DATA data);
}

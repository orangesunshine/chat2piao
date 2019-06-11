package com.orange.chat2piao.base.ifc.callback;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.orange.chat2piao.base.ui.recyclerview.CommonAdapter;
import com.orange.chat2piao.base.ui.recyclerview.IConvertRecyclerView;

public interface IRecyclerViewPullDataCallback {


    <DATA, ITEM> CommonAdapter<ITEM> adapterRecyclerViewPullData(Context context, RecyclerView rv, View empty, CommonAdapter<ITEM> adapter, int layout, boolean loadmore, DATA data, IListAdapterCallback<DATA, ITEM> listAdapterCallback, IConvertRecyclerView<ITEM> convertViewHolder);
}

package com.orange.chat2piao.base.impl.img;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.orange.chat2piao.R;
import com.orange.chat2piao.base.ifc.img.IImage;
import com.orange.chat2piao.base.impl.globle.GlobleImp;

public class GlideImageImpl implements IImage {

    @Override
    public void loadImgUrl(ImageView iv, String url) {
        Glide.with(GlobleImp.getInstance().getAppContext()).load(url).placeholder(placeholder()).into(iv);
    }

    @Override
    public int placeholder() {
        return R.mipmap.ic_setting;
    }
}

package com.orange.chat2piao.base.image;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.orange.chat2piao.base.image.IImage;
import com.orange.chat2piao.base.globle.GlobleImpl;

public class GlideImageImpl implements IImage {

    /**
     * 设置网络图片
     *
     * @param iv
     * @param url
     */
    @Override
    public void loadImgUrl(ImageView iv, String url) {
        Glide.with(GlobleImpl.getInstance().getAppContext()).load(url).placeholder(GlobleImpl.getInstance().placeholder()).into(iv);
    }

    /**
     * 设置gif图片
     *
     * @param iv
     * @param resId
     */
    @Override
    public void loadImageResourceAsGif(ImageView iv, int resId) {
        Glide.with(GlobleImpl.getInstance().getAppContext()).asGif().load(resId).into(iv);
    }
}

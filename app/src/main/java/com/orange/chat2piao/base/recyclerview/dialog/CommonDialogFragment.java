package com.orange.chat2piao.base.recyclerview.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.bdb.lottery.R;
import com.bdb.lottery.ui.base.recyclerview.ContentViewHolder;
import com.bdb.lottery.ui.base.recyclerview.popupwin.IConvertContentView;
import com.bdb.lottery.widget.DailogFullScreenUtils;

import java.io.Serializable;

import bdb.common.library.utils.PhoneUtils;
import bdb.common.library.utils.ScreenUtils;
import bdb.common.library.utils.SizeUtils;

public class CommonDialogFragment<T extends Serializable> extends DialogFragment {
    public static final String ARGUMENT_LAYOUT_ID = "argument_layout_id";
    public static final String ARGUMENT_DATA = "argument_data";

    //vars
    @LayoutRes
    private int mLayoutId;
    private IConvertContentView<T> mConvertHolder;
    private T mData;
    private float mDimAmount = 0.5f;//背景昏暗度
    private boolean mShowBottomEnable;//是否底部显示
    private int mMargin = 0;//左右边距
    private int mAnimStyle = 0;//进入退出动画
    private boolean mOutCancel = true;//点击外部取消
    private Context mContext;
    private int mWidth;
    private int mHeight;

    public static <T extends Serializable> CommonDialogFragment<T> newInstance(int layoutId, IConvertContentView<T> holder) {
        CommonDialogFragment fragment = new CommonDialogFragment();
        fragment.setArguments(getExtraBundle(layoutId));
        fragment.setConvertHolder(holder);
        return fragment;
    }

    public static <T extends Serializable> CommonDialogFragment<T> newInstance(int layoutId, T data, IConvertContentView<T> holder) {
        CommonDialogFragment fragment = new CommonDialogFragment();
        fragment.setArguments(getExtraBundle(layoutId, data));
        fragment.setConvertHolder(holder);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, R.style.UserDialog); // 没有titlebar，全屏展示
        Bundle arguments = getArguments();
        if (null != arguments) {
            mLayoutId = arguments.getInt(ARGUMENT_LAYOUT_ID);
            mData = (T) arguments.getSerializable(ARGUMENT_DATA);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(mLayoutId, container);
        ContentViewHolder holder = new ContentViewHolder(contentView);
        initStatusBar(holder);
        mConvertHolder.convert(holder, mData);
        return contentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DailogFullScreenUtils.dailogFullScreenUtils2(getDialog().getWindow(), getActivity());
    }

    private void initStatusBar(ContentViewHolder holder) {
        View topTitleStatusBar = holder.getView(R.id.top_title_status_bar);
        if (null != topTitleStatusBar) {
            LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) topTitleStatusBar.getLayoutParams();
            linearParams.height = PhoneUtils.getStatusBarHeight(mContext);
            topTitleStatusBar.setLayoutParams(linearParams);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        initParams();
    }

    private void initParams() {
        Window window = getDialog().getWindow();
        if (window != null) {
            WindowManager.LayoutParams params = window.getAttributes();
            params.dimAmount = mDimAmount;

            //设置dialog显示位置
            if (mShowBottomEnable) {
                params.gravity = Gravity.BOTTOM;
            }

            if (0 == mWidth && 0 == mHeight) {
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
            } else {
                //设置dialog宽度
                if (mWidth == 0) {
                    params.width = ScreenUtils.getScreenWidth() - SizeUtils.dp2px(mMargin);
                } else {
                    params.width = SizeUtils.dp2px(mWidth);
                }

                //设置dialog高度
                if (mHeight == 0) {
                    params.height = ScreenUtils.getScreenHeight() - SizeUtils.dp2px(mMargin);
                } else {
                    params.height = SizeUtils.dp2px(mHeight);
                }
            }

            //设置dialog动画
            if (mAnimStyle != 0) {
                window.setWindowAnimations(mAnimStyle);
            } else {
                window.setWindowAnimations(R.style.winDialogAnim);
            }
            window.setAttributes(params);
        }
        setCancelable(mOutCancel);
    }

    /**
     * 设置宽高
     *
     * @param width
     * @param height
     * @return
     */
    public CommonDialogFragment setSize(int width, int height) {
        mWidth = width;
        mHeight = height;
        return this;
    }

    /**
     * 设置左右margin
     *
     * @param margin
     * @return
     */
    public CommonDialogFragment setMargin(int margin) {
        mMargin = margin;
        return this;
    }

    /**
     * 设置进入退出动画
     *
     * @param animStyle
     * @return
     */
    public CommonDialogFragment setAnimStyle(@StyleRes int animStyle) {
        mAnimStyle = animStyle;
        return this;
    }

    /**
     * 设置是否点击外部取消
     *
     * @param outCancel
     * @return
     */
    public CommonDialogFragment setOutCancel(boolean outCancel) {
        mOutCancel = outCancel;
        return this;
    }

    public static Bundle getExtraBundle(int layoutId) {
        Bundle bundle = new Bundle();
        bundle.putInt(ARGUMENT_LAYOUT_ID, layoutId);
        return bundle;
    }

    public static <T extends Serializable> Bundle getExtraBundle(int layoutId, T data) {
        Bundle bundle = new Bundle();
        bundle.putInt(ARGUMENT_LAYOUT_ID, layoutId);
        if (null != data)
            bundle.putSerializable(ARGUMENT_DATA, data);
        return bundle;
    }

    public CommonDialogFragment setConvertHolder(IConvertContentView<T> convertHolder) {
        mConvertHolder = convertHolder;
        return this;
    }

    public void show(FragmentActivity activity) {
        FragmentManager manager = activity.getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        if (!isAdded()) {
            ft.add(this, String.valueOf(System.currentTimeMillis()));
        } else {
            ft.show(this);
        }
        ft.commitAllowingStateLoss();
    }
}

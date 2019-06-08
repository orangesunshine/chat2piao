package com.orange.chat2piao.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;

import com.blankj.utilcode.util.ToastUtils;
import com.orange.chat2piao.R;
import com.orange.chat2piao.base.adapter.TextWatcherAdapter;
import com.orange.chat2piao.base.ifc.callback.VerifyCallback;
import com.orange.chat2piao.base.impl.globle.GlobleImp;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ViewHelper {
    public static final String TAG_COPY = "tag_copy";

    /**
     * 设置文本
     *
     * @param tv
     * @param text
     */
    public static void setText(TextView tv, CharSequence text) {
        if (null == tv) throw new NullPointerException();
        if (null == text) text = "";
        tv.setText(text);
    }

    /**
     * 设置textSize
     *
     * @param tv
     * @param size
     */
    public static void setTextSize(TextView tv, float size) {
        if (null == tv) throw new NullPointerException();
        if (size < 0) return;
        tv.setTextSize(size);
    }

    /**
     * 设置文本
     *
     * @param tv
     * @param color
     */
    public static void setTextColor(TextView tv, @ColorInt int color) {
        if (null == tv) throw new NullPointerException();
        tv.setTextColor(color);
    }

    /**
     * 设置图片
     *
     * @param iv
     * @param resId
     */
    public static void setImageResource(ImageView iv, int resId) {
        if (null == iv) throw new NullPointerException();
        if (resId <= 0) resId = R.drawable.shape_picture_placeholder;
        iv.setImageResource(resId);
    }

    /**
     * 设置visibile
     *
     * @param view
     * @param visible
     */
    public static void setVisible(View view, boolean visible) {
        if (null == view) throw new NullPointerException();
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    /**
     * 设置select
     *
     * @param view
     * @param selected
     */
    public static void setSelect(View view, boolean selected) {
        if (null == view) throw new NullPointerException();
        view.setSelected(selected);
    }

    /**
     * @param view
     * @param color
     * @return
     */
    public static void setBackgroudColor(View view, @ColorInt int color) {
        if (null == view) throw new NullPointerException();
        view.setBackgroundColor(color);
    }

    /**
     * @param view
     * @param resId
     * @return
     */
    public static void setBackgroundResource(View view, @DrawableRes int resId) {
        if (null == view) throw new NullPointerException();
        view.setBackgroundResource(resId);
    }

    public static void setOnClickListener(View view, View.OnClickListener listener) {
        if (null == view) throw new NullPointerException();
        view.setOnClickListener(listener);
    }

    public static void copy2Clipboard(Context context, TextView tv) {
        if (null == tv) {
            ToastUtils.showShort("复制失败！");
            return;
        }
        String trim = tv.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            //获取剪贴版
            ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            //创建ClipData对象
            //第一个参数只是一个标记，随便传入。
            //第二个参数是要复制到剪贴版的内容
            ClipData clip = ClipData.newPlainText(TAG_COPY, trim);
            //传入clipdata对象.
            clipboard.setPrimaryClip(clip);
            ToastUtils.showShort("复制成功");
        } else {
            ToastUtils.showShort("复制内容为空");
        }
    }

    /**
     * 注单详情投注号码显示
     *
     * @param lotteryNum
     */
    public static CharSequence showNotWonNums(String lotteryNum, boolean isAbnormal) {
        if (null == lotteryNum) lotteryNum = "";
        String[] split = lotteryNum.split(",");
        StringBuilder nums = new StringBuilder();
        if (null != split && split.length > 0) {
            int index = 0;
            int[] selectedIndexs = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                int offset = nums.length() - 1;
                if (0 != i) nums.append(" |");
                for (int i1 = 0; i1 < 10; i1++) {
                    if (0 != i || i1 != 0) {
                        index++;
                        nums.append(" ");
                    }
                    index++;
                    nums.append(i1);
                    if (0 == index % 35) {
                        index++;
                        nums.append("\n");
                    }
                }
                String cur = split[i];
                if (cur.length() > 1)
                    cur = cur.substring(cur.length() - 1);
                selectedIndexs[i] = nums.indexOf(cur, offset);
            }
            if (isAbnormal)
                return nums;
            SpannableString span = new SpannableString(nums);
            for (int item : selectedIndexs) {
                if (item < 0) continue;
                span.setSpan(new ForegroundColorSpan(Color.parseColor("#FA4529")), item, item + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
            return span;
        }
        return "";
    }

    /**
     * 验证Edit输入内容是否满足验证条件
     */
    public static void verifyEditContent(EditText edtv, final VerifyCallback callback) {
        if (null == edtv) throw new NullPointerException();
        edtv.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                if (null != callback) {
                    callback.verify(callback.verify(s));
                }
            }
        });
    }

    /**
     * imageview设置圆形图片
     *
     * @param ivImage
     * @param context
     * @param drawRes
     */
    public static void setCircleImage(ImageView ivImage, Context context, @DrawableRes int drawRes) {
        if (null == ivImage || null == context) throw new NullPointerException();
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), drawRes);
        if (null != bitmap)
            ivImage.setImageBitmap(circleDrawable(context, bitmap));
    }

    /**
     * imageview设置圆形图片
     *
     * @param ivImage
     * @param context
     * @param urlString
     */
    public static void setCircleImage(final ImageView ivImage, final Context context, final String urlString) {
        if (null == ivImage || null == context) throw new NullPointerException();
        if (TextUtils.isEmpty(urlString)) {
            setCircleImage(ivImage, context, GlobleImp.getInstance().placeholder());//placeholder
        } else if (Patterns.WEB_URL.matcher(urlString).matches()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    HttpURLConnection conn = null;
                    try {
                        URL url = new URL(urlString);
                        if (null != url) {
                            conn = (HttpURLConnection) url.openConnection();
                            conn.setDoInput(true);
                            conn.connect();
                            InputStream is = conn.getInputStream();
                            final Bitmap bitmap = BitmapFactory.decodeStream(is);
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {
                                    ivImage.setImageBitmap(circleDrawable(context, bitmap));
                                }
                            });
                        }
                    } catch (Exception e) {
                    } finally {
                        if (null != conn)
                            conn.disconnect();
                    }
                }
            }).start();

        }
    }


    /**
     * 获取圆形drawable
     *
     * @param bitmap
     * @return
     */
    private static Bitmap circleDrawable(Context context, Bitmap bitmap) {
        if (null == context) throw new NullPointerException();
        if (null == bitmap) throw new NullPointerException();

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int diameter = Math.min(width, height);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setDither(true);
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));

        Bitmap newBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(newBitmap);
        canvas.drawCircle(width / 2, height / 2, diameter / 2, paint);
        if (null != bitmap && !bitmap.isRecycled())
            bitmap.recycle();
        return newBitmap;
    }
}

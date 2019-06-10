package com.orange.chat2piao.utils;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.widget.TextView;

import java.util.Map;

public class TextUtils {
    /**
     * 返回格式化字符串，格式或者被格式字符串为空直接返回""
     *
     * @param format
     * @param content
     * @return
     */
    public static String format(String format, String content) {
        if (android.text.TextUtils.isEmpty(content)) return "";
        if (android.text.TextUtils.isEmpty(format)) return "";
        return String.format(format, content);
    }

    /**
     * 设置文本
     *
     * @param textView
     * @param text
     */
    public static void setText(TextView textView, String text) {
        if (null == textView) return;
        if (null == text) text = "";
        textView.setText(text);
    }

    /**
     * @param texts
     */
    public static String concatText(String... texts) {
        if (null == texts || texts.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (String text : texts) {
            if (null == text) text = "";
            sb.append(text);
        }
        return sb.toString();
    }

    /**
     * @param text
     */
    public static String placeHoldText(String text, String placeHold) {
        if (android.text.TextUtils.isEmpty(text) && android.text.TextUtils.isEmpty(placeHold)) return "";
        if (android.text.TextUtils.isEmpty(placeHold)) placeHold = "";
        if (android.text.TextUtils.isEmpty(text)) return placeHold;
        return text;
    }

    /**
     * @param text
     */
    public static String placeHoldText(String text) {
        return placeHoldText(text, "##");
    }

    /**
     * @param map
     * @param key
     * @param value
     * @return
     */
    public static void putMap(Map map, String key, String value) {
        if (null == map) throw new NullPointerException();
        if (android.text.TextUtils.isEmpty(key))
            return;
        if (null == value) value = "";
        map.put(key, value);
    }

    /**
     * 设置颜色和大小
     *
     * @param charSequence
     * @param str
     * @param condition
     * @param conditionColor
     * @param defaultColor
     * @return
     */
    public static CharSequence colorNdScaleSpanable(CharSequence charSequence, String str, boolean condition, float scale, String conditionColor, String defaultColor) {
        if (android.text.TextUtils.isEmpty(charSequence)) return charSequence;
        SpannableString spanable = new SpannableString(charSequence);
        if (null != spanable) {
            int color = condition ? Color.parseColor(conditionColor) : Color.parseColor(defaultColor);
            spanable.setSpan(new ForegroundColorSpan(color), 0, spanable.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            int index = charSequence.toString().indexOf(str);
            if (-1 != index) {
                spanable.setSpan(new RelativeSizeSpan(scale), 0, index, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        return spanable;
    }

    /**
     * 设置颜色
     *
     * @param charSequence
     * @param condition
     * @param conditionColor
     * @param defaultColor
     * @return
     */
    public static CharSequence colorSpanable(CharSequence charSequence, boolean condition, String conditionColor, String defaultColor) {
        if (android.text.TextUtils.isEmpty(charSequence)) return charSequence;
        SpannableString spanable = new SpannableString(charSequence);
        if (null != spanable) {
            int color = condition ? Color.parseColor(conditionColor) : Color.parseColor(defaultColor);
            spanable.setSpan(new ForegroundColorSpan(color), 0, spanable.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return spanable;
    }

    /**
     * 设置大小
     *
     * @param charSequence
     * @param str
     * @return
     */
    public static CharSequence scaleSpanable(CharSequence charSequence, String str, float scale) {
        if (android.text.TextUtils.isEmpty(charSequence)) return charSequence;
        SpannableString spanable = new SpannableString(charSequence);
        if (null != spanable) {
            int index = charSequence.toString().indexOf(str);
            if (-1 != index) {
                spanable.setSpan(new RelativeSizeSpan(scale), 0, index, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        return spanable;
    }

    /**
     * 设置金钱样式
     *
     * @param money
     */
    public static CharSequence spanableMoney(double money, boolean condition, String format, String conditionColor, String defaultColor) {
        String moneyString = String.format(format, money);
        return colorNdScaleSpanable(moneyString, ".", condition, 1.5f, conditionColor, defaultColor);
    }


    /**
     * 设置金钱样式
     *
     * @param money
     */
    public static CharSequence spanableMoney(double money, String format) {
        return spanableMoney(money, money >= 0, format, "#FA4529", "#333333");
    }

    /**
     * 设置金钱样式
     *
     * @param money
     */
    public static CharSequence spanableMoney(double money) {
        return spanableMoney(money, money >= 0, "%.3f 元", "#FA4529", "#333333");
    }

    /**
     * 设置百分比样式
     *
     * @param percentString
     */
    public static CharSequence spanablePercent(String percentString) {
        return scaleSpanable(percentString, "%", 1.5f);
    }

    /**
     * 设置人数样式
     *
     * @param percentString
     */
    public static CharSequence spanableCounts(String percentString) {
        return scaleSpanable(percentString, "人", 1.5f);
    }
}

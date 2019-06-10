package com.orange.chat2piao.utils;

import androidx.annotation.Nullable;

public class Preconditions {

    public static <T> void checkNotNull(T reference, @Nullable Object errorMessage) {
        if (reference == null) {
            throw new NullPointerException(String.valueOf(errorMessage));
        }
    }

    public static <T> void checkNotNull(@Nullable Object errorMessage, T... reference) {
        if (null == reference) throw new NullPointerException(String.valueOf(errorMessage));
        for (T t : reference) {
            if (null == t) throw new NullPointerException(String.valueOf(errorMessage));
        }
    }

    public static <T> void checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException("null == reference: " + reference.getClass().getSimpleName());
        }
    }
}

package com.orange.chat2piao.test;


import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.orange.chat2piao.test.callback.DefaultImpl;
import com.orange.chat2piao.test.callback.INetCallback;
import com.orange.chat2piao.test.callback.IRequestCallback;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IOException {
        test1(new INetCallback<List<String>>() {
            @Override
            public void callback(List<String> strings) {

            }
        });
    }

    /**
     * {@inheritDoc}
     */
    public static <T> void test(IRequestCallback<T> requestCallback) throws IOException {
        test1(new DefaultImpl<T>());
    }

    public static <T> void test1(INetCallback<T> callback) throws IOException {
        Type genericSuperclass = callback.getClass().getGenericSuperclass();
        String json = "[\"11\",\"12\",\"13\",\"14\",\"15\",\"16\",\"17\",\"18\",\"19\",\"20\"]";
        Gson gson = new Gson();
        TypeToken<T> typeToken = (TypeToken<T>) TypeToken.get(genericSuperclass);
        TypeAdapter<?> adapter = gson.getAdapter(typeToken);
        Type genericSuperclass1 = adapter.getClass().getGenericSuperclass();
        Object o = adapter.fromJson(json);
        System.out.println(o.toString());
    }


    static class Test<T> extends DefaultImpl<T> {
        @Override
        public void callback(T t) {
        }
    }

}

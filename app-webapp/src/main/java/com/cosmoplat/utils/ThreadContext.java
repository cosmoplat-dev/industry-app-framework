package com.cosmoplat.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Willard Hu on 2019/9/6.
 */
public class ThreadContext {
    public static final String BACKAUTH_CLAIMS_KEY = "BACKAUTH_CLAIMS";
//    public static final String  BACKAUTH_TOKEN_KEY = "BACKAUTH_TOKEN";
    private static final ThreadLocal<Map<String, Object>> CONTEXT = new InheritableThreadLocal<>();
    private static final Object LOCK = new Object();

    private ThreadContext() {
        throw new UnsupportedOperationException();
    }

    public static Object get(String key) {
        craeteInstanceIfNull();
        return CONTEXT.get().get(key);
    }

    public static <T> T get(String key, Class<T> clz) {
        craeteInstanceIfNull();
        return clz.cast(get(key));
    }

    public static void put(String key, Object value) {
        craeteInstanceIfNull();
        CONTEXT.get().put(key, value);
    }

    public static Object remove(String key) {
        craeteInstanceIfNull();
        return CONTEXT.get().remove(key);
    }

    public static void clear() {
        CONTEXT.remove();
    }

    private static void craeteInstanceIfNull() {
        if (CONTEXT.get() == null) {
            synchronized (LOCK) {
                if (CONTEXT.get() == null) {
                    CONTEXT.set(new ConcurrentHashMap<>());
                }
            }
        }
    }
}

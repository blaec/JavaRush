package com.javarush.task.task34.task3408;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        if (!cache.containsKey(key)) {

            // clazz.getConstructor(key.getClass()) - returns "public SomeValue(SomeKey myKey) "
            // .newInstance(key) - new SomeValue class instance
            cache.put(key, clazz.getConstructor(key.getClass()).newInstance(key));
        }
        return cache.get(key);
    }

    public boolean put(V obj) {
        //TODO add your code here
        boolean result = false;

        try {
            Method method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);

            K key = (K) method.invoke(obj);
            cache.put(key, obj);

            result =  cache.containsKey(key);
        } catch (Exception e) {
        }

        return result;
    }

    public int size() {
        return cache.size();
    }
}

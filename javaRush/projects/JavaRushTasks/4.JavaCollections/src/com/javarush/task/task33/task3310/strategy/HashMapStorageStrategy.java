package com.javarush.task.task33.task3310.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by blaec on 14\07\17.
 */
public class HashMapStorageStrategy implements StorageStrategy {
    private Map<Long, String> data = new HashMap<>();

    @Override
    public boolean containsKey(Long key) {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return data.containsValue(value);
    }

    @Override
    public void put(Long key, String value) {
        data.put(key, value);
    }

    @Override
    public Long getKey(String value) {
        Long result = null;

        for (Long key : data.keySet()) {
            if (data.get(key).equals(value)) {
                result = key;
                break;
            }
        }
        return result;
    }

    @Override
    public String getValue(Long key) {
        return data.get(key);
    }
}

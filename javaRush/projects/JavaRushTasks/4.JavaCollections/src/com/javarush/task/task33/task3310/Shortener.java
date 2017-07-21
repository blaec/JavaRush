package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

/**
 * Created by blaec on 14\07\17.
 */
public class Shortener {
    private Long lastId = Long.valueOf(0);      // last id which was used for adding new value to storage
    private StorageStrategy storageStrategy;    // stratage of values storage

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    // returns id for the string
    public synchronized Long getId(String string) {
        long key = 0;
        if (storageStrategy.containsValue(string)) {
            key = storageStrategy.getKey(string);
        }
        else {
            key = ++lastId;
            storageStrategy.put(key, string);
        }
        return key;
    }

    // returns string for id (or null if id's incorrect)
    public synchronized String getString(Long id) {
        return storageStrategy.getValue(id);
    }
}

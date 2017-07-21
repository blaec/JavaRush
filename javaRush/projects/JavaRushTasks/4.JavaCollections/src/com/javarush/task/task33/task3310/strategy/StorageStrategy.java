package com.javarush.task.task33.task3310.strategy;

/**
 * Created by blaec on 14\07\17.
 */
public interface StorageStrategy {

    // true if storage contains key
    public boolean containsKey(Long key);

    // true if storage contains value
    public boolean containsValue(String value);

    // add key-value pair to storage
    public void put(Long key, String value);

    // returns key for sent value
    public Long getKey(String value);

    // returns value for sent key
    public String getValue(Long key);
}

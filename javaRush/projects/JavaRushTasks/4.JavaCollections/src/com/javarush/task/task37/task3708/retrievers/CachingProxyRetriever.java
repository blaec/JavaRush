package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;
import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * Created by blaec on 16\07\17.
 */
public class CachingProxyRetriever implements Retriever{
    private LRUCache<Long, Object> cache;
    private OriginalRetriever originalRetriever;

    public CachingProxyRetriever(Storage storage) {
        originalRetriever = new OriginalRetriever(storage);
        cache  = new LRUCache<>(16);
    }

    @Override
    public Object retrieve(long key) {
        Object outValue = cache.find(key);

        if (outValue == null) {
            outValue = originalRetriever.retrieve(key);
            cache.set(key, outValue);
        };

        return outValue;
    }
}

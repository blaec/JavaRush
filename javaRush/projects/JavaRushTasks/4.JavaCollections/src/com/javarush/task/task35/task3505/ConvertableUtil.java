package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <K,V> Map<K,V> convert(List<? extends Convertable<K>> list) {
        Map result = new HashMap();
        for (Convertable e : list) {
            result.put(e.getKey(), e);
        }
        return result;
    }
}

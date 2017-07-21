package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        Iterator it = map.entrySet().iterator();
        int mapSize = 0;

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            List<V> list = (List<V>) pair.getValue();
            mapSize += list.size();
        }

        return mapSize;
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        List<V> values;
        V returned = null;

        if (map.get(key) == null) {
            values = new LinkedList<>();
        }
        else {
            values = map.get(key);
            returned = values.get(values.size() - 1);
        }
        values.add(value);
        if (values.size() > repeatCount) values.remove(0);
        map.put(key, values);

        return returned;
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        List<V> values = map.get(key);
        V result = null;
        if (values == null) return null;

        result = values.get(0);
        values.remove(0);

        if (values.size() == 0) {
            map.remove(key);
        }

        return result;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        return map.keySet();
    }

    public Collection<V> values() {
        //напишите тут ваш код
        List<V> data = new ArrayList<>();
        Iterator it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            data.addAll((List<V>) pair.getValue());
        }

        return data;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        Iterator it = map.entrySet().iterator();
        boolean result = false;

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            List<V> temp = (List<V>) pair.getValue();

            if (temp.contains(value)) {
                result = true;
                break;
            }
        }


        return  result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}
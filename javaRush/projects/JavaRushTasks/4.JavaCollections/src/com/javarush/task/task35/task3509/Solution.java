package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        //напишите тут ваш код
        List<T> ls = new ArrayList<>(Arrays.asList(elements));
//        for (int i = 0; i < elements.length; i++) {
//            ls.add(elements[i]);
//        }
        return (ArrayList<T>) ls;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        //напишите тут ваш код
        Set<T> st = new HashSet<>();
        for (int i = 0; i < elements.length; i++) {
            st.add(elements[i]);
        }
        return (HashSet<T>) st;
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        //напишите тут ваш код
        if (keys.size() != values.size())
            throw new IllegalArgumentException();

        Map<K, V> map = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), values.get(i));
        }
        return (HashMap<K, V>) map;
    }
}

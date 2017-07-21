package com.javarush.task.task08.task0817;

import java.util.*;

/*
Нам повторы не нужныНам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("jonson","jon");
        map.put("jason","ja");
        map.put("jobson","job");
        map.put("jagson","hen");
        map.put("forson","for");
        map.put("foxson","fox");
        map.put("lockson","lock");
        map.put("mochson","moch");
        map.put("hensome","hen");
        map.put("sonon","thebeach");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        Iterator it = map.entrySet().iterator();
        HashSet<String> set = new HashSet<>();
        ArrayList<String> list= new ArrayList<>();
        while (it.hasNext()) {
            Map.Entry<String, String> pair = (Map.Entry)it.next();
            if(!set.add(pair.getValue())) {
                list.add(pair.getValue());
            }
        }

        for (String entry : list) {
            removeItemFromMapByValue(map,entry);
        }


    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
    }
}

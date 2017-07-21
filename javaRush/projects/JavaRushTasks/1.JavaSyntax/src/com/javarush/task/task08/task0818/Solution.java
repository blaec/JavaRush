package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("jonson",1000);
        map.put("jason",950);
        map.put("jobson",130);
        map.put("jagson",280);
        map.put("forson",1000);
        map.put("foxson",750);
        map.put("lockson",440);
        map.put("mochson",200);
        map.put("hensome",220);
        map.put("sonon",210);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> pair = (Map.Entry)it.next();
            if (pair.getValue() < 500)
                it.remove();
        }
    }

    public static void main(String[] args) {
    }
}
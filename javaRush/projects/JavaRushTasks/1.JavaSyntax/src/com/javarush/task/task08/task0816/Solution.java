package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));

        //напишите тут ваш код
        map.put("Johnson", new Date(99,1,10));
        map.put("Jackson", new Date(77,2,10));
        map.put("Jayson", new Date(88,3,11));
        map.put("Jobson", new Date(84,4,11));
        map.put("Jagger", new Date(66,5,11));
        map.put("Baker", new Date(67,6,11));
        map.put("Bucker", new Date(22,7,11));
        map.put("Bicker", new Date(100,8,11));
        map.put("Bokertov", new Date(102,9,11));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Date> entry = (Map.Entry)it.next();
            Date fullDate = entry.getValue();
            if (fullDate.getMonth() >= 5 && fullDate.getMonth() <= 7)
                it.remove();
        }
    }

    public static void main(String[] args) {
    }
}

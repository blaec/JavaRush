package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> test = new LinkedHashMap<>();
        test.put("name", "Ivanov");
        test.put("country", "Ukraine");
        test.put("city", "Kiev");
        test.put("age", null);
        System.out.println(getQuery(test));
    }
    public static String getQuery(Map<String, String> params) {
        String query = "%s = '%s'";
        String and = " and ";
        StringBuilder sb = new StringBuilder();

        Iterator it = params.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if (pair.getValue() != null) {
                if (sb.length() != 0) { sb.append(and); }
                sb.append(String.format(query, pair.getKey(), pair.getValue()));
            }
        }

        return sb.toString();
    }
}

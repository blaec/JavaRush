package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hashMap = new HashMap<>();

        while (true) {
            String idString = reader.readLine();
            if (idString.length() == 0) break;
            int id = Integer.parseInt(idString);
            String name = reader.readLine();
            hashMap.put(name, id);
        }

        for (Map.Entry<String, Integer> pair : hashMap.entrySet()) {
            System.out.println(pair.getValue() + " " + pair.getKey());
//            System.out.println("Id=" + pair.getKey() + " Name=" + pair.getValue());
        }

    }
}

package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> list = new TreeMap<>();
        double max = 0;

        while (file.ready()) {
            String[] line = file.readLine().split(" ");
            double value = Double.parseDouble(line[1]);
            double putValue;
            if (list.containsKey(line[0])) {
                putValue = value + list.get(line[0]);
                list.put(line[0],putValue);
            }
            else {
                putValue = value;
                list.put(line[0],putValue);
            }

            max = max > putValue ? max : putValue;
        }

        file.close();


        Iterator it = list.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if (Double.compare((double)pair.getValue(), max) == 0) {
                System.out.println(pair.getKey());
            }
        }
    }
}

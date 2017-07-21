package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream((new BufferedReader(new InputStreamReader(System.in))).readLine());
        HashMap<Integer,Integer> bytes = new HashMap<>();

        while (fis.available() > 0) {
            int value = fis.read();
            if (bytes.containsKey(value))
                bytes.put(value,bytes.get(value) + 1);
            else
                bytes.put(value,1);
        }
        fis.close();


        Iterator it = bytes.entrySet().iterator();
        int minOccurance = Integer.MAX_VALUE;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            minOccurance = minOccurance > (int)pair.getValue() ? (int)pair.getValue() : minOccurance;
        }

        it = bytes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if ((int)pair.getValue() == minOccurance) {
                System.out.print(pair.getKey() + " ");
            }
        }

    }
}

package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream((new BufferedReader(new InputStreamReader(System.in))).readLine());
        HashMap<Integer, Integer> bytes = new HashMap<>();

        while (fis.available() > 0) {
            int nextByte = fis.read();

            if (bytes.containsKey(nextByte)) {
                bytes.put(nextByte,bytes.get(nextByte) + 1);
            }
            else {
                bytes.put(nextByte,1);
            }
        }

        int maxInstances = 0;
        Iterator it = bytes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            maxInstances = maxInstances > (int)pair.getValue() ? maxInstances : (int)pair.getValue();
        }

        String output = "";
        String space = "";
        it = bytes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if (maxInstances == (int)pair.getValue()) {
                if (output.length() > 0)
                    space = " ";
                output = output + space + pair.getKey();
            }
        }
        System.out.println(output);
        fis.close();
    }
}

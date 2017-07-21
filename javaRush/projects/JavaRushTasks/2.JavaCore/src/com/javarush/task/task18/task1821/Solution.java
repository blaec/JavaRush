package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        //FileInputStream fis = new FileInputStream("C:\\Users\\blaec\\Google Drive\\Java\\javaRush\\projects\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1820\\nums");
        Map<Integer, Integer> treeMap = new TreeMap<>();

        while (fis.available() > 0) {
            int value = fis.read();
            int count=1;
            if (treeMap.containsKey(value))
                count = treeMap.get(value) + 1;
            treeMap.put(value,count);
        }

        Iterator it = treeMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println((char) (int) pair.getKey() + " " + pair.getValue());
            //System.out.println((int) pair.getKey() + " " + pair.getValue());
        }

        fis.close();
    }
}

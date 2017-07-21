package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = null; ;
        try {
            reader  = new BufferedReader(new InputStreamReader(System.in));
            readFile(reader.readLine(), true);
            readFile(reader.readLine(), false);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }

    }

    public static void readFile(String file, boolean isAll) {
        BufferedReader fileRead = null;

        try {
            fileRead = new BufferedReader(new FileReader(new File(file)));
            String line;
            while ((line = fileRead.readLine()) != null) {
                if (isAll)
                    allLines.add(line);
                else
                    forRemoveLines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void joinData () throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else {
            allLines.removeAll(allLines);
            throw new CorruptedDataException();
        }
    }
}

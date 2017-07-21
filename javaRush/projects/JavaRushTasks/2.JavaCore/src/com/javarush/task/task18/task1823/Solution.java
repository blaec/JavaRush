package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file;

        while (!(file = reader.readLine()).equals("exit")) {
            ReadThread rt = new ReadThread(file);
            rt.start();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            try {
                FileInputStream fis = new FileInputStream(fileName);
                int[] codes = new int[256];
                while (fis.available()>0) {
                    int value = fis.read();
                    codes[value]++;
                }

                int max = 0;
                int maxCode = 0;
                for (int i = 0; i < codes.length; i++) {
                    if (codes[i] > max) {
                        max = codes[i];
                        maxCode = i;
                    }

                }
                resultMap.put(fileName, maxCode);
                fis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

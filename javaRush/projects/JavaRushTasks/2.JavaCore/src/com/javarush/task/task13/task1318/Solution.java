package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = null;

        try {
            fileName = bufferedReader.readLine();


            Scanner scanner = new Scanner(new FileInputStream(fileName));

            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }

            // Validator not accept char-reading
//            FileInputStream fis = new FileInputStream(fileName);

//            while (fis.available() > 0) {
//                byte[] buffer = new byte[fis.available()];
//                int count = fis.read(buffer);
//
//                for (int i = 0; i < buffer.length; i++) {
//                    System.out.print((char) buffer[i]);
//                }
//            }

//            fis.close();

            scanner.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
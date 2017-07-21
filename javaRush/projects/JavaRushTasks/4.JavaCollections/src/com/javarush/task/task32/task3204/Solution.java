package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream outputStream = null;
        Random rand = new Random();
        boolean hasNumber = false;
        boolean hasUCase = false;
        boolean hasLCase = false;

        while (!hasNumber || !hasUCase || !hasLCase) {
            outputStream = new ByteArrayOutputStream();
            hasNumber = false;
            hasUCase = false;
            hasLCase = false;

            for (int i = 0; i < 8; i++) {
                int ascii = rand.nextInt(75) + 48;
                if (ascii > 57 && ascii < 65 || ascii > 90 && ascii < 97) {
                    i--;
                }
                else {
                    outputStream.write(ascii);
                    if (ascii >= 48 && ascii <= 57) hasNumber = true;
                    if (ascii >= 65 && ascii <= 90) hasUCase = true;
                    if (ascii >= 97 && ascii <= 122) hasLCase = true;
                }
            }
        }
//        System.out.println(hasNumber + " " + hasLCase + " " + hasUCase);
        return outputStream;
    }
}
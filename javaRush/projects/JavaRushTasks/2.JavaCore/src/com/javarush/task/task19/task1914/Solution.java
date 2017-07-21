package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        String result = outputStream.toString();

        System.setOut(consoleStream);

        String[] arguments = result.split(" ");
        int output=0;
        int element1 = Integer.parseInt(arguments[0]);
        int element2 = Integer.parseInt(arguments[2]);
        for (int i = 0; i < arguments.length; i++) {
            switch (arguments[1]) {
                case "+":
                    output = element1 + element2;
                    break;
                case "-":
                    output = element1 - element2;
                    break;
                case "*":
                    output = element1 * element2;
                    break;
            }
        }
        System.out.println(result.replaceAll("\\p{Cntrl}","") + output);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}


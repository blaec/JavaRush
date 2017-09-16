package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = new ArrayList<>();

        try {
            String file = reader.readLine();
//            String file = "C:\\Users\\blaec\\Google Drive\\Java\\javaRush\\projects\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task13\\task1326\\file";
            FileInputStream fis = new FileInputStream(file);
            Scanner scanner = new Scanner(fis);

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                numbers.add(Integer.parseInt(line));
            }

            fis.close();
            scanner.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(numbers);
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                System.out.println(number);
            }
        }
    }
}

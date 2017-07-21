package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Solution {
    public static void main(String[] args) throws IOException {

        //Считать с консоли имя файла.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        reader.close();

        //Программа запускается с одним параметром: id (int).
        int id = Integer.parseInt(args[0]);

        //Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
        BufferedReader br = new BufferedReader(new FileReader(path));
        while (true) {
            String s = br.readLine();
            if (s == null) {
                break;
            }
            if (id == Integer.parseInt(s.split(" ")[0])) {
                System.out.println(s);
                br.close();
                break;
            }
        }
    }
}

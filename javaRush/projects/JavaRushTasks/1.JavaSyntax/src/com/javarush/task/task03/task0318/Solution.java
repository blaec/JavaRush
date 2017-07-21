package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        String sYear = bufferedReader.readLine();
        String name = bufferedReader.readLine();

        int iYear = Integer.parseInt(sYear);

        System.out.println(name + " захватит мир через " + iYear + " лет. Му-ха-ха!");
    }
}

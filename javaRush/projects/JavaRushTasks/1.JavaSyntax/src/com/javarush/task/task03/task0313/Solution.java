package com.javarush.task.task03.task0313;

/* 
Мама мыла раму
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        String [] s = {"Мама", "Мыла", "Раму"};
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                for (int ii = 0; ii < 3; ii++)
                    if (s[i] != s[j] && s[j] != s[ii] && s[ii] != s[i])
                        System.out.println(s[i]+s[j]+s[ii]);

        /*
        ArrayList<String> words = new ArrayList<String>();
        words.add("Мама");
        words.add("Mыла");
        words.add("Pаму");

        for (int x=1; x<=2; x++) {
            for(int i = 1; i <= 3; i++) {
                int a = mod(i + 0);
                int b = mod(a + x);
                int c = mod(b + x);

                StringBuilder sb = new StringBuilder();
                sb.append(words.get(a-1));
                sb.append(words.get(b-1));
                sb.append(words.get(c-1));

                System.out.println( sb.toString());
            }
        }
        */


    }

    /*
    private static int mod(int i) {
        int add=0;

        if(i > 3) {
            add = 1;
        }
        return i % 4 + add;
    }
    */
}

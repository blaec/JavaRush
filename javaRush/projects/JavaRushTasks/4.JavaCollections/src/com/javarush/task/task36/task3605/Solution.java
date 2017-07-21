package com.javarush.task.task36.task3605;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String file = args[0];
//        String file = "C:\\Users\\blaec\\TEMP_JAVA\\TreeSet.txt";

        FileInputStream fis = new FileInputStream(new File(file));
        Set<String> chars = new TreeSet<>();

        while (fis.available() > 0) {
            chars.add(String.valueOf((char) fis.read()).toLowerCase());
        }

        fis.close();


        int count = 0;
        for (String elmt : chars) {
            if (elmt.toCharArray()[0] >= 97 && elmt.toCharArray()[0] <= 122) {
                System.out.print(elmt);
                if (++count == 5) break;
            }
        }



//        TreeSet<Character> letters = new TreeSet<>();
//        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
//            while (fileReader.ready()) {
//                String s = fileReader.readLine().toLowerCase().replaceAll("[^\\p{Alpha}]",""); //\s\p{Punct}
//                for (int i = 0; i < s.length(); i++)
//                    letters.add(s.charAt(i));
//            }
//        }
//
//        Iterator<Character> iterator = letters.iterator();
//        int n = letters.size() < 5 ? letters.size() : 5;
//
//        for (int i = 0; i < n; i++) {
//            System.out.print((iterator.next()));
//        }
//    }

    }
}

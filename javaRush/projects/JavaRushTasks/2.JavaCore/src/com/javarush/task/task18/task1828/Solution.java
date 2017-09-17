package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        if (args.length == 0) return;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();

            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
                String line;
                List<String> list = new LinkedList<>();

                // read file into list
                while ((line = fileReader.readLine()) != null) {
                    list.add(line);
                }


                try (FileOutputStream fos = new FileOutputStream(fileName)) {
                    for (String s : list) {
                        int id = Integer.parseInt(s.substring(0, 8).trim());

                        // update the line with sent id
                        if (args[0].equals("-u")) {
                            if (id != Integer.parseInt(args[1])) {
                                fos.write((String.format("%s%n", s)).getBytes());
                            }
                            else {
                                fos.write(String.format("%-8s%-30s%-8s%-4s%n", args[1], args[2], args[3], args[4]).getBytes());
                            }
                        }

                        // write all lines apart the one that contain sent id
                        else if (args[0].equals("-d")) {
                            if (id != Integer.parseInt(args[1])) {
                                fos.write((String.format("%s%n", s)).getBytes());
                            }
                        }
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

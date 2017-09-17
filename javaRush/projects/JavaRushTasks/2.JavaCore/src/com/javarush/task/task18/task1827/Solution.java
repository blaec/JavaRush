package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.*;

// works but not accepted, maybe appending to file not allowed, file must be rewritten
//public class Solution {
//    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        List<String> content = new ArrayList<>();
//
//        String file = reader.readLine();
//
//        Scanner scanner = new Scanner(new FileInputStream(file));
//
//        while (scanner.hasNext()) {
//            content.add(scanner.nextLine());
//        }
//
//        if (args[0].equals("-c")) {
//            String lastString = content.get(content.size() - 1);
//            int idOfLastString = Integer.parseInt(lastString.substring(0, 8).replaceAll(" ", ""));
//            int nextId = idOfLastString + 1;
//
//            String input = String.format("%n%-8d%-30s%-8s%s", nextId, args[1], args[2], args[3]);
//
//            Writer output = new BufferedWriter(new FileWriter(file, true));
//            output.append(input);
//            output.close();
//        }
//
//        scanner.close();
//        reader.close();
//    }
//}


public class Solution {
    public static void main(String[] args) throws Exception {
//        args = new String[]{"-c", "123456789012345678901234567890", "12345678", "1234"};
//        args = new String[]{"-c", "30", "8", "4"};
//        args = new String[]{"-c", "Куртка для сноубордистов, разм", "10173.99", "1234"};
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();
            try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
                String line;
                int maxId = 0;
                List<String> list = new LinkedList<>();
                while ((line = fileReader.readLine()) != null) {
                    list.add(line);

                    int id = Integer.parseInt(line.substring(0, 8).trim());
                    maxId = maxId > id ? maxId : id;
                }
                try (FileOutputStream fos = new FileOutputStream(fileName)) {
                    for (String s : list) {
                        fos.write((String.format("%s%n", s)).getBytes());
                    }

                    fos.write(String.format("%-8s%-30s%-8s%-4s%n", ++maxId, args[1], args[2], args[3]).getBytes());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


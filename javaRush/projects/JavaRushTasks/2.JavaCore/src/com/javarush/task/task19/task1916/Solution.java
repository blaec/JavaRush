package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

//        file1 = "C:\\Users\\blaec\\t.txt";
//        file2 = "C:\\Users\\blaec\\z.txt";
        BufferedReader read1 = new BufferedReader(new FileReader(file1));
        BufferedReader read2 = new BufferedReader(new FileReader(file2));
        LinkedList<String> list1 = new LinkedList<>();
        LinkedList<String> list2 = new LinkedList<>();

        while (read1.ready())
            list1.add(read1.readLine());
        read1.close();

        while (read2.ready())
            list2.add(read2.readLine());
        read2.close();

        for (int i = 0; i < list1.size(); i++) {
            try {
                if (list1.get(i).equals(list2.get(i))) {
                    lines.add(new LineItem(Type.SAME, list1.get(i)));
                }
                else {
                    if (!list1.get(i).equals(list2.get(i+1))) {
                        lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                        list2.add(i,list1.get(i));
                    }
                    else {
                        lines.add(new LineItem(Type.ADDED, list2.get(1)));
                        list1.add(i,list2.get(i));
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                list2.add(i,list1.get(i));
            }
        }

        while (list1.size() != list2.size()) {
            int i = list1.size();
            lines.add(new LineItem(Type.ADDED, list2.get(i)));
            list1.add(i,list2.get(i));
        }


//        for (LineItem pair : lines) {
//            System.out.println(pair.type + ": " + pair.line);
//        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}

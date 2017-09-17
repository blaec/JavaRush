package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// not accepted, although result identical
//public class Solution {
//    public Map<Integer, String> indexes = new TreeMap<>();
//
//    public static void main(String[] args) {
//        final String OPEN = "open";
//        final String CLOSE = "close";
//
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            String fileName = reader.readLine();
////            String fileName = "C:\\Users\\blaec\\Google Drive\\Java\\javaRush\\projects\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1918\\test";
//            StringBuilder html = new StringBuilder();
//
//            // read file
//            try (Scanner scanner = new Scanner(new FileReader(fileName))) {
//                while (scanner.hasNext()) {
//                    html.append(scanner.nextLine());
//                }
//            }
//            String text = html.toString().replaceAll("\r\n", "");
//
//            String tag = args[0];
////            String tag = "li";
//            String tagOpen1 = String.format("<%s>", tag);
//            String tagOpen2 = String.format("<%s ", tag);
//            String tagClose = String.format("</%s>", tag);
//            Solution solution = new Solution();
//            solution.addIndexes(text, tagOpen1, OPEN);
//            solution.addIndexes(text, tagOpen2, OPEN);
//            solution.addIndexes(text, tagClose, CLOSE);
//
//            int countTag = 0;
//            int from = 0;
//            StringBuilder output = new StringBuilder();
//            for (Integer index : solution.indexes.keySet()) {
//                if (countTag == 0) from = index;
//
//                String status = solution.indexes.get(index);
//                switch (status) {
//                    case OPEN:  countTag++; break;
//                    case CLOSE: countTag--; break;
//                }
//
//                if (countTag == 0) {
//                    output.append(text.substring(from, index)).append(tagClose).append("\n");
//                }
//            }
//
//            System.out.println(output.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void addIndexes(String text, String tag, String type) {
//        int fromIndex = 0;
//
//        while (true) {
//            int inPos = text.indexOf(tag, fromIndex);
//            if (inPos == -1) break;
//            fromIndex = inPos + 1;
//
//            indexes.put(inPos, type);
//        }
//    }
//}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = conReader.readLine();
        conReader.close();

        //Read File
        BufferedReader fileBufReader = new BufferedReader(new FileReader(fileName));
        StringBuffer content = new StringBuffer();
        while (fileBufReader.ready())
            content.append(fileBufReader.readLine());
        fileBufReader.close();
        StringBuffer text = new StringBuffer(content.toString().replaceAll("\r\n", ""));

        String tagOpen = "<" + args[0];
        String tagClose = "</" + args[0] + ">";

        int pozitionOpen = -1;
        int pozitionClose = -1;
        int shift = -1;
        Stack<Integer> openedTags = new Stack<>();
        Map<Integer, Integer> tags = new TreeMap<>(new MyComparator());
        while (true) {
            pozitionOpen = text.indexOf(tagOpen, shift);
            pozitionClose = text.indexOf(tagClose, shift);
            if (pozitionOpen < 0 && pozitionClose < 0)
                break;

            if (pozitionOpen != -1 && pozitionOpen < pozitionClose) { //Open ближе чем close
                openedTags.push(pozitionOpen);
                shift = pozitionOpen + tagOpen.length();
                continue;
            }

            if (pozitionClose != -1 && (pozitionOpen > pozitionClose || pozitionOpen == -1)) { //Close ближе чем open
                if (openedTags.isEmpty())
                    break;
                tags.put(openedTags.pop(), pozitionClose + tagClose.length());
                shift = pozitionClose + tagClose.length();
            }
        }

        for (Map.Entry<Integer, Integer> pair : tags.entrySet()) {
            System.out.println(text.substring(pair.getKey(), pair.getValue()));
        }
    }

    static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer a, Integer b) {
            return a.compareTo(b);
        }
    }
}

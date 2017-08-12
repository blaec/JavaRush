package com.javarush.task.task22.task2207;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {

//        // Get path, read file and save all unique words to HashSet
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        Scanner in = null;
//        String path = null;
//        Set<String> words = new HashSet<>();
//        path = reader.readLine();
//        in = new Scanner(Paths.get(path));
//
//        while (in.hasNext()) {
//            words.add(in.next());
//        }
//
//        in.close();
//        reader.close();
//
//        Iterator<String>it = words.iterator();
//        while (it.hasNext()) {
//            String word = it.next();
//            String reversed = new StringBuilder(word).reverse().toString();
//            if (words.contains(reversed)) {
//                Pair pair = new Pair();
//                pair.first = word;
//                pair.second= reversed;
//
//                result.add(pair);
//                it.remove();
//            }
//        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader readerF = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        while (readerF.ready()) {
            sb.append(readerF.readLine() + " ");
        }
        readerF.close();
        String[] arr = sb.toString().trim().split("\\s+");
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(i)) continue;
            for (int j = i+1; j < arr.length; j++) {
                String x = new StringBuilder(arr[j]).reverse().toString();
                if (x.equals(arr[i])) {
                    Pair pair = new Pair();
                    pair.first = x;
                    pair.second = arr[j];
                    result.add(pair);
                    set.add(j);
                    break;
                }
            }
        }

        for (Pair pair : result) {
            System.out.println(pair);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}

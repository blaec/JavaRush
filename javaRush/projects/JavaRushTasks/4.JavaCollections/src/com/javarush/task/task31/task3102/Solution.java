package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> files = new ArrayList<>();
        Stack stack = new Stack();
        stack.push(new File(root));
        while (!stack.empty()) {
            File elt = (File) stack.pop();
            if (elt.isDirectory()) {
                for (File file : elt.listFiles()) { //pushStack
                    stack.push(file);
                }
            }
            else {
                files.add(elt.getAbsolutePath());
            }
        }
        return files;

    }

    public static void main(String[] args) throws IOException {
        List<String> myFiles = getFileTree("C:/Users/blaec/TEMP_JAVA/");
        for (String file : myFiles) {
            System.out.println(file);
        }
    }


}

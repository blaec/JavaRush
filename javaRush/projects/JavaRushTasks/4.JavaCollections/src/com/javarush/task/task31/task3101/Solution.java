package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File folder = new File(args[0]);
        File original = new File(args[1]);
        File newOriginal = new File(original.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(original,newOriginal);
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(newOriginal);

            Map<String, String> files = fileList(folder);
            for (Map.Entry pair: files.entrySet()) {
                File tempFile = new File(String.valueOf(pair.getValue()));
                BufferedReader reader = new BufferedReader(new FileReader(tempFile));
                while (reader.ready()) {
                    String line = reader.readLine();

                    fos.write((line+"\n").getBytes());
                }
                reader.close();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fos.close();
        }

    }

    public static Map<String, String> fileList(File folder) {
        Map<String, String> list = new TreeMap<>();
        FileUtils fuls = new FileUtils();

        for (File temp: folder.listFiles()) {
            if (temp.isDirectory()) {
                Map<String, String> subList = fileList(new File(temp.getAbsolutePath()));
                list.putAll(subList);
            }
            else {
                File tempFile = new File(String.valueOf(temp.getAbsolutePath()));
                if (tempFile.length() > 50) {
                    fuls.deleteFile(tempFile);
                }
                else {
                    list.put(temp.getName(), temp.getAbsolutePath());
                }
            }
        }
        return list;
    }
    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }
}

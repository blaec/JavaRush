package com.javarush.task.task31.task3113;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {
    static int countDir;
    static int countFiles;
    static long dirSize;

    public static void main(String[] args) throws IOException {
        String path = (new BufferedReader(new InputStreamReader(System.in))).readLine();

        if (!Files.isDirectory(Paths.get(path)))
            System.out.println(path + " - не папка");
        else {

            Files.walkFileTree(Paths.get(path), new myFileVisitor());
            System.out.println("Всего папок - " + (countDir - 1));
            System.out.println("Всего файлов - " + countFiles);
            System.out.println("Общий размер - " + dirSize);
        }
    }
    static class myFileVisitor extends SimpleFileVisitor<Path>
    {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            if(Files.isDirectory(dir)){ countDir++;}
            return FileVisitResult.CONTINUE;
        }
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if(!Files.isDirectory(file)){countFiles++;dirSize += Files.size(file);}
            return FileVisitResult.CONTINUE;
        }
    }
}


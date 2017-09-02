package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(bufferedReader.readLine()));
        zipFileManager.createZip(Paths.get(bufferedReader.readLine()));
//        ZipFileManager zipFileManager = new ZipFileManager(Paths.get("C:\\CCC Images\\file.zip"));
//        zipFileManager.createZip(Paths.get("C:\\CCC Images\\file.csv"));

        bufferedReader.close();

        ExitCommand exitCommand = new ExitCommand();
        exitCommand.execute();
    }
}

package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipAddCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("");
            Path sourcePath = Paths.get(ConsoleHelper.readString());
            zipFileManager.addFile(sourcePath);

            ConsoleHelper.writeMessage("Архив создан.");

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("");
        }
    }
}

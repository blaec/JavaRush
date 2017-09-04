package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExtractCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Extract archive.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Enter full path to folder for files to extract:");
            Path sourcePath = Paths.get(ConsoleHelper.readString());
            zipFileManager.extractAll(sourcePath);

            ConsoleHelper.writeMessage("Archive extracted.");

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }
    }
}

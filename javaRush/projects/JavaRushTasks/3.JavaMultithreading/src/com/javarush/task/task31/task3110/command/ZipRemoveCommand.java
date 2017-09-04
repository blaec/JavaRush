package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Paths;

public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Delete file from archive.");

        ConsoleHelper.writeMessage("Enter zip-file path and file name to remove:");
        ZipFileManager zipFileManager = getZipFileManager();

        zipFileManager.removeFile(Paths.get(ConsoleHelper.readString()));

//        ZipFileManager zipFileManager = new ZipFileManager(Paths.get("C:\\CCC Images\\file.zip"));
//
//        zipFileManager.removeFile(Paths.get("WSOutput 05'02'17 13'12.xlsm"));

        ConsoleHelper.writeMessage("File deleted.");
    }
}

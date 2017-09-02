package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) throws Exception {
//        Constructor<CommandExecutor> constructor = CommandExecutor.class.getDeclaredConstructor(new Class[0]);
//        constructor.setAccessible(true);
//        CommandExecutor commandExecutor = constructor.newInstance(new Object[0]);
        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
        } while (operation != Operation.EXIT);
    }

    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("Выберите операцию:\n" +
                                   "0 - упаковать файлы в архив\n" +
                                   "1 - добавить файл в архив\n" +
                                   "2 - удалить файл из архива\n" +
                                   "3 - распаковать архив\n" +
                                   "4 - просмотреть содержимое архива\n" +
                                   "5 – выход");
        int operationId = ConsoleHelper.readInt();
//        Operation result = null;
//        for (Operation operation : Operation.values()) {
//            if (operation.ordinal() == operationId) {
//                result = operation;
//                break;
//            }
//        }
//        if (result == null) throw new IOException();

        return Operation.values()[operationId];
    }
}

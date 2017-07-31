package com.javarush.task.task26.task2613;

/*
    writeMessage(String message),   который будет писать в консоль наше сообщение.
    String readString(),            который будет считывать с консоли строку и возвращать ее.
 */

import com.javarush.task.task26.task2613.command.CommandExecutor;

import java.io.IOException;
import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ENGLISH);



        while (true) {
            Operation operation = ConsoleHelper.askOperation();
            CommandExecutor.execute(operation);

            if (operation == Operation.EXIT) break;
        }
    }
}

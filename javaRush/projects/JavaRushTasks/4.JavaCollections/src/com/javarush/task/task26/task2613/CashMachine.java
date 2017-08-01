package com.javarush.task.task26.task2613;

/*
    writeMessage(String message),   который будет писать в консоль наше сообщение.
    String readString(),            который будет считывать с консоли строку и возвращать ее.
 */

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args)  {
        try {
            Locale.setDefault(Locale.ENGLISH);


            while (true) {
                Operation operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);

                if (operation == Operation.EXIT) break;
            }
        } catch (InterruptOperationException e) {
            ConsoleHelper.writeMessage("G'bye");
        } catch (NotEnoughMoneyException e) {
            e.printStackTrace();
        }
    }
}

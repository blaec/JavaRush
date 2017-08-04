package com.javarush.task.task26.task2613;

/*
    writeMessage(String message),   write message to console
    String readString(),            read and return string from console
 */

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Locale;

public class CashMachine {
    public static final String RESOURCE_PATH = CashMachine.class.getPackage().getName() + ".resources.";

    public static void main(String[] args)  {
        try {
            Locale.setDefault(Locale.ENGLISH);
            CommandExecutor.execute(Operation.LOGIN);

            while (true) {
                Operation operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);

                if (operation == Operation.EXIT) break;
            }
        } catch (InterruptOperationException e) {
            ConsoleHelper.printExitMessage();
        } catch (NotEnoughMoneyException e) {
            e.printStackTrace();
        }
    }
}

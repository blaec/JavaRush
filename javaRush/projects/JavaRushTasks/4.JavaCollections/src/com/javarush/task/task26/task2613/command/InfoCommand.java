package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.IOException;

class InfoCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        boolean noMoney = true;

        for (CurrencyManipulator manipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {

            if (manipulator.hasMoney()) {
                String code = manipulator.getCurrencyCode();
                int sum = manipulator.getTotalAmount();

                ConsoleHelper.writeMessage(code + " - " + sum + "\n");
                noMoney = false;
            }
        }

        if (noMoney) ConsoleHelper.writeMessage("No money available. ");
    }
}

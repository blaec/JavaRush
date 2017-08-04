package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.IOException;
import java.util.ResourceBundle;

class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.info_en");

    @Override
    public void execute() throws InterruptOperationException {
        boolean noMoney = true;

        ConsoleHelper.writeMessage(res.getString("before"));
        for (CurrencyManipulator manipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {

            if (manipulator.hasMoney()) {
                String code = manipulator.getCurrencyCode();
                int sum = manipulator.getTotalAmount();

                ConsoleHelper.writeMessage(code + " - " + sum + "\n");
                noMoney = false;
            }
        }

        if (noMoney) ConsoleHelper.writeMessage(res.getString("no.money"));
    }
}

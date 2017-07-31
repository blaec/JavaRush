package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.io.IOException;

class DepositCommand implements Command {
    @Override
    public void execute() throws IOException {
        String code = ConsoleHelper.askCurrencyCode();
        String[] currency = ConsoleHelper.getValidTwoDigits(code);

        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        int denomination = Integer.parseInt(currency[0]);
        int count = Integer.parseInt(currency[1]);
        currencyManipulator.addAmount(denomination, count);
    }
}

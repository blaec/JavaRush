package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CurrencyManipulator;

class InfoCommand implements Command {
    @Override
    public void execute() {
        CurrencyManipulator currencyManipulator = new CurrencyManipulator();

        int amount = currencyManipulator.getTotalAmount();
    }
}

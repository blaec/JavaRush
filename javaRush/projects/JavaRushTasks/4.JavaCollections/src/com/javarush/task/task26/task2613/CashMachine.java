package com.javarush.task.task26.task2613;

/*
    writeMessage(String message),   который будет писать в консоль наше сообщение.
    String readString(),            который будет считывать с консоли строку и возвращать ее.
 */

import java.io.IOException;
import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ENGLISH);

        String code = ConsoleHelper.askCurrencyCode();
        String[] currency = ConsoleHelper.getValidTwoDigits(code);

        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        int denomination = Integer.parseInt(currency[0]);
        int count = Integer.parseInt(currency[1]);
        currencyManipulator.addAmount(denomination, count);
    }
}

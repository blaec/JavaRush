package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String line = "";

        try {
            line = bis.readLine();
            if (line.equalsIgnoreCase(res.getString("operation.EXIT"))) {
                throw new InterruptOperationException();
            }
        } catch (IOException e) { }


        return line;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        String code = null;

        while (true) {
            writeMessage(res.getString("choose.currency.code"));
            code = readString();

            // Validation
            if (code.length() == 3 && !code.matches(".*\\d+.*")) {
                break;
            }
            else {
                writeMessage(res.getString("invalid.data"));
            }
        }

        return code.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        String[] input;

        while (true) {
            writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
            input = readString().split(" ");

            // Validation
            int denomination = 0;
            int count = 0;
            boolean correct = true;
            try {
                denomination = Integer.parseInt(input[0]);
                count = Integer.parseInt(input[1]);
            } catch (Exception e) { correct = false; }
            if (correct && denomination > 0 && count > 0) { break; }

            writeMessage(res.getString("invalid.data"));
        }

        return input;
    }

    public static Operation askOperation() throws InterruptOperationException {
        Operation operation = null;

        while (true) {
            writeMessage(res.getString("choose.operation"));
            writeMessage( res.getString("operation.INFO") + ": 1;\n" +
                    res.getString("operation.DEPOSIT") + ": 2;\n" +
                    res.getString("operation.WITHDRAW") + ": 3;\n" +
                    res.getString("operation.EXIT") + ": 4\n");
            String option = readString();

            // Validation
            boolean correct = true;
            try {
                operation = Operation.getAllowableOperationByOrdinal(Integer.parseInt(option));
            } catch (Exception e) { correct = false; }
            if (correct) break;
        }

        return operation;
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }
}

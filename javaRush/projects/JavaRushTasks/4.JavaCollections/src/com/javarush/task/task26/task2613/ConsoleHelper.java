package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String line = "";

        try {
            line = bis.readLine();
            if (line.equalsIgnoreCase("exit")) {
                throw new InterruptOperationException();
            }
        } catch (IOException e) { }


        return line;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        String code = null;

        while (true) {
            writeMessage("Enter currency code (3 chars): ");
            code = readString();

            // Validation
            if (code.length() == 3 && !code.matches(".*\\d+.*")) {
                break;
            }
            else {
                writeMessage("Incorrect entry. ");
            }
        }

        return code.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        String[] input;

        while (true) {
            writeMessage("Enter banknote value and number of banknotes with space as delimiter: ");
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

            writeMessage("Incorrect entry. ");
        }

        return input;
    }

    public static Operation askOperation() throws InterruptOperationException {
        Operation operation = null;

        while (true) {
            writeMessage("Choose operation: 1-Info, 2-Deposit, 3-Withdraw, 4-Exit: ");
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
}

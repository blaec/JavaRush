package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Iterator;
import java.util.Map;

class WithdrawCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException, NotEnoughMoneyException {

        // read currency code and get its manipulator
        CurrencyManipulator currencyManipulator = null;
        while (currencyManipulator == null) {
            String code = ConsoleHelper.askCurrencyCode();
            currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        }


        boolean enoughMoney = false;
        while (!enoughMoney) {

            // ask sum to withdraw, check if entered sum correct and available
            ConsoleHelper.writeMessage("Enter the sum to withdraw: ");
            int sum = 0;
            boolean sumWrong = true;
            while (sumWrong && !currencyManipulator.isAmountAvailable(sum)) {
                try {
                    sum = Integer.parseInt(ConsoleHelper.readString());
                    sumWrong = false;
                } catch (Exception e) { sumWrong = true; }
            }

            // display output
            try {
                Iterator it = currencyManipulator.withdrawAmount(sum).entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    int key = (int) pair.getKey();
                    int value = (int) pair.getValue();

                    ConsoleHelper.writeMessage("\t" + key + " - " + value + "\n");
                }
                ConsoleHelper.writeMessage("Withdrawal successful\n");
                enoughMoney = true;
            } catch (NotEnoughMoneyException e) { enoughMoney = false; }
        }

    }
}

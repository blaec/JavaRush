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
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        int amount = 0;

        while (true) {
            try {

                // ask amount to withdraw, check if entered sum correct and available
                ConsoleHelper.writeMessage("Enter the sum to withdraw: ");

                amount = Integer.parseInt(ConsoleHelper.readString());
                if (amount <= 0) throw new NumberFormatException();
                if (!currencyManipulator.isAmountAvailable(amount))
                    throw new NotEnoughMoneyException();

                Map<Integer, Integer> withdrawn = currencyManipulator.withdrawAmount(amount);
                Iterator it = withdrawn.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    int key = (int) pair.getKey();
                    int value = (int) pair.getValue();

                    ConsoleHelper.writeMessage("\t" + key + " - " + value + "\n");
                }
                ConsoleHelper.writeMessage("Withdrawal successful\n");
                break;
            } catch (NumberFormatException e)   { ConsoleHelper.writeMessage("Incorrect entry. ");
            } catch (NotEnoughMoneyException e) { ConsoleHelper.writeMessage("Not enough banknotes. ");
            }
        }
    }
}

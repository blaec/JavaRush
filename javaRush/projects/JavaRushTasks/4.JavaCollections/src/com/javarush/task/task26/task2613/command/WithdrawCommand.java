package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException, NotEnoughMoneyException {

        // read currency code and get its manipulator
        ConsoleHelper.writeMessage(res.getString("before"));
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        int amount = 0;

        while (true) {
            try {

                // ask amount to withdraw, check if entered sum correct and available
                ConsoleHelper.writeMessage(res.getString("specify.amount"));

                try {
                    amount = Integer.parseInt(ConsoleHelper.readString());
                } catch (NumberFormatException e) {
                    continue;
                }
                if (amount <= 0) {
                    ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                    continue;
                }
                if (!currencyManipulator.isAmountAvailable(amount)) {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                    continue;
                }

                Map<Integer, Integer> withdrawn = currencyManipulator.withdrawAmount(amount);
                int key = 0;
                int value = 0;
                Iterator it = withdrawn.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    key = (int) pair.getKey();
                    value = (int) pair.getValue();

                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), key * value, code));
                }
                break;
            } catch (NotEnoughMoneyException e) { ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
            }
        }
    }
}

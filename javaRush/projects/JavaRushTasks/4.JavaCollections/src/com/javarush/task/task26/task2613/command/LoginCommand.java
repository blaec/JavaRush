package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.verifiedCards");

    @Override
    public void execute() throws InterruptOperationException {

        while (true) {

            // Ask to enter card id and pin code
            ConsoleHelper.writeMessage("Type card number [12 digits] and pin code [4 digits]: ");
            String cardId = ConsoleHelper.readString();
            String pinCode = ConsoleHelper.readString();

            // Check if entered data valid
            if (cardId.matches("\\d{12}") && cardId.length() == 12 &&
                    pinCode.matches("\\d{4}") && pinCode.length() == 4) {

                // Try to identify data
                if (validCreditCards.containsKey(cardId) && validCreditCards.getString(cardId).equals(pinCode)) {
                    ConsoleHelper.writeMessage("Entered data is valid. ");
                    break;
                }

// Validation does not accept this method, it's not effective but works
//                Enumeration bundleKeys = validCreditCards.getKeys();
//                boolean accessGranted = false;
//                while (bundleKeys.hasMoreElements()) {
//                    String creditCard = (String) bundleKeys.nextElement();
//                    String pin = validCreditCards.getString(creditCard);
//
//                    if (cardId.equals(creditCard) && pinCode.equals(pin)) {
//                        ConsoleHelper.writeMessage("Entered data is valid. ");
//                        accessGranted = true;
//                        break;
//                    }
//                }
//                if (accessGranted) break;
            }
            else ConsoleHelper.writeMessage("Invalid data. ");
        }
    }
}

package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

public class LoginCommand implements Command {


    @Override
    public void execute() throws InterruptOperationException {
        String creditCard = "123456789012";
        String pin = "1234";

        while (true) {

            // Ask to enter card id and pin code
            ConsoleHelper.writeMessage("Type card number [12 digits] and pin code [4 digits]: ");
            String cardId = ConsoleHelper.readString();
            String pinCode = ConsoleHelper.readString();

            // Check if entered data valid
            if (cardId.matches("\\d{12}") && cardId.length() == 12 &&
                    pinCode.matches("\\d{4}") && pinCode.length() == 4) {

                // Try to identify data
                if (cardId.equals(creditCard) && cardId.equals(pin)) {
                    ConsoleHelper.writeMessage("Entered data is valid. ");
                    break;
                }
                else {
                    ConsoleHelper.writeMessage("Invalid data. ");

                    // ??? Validator requires exit at this point, i.e. user can proceed with incorrect data
                    break;
                }
            }
            else ConsoleHelper.writeMessage("Invalid data. ");
        }
    }
}

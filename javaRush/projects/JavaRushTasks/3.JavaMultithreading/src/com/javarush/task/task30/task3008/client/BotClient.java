package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {
    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            if (message != null)  {
                ConsoleHelper.writeMessage(message);

                if (message.contains(": ")) {
                    String[] data = message.split(": ");
                    if (data.length == 2 && data[1] != null) {
                        String outputFormat = null;

                        switch (data[1]) {
                            case "дата":
                                outputFormat = "d.MM.YYYY";
                                break;
                            case "день":
                                outputFormat = "d";
                                break;
                            case "месяц":
                                outputFormat = "MMMM";
                                break;
                            case "год":
                                outputFormat = "YYYY";
                                break;
                            case "время":
                                outputFormat = "H:mm:ss";
                                break;
                            case "час":
                                outputFormat = "H";
                                break;
                            case "минуты":
                                outputFormat = "m";
                                break;
                            case "секунды":
                                outputFormat = "s";
                                break;
                        }

                        if (outputFormat != null) {
                            DateFormat dateFormat = new SimpleDateFormat(outputFormat);
                            String outDate = dateFormat.format(Calendar.getInstance().getTime());
                            String outMsg = String.format("Информация для %s: %s", data[0], outDate);
                            sendTextMessage(outMsg);
                        }
                    }
                }
            }
        }
    }

    @Override
    protected String getUserName() {
        return String.format("date_bot_%d", (int) (Math.random() * 100));
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}

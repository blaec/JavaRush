package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress() {
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Error");
            clientConnected = false;
        }
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Error");
            }
        }

        synchronized (this) {
            this.notify();
            if (clientConnected) {
                ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду ‘exit’.");
                while (clientConnected) {
                    String message = ConsoleHelper.readString();
                    if (message.equals("exit")) break;
                    if (shouldSendTextFromConsole()) sendTextMessage(message);
                }
            } else
                ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");

        }

    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " connected to chat");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " left chat");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {

            Message message;

            while (!clientConnected) {
                message = connection.receive();

                if (message.getType() == MessageType.NAME_REQUEST) {
                    String userName = getUserName();
                    connection.send(new Message(MessageType.USER_NAME, userName));
                }
                else {
                    if (message.getType() == MessageType.NAME_ACCEPTED) {
                        notifyConnectionStatusChanged(true);
                    } else
                        throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            boolean isLoop = true;
            Message message;

            while (isLoop) {
                message = connection.receive();
                if (message.getType() == MessageType.TEXT)
                    processIncomingMessage(message.getData());
                else if (message.getType() == MessageType.USER_ADDED)
                    informAboutAddingNewUser(message.getData());
                else if (message.getType() == MessageType.USER_REMOVED)
                    informAboutDeletingNewUser(message.getData());
                else {
                    isLoop = false;
                    throw new IOException("Unexpected MessageType");
                }
            }
        }
    }
}

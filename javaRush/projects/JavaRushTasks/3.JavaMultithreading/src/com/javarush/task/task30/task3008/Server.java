package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started...");
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                Handler handler = new Handler(clientSocket);
                handler.start();
            } catch (Exception e) {
                serverSocket.close();
                System.out.println("Exception");
                break;
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String clientName = null;
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message answer = connection.receive();
                clientName = answer.getData();
                if (answer.getType().equals(MessageType.USER_NAME) &&
                        !clientName.isEmpty() &&
                        !connectionMap.containsKey(clientName))
                    break;
            }

            connectionMap.put(clientName, connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));

            return clientName;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            Iterator it = connectionMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                String clientName = (String) pair.getKey();
                if (!clientName.equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED, clientName));
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        Iterator it = connectionMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            String client = (String) pair.getKey();
            Connection connection = (Connection) pair.getValue();

            try {
                connection.send(message);
            } catch (IOException e) {
                System.out.println(client + ": Failed to sent the message.");
            }
        }
    }
}

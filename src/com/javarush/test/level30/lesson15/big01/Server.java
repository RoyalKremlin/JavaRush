package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Sanya on 11.03.2017.
 */
public class Server
{
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message)
    {
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet())
        {
            try
            {
                entry.getValue().send(message);
            }
            catch (IOException e)
            {
                ConsoleHelper.writeMessage("Не вышло отправить сообщение");
            }
        }
    }

    private static class Handler extends Thread
    {
        private Socket socket;

        private Handler(Socket socket)
        {
            this.socket = socket;
        }

        public void run()
        {
            String name = null;

            try
            {
                try (Connection connection = new Connection(socket))
                {
                    ConsoleHelper.writeMessage("Установлено новое соединение с удаленным адресом" + connection.getRemoteSocketAddress());
                    name = serverHandshake(connection);
                    sendBroadcastMessage(new Message(MessageType.USER_ADDED, name));
                    sendListOfUsers(connection, name);
                    serverMainLoop(connection, name);
                }
            }
            catch (IOException | ClassNotFoundException e)
            {
                ConsoleHelper.writeMessage("Произошла ошибка");
            }

            if (name != null)
            {
                connectionMap.remove(name);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name));
            }
            ConsoleHelper.writeMessage("Соединение закрыто");

        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message receive = connection.receive();
                if (receive.getType() != MessageType.USER_NAME)
                    continue;

                String userName = receive.getData();

                if (userName == null || userName.isEmpty() || connectionMap.containsKey(userName))
                    continue;
                connectionMap.put(userName, connection);

                connection.send(new Message(MessageType.NAME_ACCEPTED));
                return userName;
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException
        {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet())
            {
                String name = entry.getKey();
                if (!(name.equals(userName)))
                    connection.send(new Message(MessageType.USER_ADDED, name));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message receive = connection.receive();
                if (receive.getType() == MessageType.TEXT)
                {
                    String data = userName + ": " + receive.getData();
                    Message message = new Message(MessageType.TEXT, data);
                    sendBroadcastMessage(message);
                } else ConsoleHelper.writeMessage("Принятое сообщение не является текстом");
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        ConsoleHelper.writeMessage("Запрашиваю порт сервера...");
        int port = ConsoleHelper.readInt();
        try (ServerSocket socketServer = new ServerSocket(port))
        {
            ConsoleHelper.writeMessage("Сервер запущен");
            while (true)
            {
                Socket socket = socketServer.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage("Ошибка сокета");
        }
    }
}
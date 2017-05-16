package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Sanya on 14.03.2017.
 */
public class Client
{
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread
    {
        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName)
        {
            ConsoleHelper.writeMessage("Участник " + userName + " присоединился к чату.");
        }

        protected void informAboutDeletingNewUser(String userName)
        {
            ConsoleHelper.writeMessage("Участник " + userName + " покинул чат.");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected)
        {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this)
            {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();
                if (message.getType() == MessageType.NAME_REQUEST)
                {
                    String name = getUserName();
                    connection.send(new Message(MessageType.USER_NAME, name));
                } else if (message.getType() == MessageType.NAME_ACCEPTED)
                {
                    notifyConnectionStatusChanged(true);
                    return;
                } else
                {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message receive = connection.receive();
                switch (receive.getType())
                {
                    case TEXT:
                        processIncomingMessage(receive.getData());
                        break;
                    case USER_ADDED:
                        informAboutAddingNewUser(receive.getData());
                        break;
                    case USER_REMOVED:
                        informAboutDeletingNewUser(receive.getData());
                        break;
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }

        public void run()
        {
            String serverAddress = getServerAddress();
            int serverPort = getServerPort();

            try
            {
                Socket socket = new Socket(serverAddress, serverPort);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            }
            catch (IOException | ClassNotFoundException e)
            {
                notifyConnectionStatusChanged(false);
            }
        }
    }

    public static void main(String[] args)
    {
        Client client = new Client();
        client.run();
    }

    public void run()
    {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try
        {
            synchronized (this)
            {
                wait();
            }
        }
        catch (InterruptedException e)
        {
            ConsoleHelper.writeMessage("Во время ожидания возникнло исключение");
            return;
        }

        if (clientConnected)
        {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'");
        } else
        {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }
        String message = null;
        while (clientConnected)
        {
            message = ConsoleHelper.readString();

            if (message.equals("exit"))
                break;

            if (shouldSentTextFromConsole())
            {
                sendTextMessage(message);
            }
        }

    }

    protected String getServerAddress()
    {
        ConsoleHelper.writeMessage("Введите адрес!");
        return ConsoleHelper.readString();
    }

    protected int getServerPort()
    {
        ConsoleHelper.writeMessage("Введите порт сервера");
        return ConsoleHelper.readInt();

    }

    protected String getUserName()
    {
        ConsoleHelper.writeMessage("Введите имя");
        return ConsoleHelper.readString();

    }

    protected boolean shouldSentTextFromConsole()
    {
        return true;
    }

    protected SocketThread getSocketThread()
    {
        return new SocketThread();
    }

    protected void sendTextMessage(String text)
    {
        Message message = new Message(MessageType.TEXT, text);
        try
        {
            connection.send(message);
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage("Ошибка при отправке сообщения!");
            clientConnected = false;
        }

    }
}

package com.javarush.test.level30.lesson15.big01.client;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Sanya on 14.03.2017.
 */
public class BotClient extends Client
{

    public class BotSocketThread extends SocketThread
    {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
            int i = 0;
            if (message.contains(":"))
            {
                i = message.indexOf(":");
            }
            String name = message.substring(0, i);
            String text = message.substring(i + 2);
            SimpleDateFormat sdp;
            switch (text)
            {
                case "дата":
                    sdp = new SimpleDateFormat("d.MM.YYYY");
                    break;
                case "день":
                    sdp = new SimpleDateFormat("d");
                    break;
                case "месяц":
                    sdp = new SimpleDateFormat("MMMM");
                    break;
                case "год":
                    sdp = new SimpleDateFormat("YYYY");
                    break;
                case "время":
                    sdp = new SimpleDateFormat("H:mm:ss");
                    break;
                case "час":
                    sdp = new SimpleDateFormat("H");
                    break;
                case "минуты":
                    sdp = new SimpleDateFormat("m");
                    break;
                case "секунды":
                    sdp = new SimpleDateFormat("s");
                    break;
                default:
                    sdp=null;
                    break;
            }
            Date time = Calendar.getInstance().getTime();
            if(sdp != null)
            {
                String answer = String.format("Информация для %s: %s", name, sdp.format(time));
                sendTextMessage(answer);
            }
        }
    }

    @Override
    protected SocketThread getSocketThread()
    {
        return new BotSocketThread();
    }


    @Override
    protected boolean shouldSentTextFromConsole()
    {
        return false;
    }


    @Override
    protected String getUserName()
    {
        return String.valueOf("bot" + (int) (Math.random() * 100));
    }

    public static void main(String[] args)
    {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}

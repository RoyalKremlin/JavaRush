package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Sanya on 04.02.2017.
 */
public class ConsoleHelper
{
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en", Locale.ENGLISH);

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException
    {
        try
        {
            String ReadedString = bufferedReader.readLine();
            if (ReadedString.equalsIgnoreCase("exit"))
                throw new InterruptOperationException();
            else
                return ReadedString;
        }
        catch (IOException e)
        {
            return "";
        }
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        writeMessage(res.getString("choose.currency.code"));
        while (true)
        {
            String temp = ConsoleHelper.readString().trim();
            if (temp.length() == 3)
            {
                return temp.toUpperCase();
            } else
            {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
        while (true)
        {
            String[] temp = ConsoleHelper.readString().trim().split(" ");
            try
            {
                if (temp.length == 2 && Integer.parseInt(temp[0]) > 0 && Integer.parseInt(temp[1]) > 0)
                {
                    return temp;
                }
            }
            catch (Exception e)
            {
            }
            writeMessage(res.getString("invalid.data"));
        }
    }

    public static Operation askOperation() throws InterruptOperationException
    {
        writeMessage(res.getString("choose.operation"));
        while (true)
        {
            try
            {
                int a = Integer.parseInt(readString());
                if ((a >= 1) && (a <= 4))
                {
                    return Operation.getAllowableOperationByOrdinal(a);
                }
            }
            catch (Exception e)
            {
            }
            writeMessage(res.getString("invalid.data"));
        }
    }

    public static void printExitMessage()
    {
        writeMessage(res.getString("the.end"));
    }
}

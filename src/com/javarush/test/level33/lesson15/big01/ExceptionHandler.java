package com.javarush.test.level33.lesson15.big01;

/**
 * Created on 06.05.2017 at 11:40 :)
 */
public class ExceptionHandler
{
    public static void log(Exception e)
    {
        Helper.printMessage(e.getMessage());
    }
}

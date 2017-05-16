package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Sanya on 03.02.2017.
 */
public class Producer implements Runnable
{
    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map)
    {
        this.map = map;
    }

    @Override
    public void run()
    {
        int i = 0;
        try
        {
            while (true)
            {
                map.put(String.valueOf(i), "Some text for " + ++i);
                Thread.sleep(500);
            }
        }
        catch (Exception e)
        {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
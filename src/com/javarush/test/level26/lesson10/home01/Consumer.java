package com.javarush.test.level26.lesson10.home01;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Sanya on 03.02.2017.
 */
public class Consumer implements Runnable
{
    protected BlockingQueue queue;

    public Consumer(BlockingQueue queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        String data;
        try
        {
            while ((data = queue.take().toString())!= null)
            {
                System.out.println(data);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }
}

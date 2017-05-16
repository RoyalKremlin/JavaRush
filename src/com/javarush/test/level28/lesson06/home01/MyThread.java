package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Sanya on 19.02.2017.
 */
public class MyThread extends Thread
{
   static AtomicInteger priority = new AtomicInteger(1);


    private void myPrioritySet() {
        setPriority(priority.get());
        if (priority.get() == 10) priority.set(0);
        priority.incrementAndGet();
    }


    public MyThread()
    {
        myPrioritySet();
    }

    public MyThread(Runnable target)
    {
        super(target);
        myPrioritySet();
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        myPrioritySet();
    }

    public MyThread(String name)
    {
        super(name);
        myPrioritySet();
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        myPrioritySet();

    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        myPrioritySet();
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        myPrioritySet();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        myPrioritySet();
    }
}

package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Sanya on 14.02.2017.
 */
public class Cook extends Observable implements Observer
{
    public final String name;

    public Cook(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }

    @Override
    public void update(Observable o, Object arg)
    {
        Order order = (Order) arg;
        if (order.isEmpty()) return;
        ConsoleHelper.writeMessage("Start cooking - "+ arg+", cooking time "+order.getTotalCookingTime()+"min");
        setChanged();
        notifyObservers(arg);
    }
}

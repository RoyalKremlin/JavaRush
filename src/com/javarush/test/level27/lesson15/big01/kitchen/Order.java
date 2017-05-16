package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sanya on 14.02.2017.
 */
public class Order
{
    private List<Dish> dishes;
    private Tablet orderedTablet;

    public Order(Tablet orderedTablet) throws IOException
    {
        this.orderedTablet = orderedTablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }
    @Override
    public String toString()
    {
        if (dishes.isEmpty()) return "";
        String chosenDish = String.format("Your order: %s of %s", dishes, orderedTablet);
        return chosenDish;
    }

    public int getTotalCookingTime()
    {
        int time = 0;
        for (Dish dish : dishes)
        {
            time += dish.getDuration();
        }
        return time;
    }

   public boolean isEmpty(){
       return (dishes.isEmpty() || dishes==null);
   }
}

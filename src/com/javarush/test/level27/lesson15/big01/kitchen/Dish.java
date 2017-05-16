package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by Sanya on 14.02.2017.
 */
public enum Dish
{
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private int duration;

    public int getDuration()
    {
        return duration;
    }

    Dish(int duration)
    {
        this.duration=duration;
    }

    public static String allDishesToString(){
        StringBuilder sb = new StringBuilder();
        for (Dish dish : Dish.values()) {
            sb.append(dish);
            sb.append(", ");
        }
        sb.delete(sb.length()-2,sb.length());
        return sb.toString();
    }
}


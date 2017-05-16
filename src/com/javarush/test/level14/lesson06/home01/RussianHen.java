package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Sanya on 30.08.2016.
 */
public class RussianHen extends Hen
{
    @Override
    public int getCountOfEggsPerMonth()
    {
        return 3;
    }
    public String getDescription()
    {
        return super.getDescription()+" Моя страна - "+Country.RUSSIA+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}

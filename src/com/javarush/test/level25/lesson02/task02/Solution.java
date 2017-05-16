package com.javarush.test.level25.lesson02.task02;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* Машину на СТО не повезем!
Инициализируйте поле wheels используя данные из loadWheelNamesFromDB.
Обработайте некорректные данные.
Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
*/
public class Solution
{
    public static enum Wheel
    {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static void main(String[] args)
    {
        Car car = new Car();
    }

    public static class Car
    {
        protected List<Wheel> wheels;

        public Car()
        {
            //init wheels here
            String[] arr = loadWheelNamesFromDB();
            wheels = new LinkedList<>();
            Wheel[] list = Wheel.values();
            try
            {
                for (int i = 0; i < arr.length; i++)
                {
                    String s = list[i].toString();
                    wheels.add(list[i]);
                }
            }catch (Exception e){}
        }

        protected String[] loadWheelNamesFromDB()
        {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }
}


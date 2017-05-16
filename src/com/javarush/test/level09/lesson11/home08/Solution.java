package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел.
Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно.
Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        ArrayList<int[]> list2 = new ArrayList<int[]>();
        int[] int1 = {1, 2, 3, 4, 5};
        int[] int2 = {1, 2};
        int[] int3 = {1, 2, 3, 4};
        int[] int4 = {1, 2, 3, 4, 5, 6, 7};
        int[] int5 = {};
        list2.add(int1);
        list2.add(int2);
        list2.add(int3);
        list2.add(int4);
        list2.add(int5);
        return list2;




        //напишите тут ваш код
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}

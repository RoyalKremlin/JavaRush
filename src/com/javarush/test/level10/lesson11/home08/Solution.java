package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
        ArrayList<String>[] ara = new ArrayList[3];
        ArrayList<String> list1 = new ArrayList<String>();
        for (int i = 0; i<8; i++ )
        {
            list1.add("Lol"+i);
        }
        ArrayList<String> list2 = new ArrayList<String>();
        for (int i = 0; i<2; i++ )
        {
            list2.add("pola"+i);
        }
        ArrayList<String> list3 = new ArrayList<String>();
        for (int i = 0; i<5; i++ )
        {
            list3.add("glolo"+i);
        }
        ara[0] = list1;
        ara[1] = list2;
        ara[2] = list3;
        return ara;

    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}
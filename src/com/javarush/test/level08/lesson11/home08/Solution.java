package com.javarush.test.level08.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Пять наибольших чисел
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Вывести пять наибольших чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int[] array)
    {
        int min=array[0];
        for(int i =0; i<array.length; i++)    // нашли минимум, он нам нужен
        {
            if(array[i]<min)
                min=array[i];
        }
        int[] list = new int[20];
        for(int i =0; i<array.length; i++)
        {
            int t=0;           // обнуляем т
            int max = min;      // минимизируем максимум
            for(int l =0; l<array.length; l++)
            {
                if(max<array[l])
                {                    // нашли первый максимум
                    max = array[l];
                    t = l;
                }// указали его номер
            }
            list[i]=max;               // записали максимум в массив (новый массив)
            array[t]=min;           // сделали значение в исходном массиве минимумом.
        }
        for (int i=0; i<array.length;i++ )
        {
            array[i]=list[i];           // перезаписали в новый массив
        }
        //Напишите тут ваш код
    }
}

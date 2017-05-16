package com.javarush.test.level04.lesson07.task03;

/* Положительные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел в исходном наборе.
Пример для чисел -4 6 6:
2
Пример для чисел -6 -6 -3:
0
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int num=0;
        int a = Integer.parseInt(r.readLine());
        if (a>0) num = num+1;
        int b = Integer.parseInt(r.readLine());
        if (b>0) num = num+1;
        int c = Integer.parseInt(r.readLine());
        if (c>0) num = num+1;
        System.out.println(num);




    }
}

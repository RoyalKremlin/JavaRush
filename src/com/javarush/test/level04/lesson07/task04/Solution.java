package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int neg=0,pos=0;
        int a = Integer.parseInt(r.readLine());

        if (a<0)
            neg=neg+1;
        else if (a>0)
            pos=pos+1;

        int b = Integer.parseInt(r.readLine());

        if (b<0)
            neg=neg+1;
        else if (b>0)
            pos=pos+1;

        int c = Integer.parseInt(r.readLine());
        if (c<0)
            neg=neg+1;
        else if (c>0)
            pos=pos+1;

        System.out.println("количество отрицательных чисел: "+neg);
        System.out.println("количество положительных чисел: "+pos);


    }
}

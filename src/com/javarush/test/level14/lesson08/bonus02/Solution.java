package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        ArrayList listA = new ArrayList();
        ArrayList listB = new ArrayList();
        for (int i = 1; i <= a; i++)
        {
            if (a % i == 0)
                listA.add(i);
        }
        for (int i = 1; i <= b; i++)
        {
            if (b % i == 0)
                listB.add(i);
        }
        for (int i = listA.size() - 1; i >= 0; i--)
        {
            if (listB.contains(listA.get(i)))
            {
                System.out.println(listA.get(i));
                break;
            }
        }
    }
}


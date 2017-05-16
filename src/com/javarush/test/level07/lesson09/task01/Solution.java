package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> listBig = new ArrayList<Integer>();

        for (int i =0; i<20;i++)
        { listBig.add(Integer.parseInt(r.readLine()));}

        ArrayList<Integer> listK3 = new ArrayList<Integer>();
        ArrayList<Integer> listK2 = new ArrayList<Integer>();
        ArrayList<Integer> listK1 = new ArrayList<Integer>();

        for (int i=0; i<20;i++)
        {
            Integer x = listBig.get(i);

            if (x % 2 == 0)
            {
                listK2.add(x);

            }

            if (x % 3 == 0)
            {
                listK3.add(x);
            }

            if (x%2!=0 && x%3!=0)
                listK1.add(x);
        }

            printList(listK3);
            printList(listK2);
            printList(listK1);





        //напишите тут ваш код
    }

    public static void printList(List<Integer> list)
    {
        for (int i =0; i < list.size();i++){
            System.out.println(list.get(i));
        }
    }
}

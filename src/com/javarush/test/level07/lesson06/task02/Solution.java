package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++)
        {
            String s = r.readLine();
            list.add(s);
        }

        int max = list.get(0).length();
        ArrayList<String> theShortest = new ArrayList<String>();
        theShortest.add(list.get(0));

        for (int i =1; i<list.size();i++){
            if (max<list.get(i).length()) {
                theShortest = new ArrayList<String>();
                theShortest.add(list.get(i));
                max = list.get(i).length();
            }
            else if (max == list.get(i).length())
                theShortest.add(list.get(i));
        }

        for (int i=0; i<theShortest.size();i++)
        System.out.println(theShortest.get(i));
    }
}
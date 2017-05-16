package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        boolean Exit = false;
        int a = 0;
        while (true)
        {
            String s = r.readLine();
            if (s.equals("сумма")){
                System.out.println(a);
                break;}
            int b = Integer.parseInt(s);
            a=a+b;

        }

    }
}


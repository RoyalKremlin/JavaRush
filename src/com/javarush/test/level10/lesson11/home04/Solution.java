package com.javarush.test.level10.lesson11.home04;

/* Большая зарплата
Вывести на экран надпись «Я не хочу изучать Java, я хочу большую зарплату» 40 раз по образцу.
Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
…
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        ArrayList<Character> chars = new ArrayList<Character>();

        for (int k=0;k<s.length();k++){
            chars.add(s.charAt(k));
        }

        for (int i=0;i<40;i++)
        {
            for (int i2=0;i2<chars.size();i2++)
            {
                System.out.print(chars.get(i2));

            }
            chars.remove(0);
            System.out.println();
        }
        //напишите тут ваш код
    }

}

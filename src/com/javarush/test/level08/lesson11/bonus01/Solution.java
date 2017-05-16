package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "January");
        map.put("2","February");
        map.put("3","March");
        map.put("4","April");
        map.put("5","May");
        map.put("6","June");
        map.put("7","July");
        map.put("8","August");
        map.put("9","September");
        map.put("10","October");
        map.put("11","November");
        map.put("12","December");

        String date = r.readLine();

        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String key = pair.getKey();                      //ключ
            String value = pair.getValue();
            if (date.equals(value))
                System.out.println(value + " " + "is" + " "+ key + " " + "month" );
            //значение

        }



        //напишите тут ваш код
    }

}

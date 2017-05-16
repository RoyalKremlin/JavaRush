package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {

       HashMap<String, String> map = new HashMap<String, String>();
        map.put("Иванов","Карман");
        map.put("Ивано","Сулейман");
        map.put("Петро","Петр");
        map.put("Иваног","Иван");
        map.put("Манданов","Бран");
        map.put("Гандонов","Кван");
        map.put("Пирогов","Карман");
        map.put("Мозгов","Саян");
        map.put("Безмозгов","Кран");
        map.put("Классный","Иван");
        return map;
        //напишите тут ваш код

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int firstname=0;

        Iterator<Map.Entry<String, String>>iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            if (name.equals(iterator.next().getValue()))
                firstname++;
        }
        return firstname;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int lastname = 0;

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            if (lastName.equals(iterator.next().getKey()))
                lastname++;
        }
        return lastname;

    }


        public static void main(String[] args) {
        HashMap<String, String> map2 = createMap();
        System.out.println(getCountTheSameFirstName(map2, "Карман"));
        System.out.println(getCountTheSameLastName(map2, "Иванов"));
    }
        //напишите тут ваш код



}


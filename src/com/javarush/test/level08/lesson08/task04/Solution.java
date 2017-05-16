package com.javarush.test.level08.lesson08.task04;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Alexandro", new Date("APRIL 16 1991"));
        map.put("NIKOLA", new Date("APRIL 6 1991"));
        map.put("MATHER", new Date("AUGUST 3 1965"));
        map.put("koko", new Date("APRIL 6 1991"));
        map.put("Iren", new Date("APRIL 6 1991"));
        map.put("Igor", new Date("APRIL 6 1991"));
        map.put("Ram", new Date("APRIL 6 1991"));
        map.put("Xam", new Date("APRIL 6 1991"));
        map.put("Spam", new Date("APRIL 6 1991"));


        return map;
        //напишите тут ваш код

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        ArrayList<String> keys = new ArrayList<String>();
        for (Map.Entry<String, Date> pair : map.entrySet()){
            if (pair.getValue().getMonth() >=5 && pair.getValue().getMonth() <= 7) {
                keys.add(pair.getKey());
            }
        }
        for (int i = 0; i < keys.size(); i++) {
            map.remove(keys.get(i));
        }
        System.out.println(map);
    }

    public static void main(String[] args) {
        System.out.println(createMap());
        removeAllSummerPeople(createMap());
    }


        //напишите тут ваш код

    }


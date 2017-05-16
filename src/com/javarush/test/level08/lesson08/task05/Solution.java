package com.javarush.test.level08.lesson08.task05;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код

        HashMap<String,String> map = new HashMap<String, String>();

        map.put("Иванов", "Иван");
        map.put("Петров", "Николай");
        map.put("Сидоров", "Кроман");
        map.put("Смирнов", "Наркоман");
        map.put("Тимофеев", "Бран");
        map.put("Брододеев", "Иван");
        map.put("Хуемеев", "Карман");
        map.put("Пиздабреев", "Сумабран");
        map.put("Членсосеев", "Краван");
        map.put("Писькатреев", "Грихан");

        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (String value : copy.values())
            if (Collections.frequency(copy.values(), value) > 1)
                removeItemFromMapByValue(map, value);
        //напишите тут ваш код

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}

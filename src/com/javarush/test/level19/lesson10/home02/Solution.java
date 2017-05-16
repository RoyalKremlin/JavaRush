package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Map<String, Double> theRichest = new HashMap<>();
        String fileName = args[0];
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String buffer;
        while ((buffer = bufferedReader.readLine()) != null)
        {
            String[] s = buffer.split(" ");
            if (theRichest.containsKey(s[0]))
            {
                double x = theRichest.get(s[0]);
                double v = Double.parseDouble(s[1]) + x;
                theRichest.put(s[0], v);
            }
            else
            {
                double v = Double.parseDouble(s[1]);
                theRichest.put(s[0], v);
            }
        }
        fileReader.close();
        bufferedReader.close();
        ArrayList<Double> zp = new ArrayList<>(theRichest.values());
        double maxzp = Collections.max(zp);
        for (Map.Entry<String,Double> entry : theRichest.entrySet())
        {
            String key = entry.getKey();
            Double value = entry.getValue();
            if (value.equals(maxzp))
            {
                System.out.println(key);
            }
        }
    }
}

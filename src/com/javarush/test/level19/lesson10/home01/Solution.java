package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Map<String,Double> zp = new TreeMap<>();
        String fileName = args[0];
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String buffer;
        while ((buffer=bufferedReader.readLine())!=null)
        {
            String[] s = buffer.split(" ");
            if (zp.containsKey(s[0])){
                    double x = zp.get(s[0]);
                    double v = Double.parseDouble(s[1])+x;
                    zp.put(s[0],v);
                }
            else
                {
                    double v = Double.parseDouble(s[1]);
                    zp.put(s[0], v);
                }
        }
        fileReader.close();
        bufferedReader.close();
        for (Map.Entry<String,Double> entry : zp.entrySet()){
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key+" "+value);
        }
    }
}

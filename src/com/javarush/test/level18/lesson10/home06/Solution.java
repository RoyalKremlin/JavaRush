package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];
        FileInputStream fileInputStream = new FileInputStream(fileName);

        Map<Integer, Integer> vs = new TreeMap<>();

        while (fileInputStream.available()>0){
            int currentASCII = fileInputStream.read();
            if (vs.containsKey(currentASCII)){
                vs.put(currentASCII, vs.get(currentASCII)+1);
            }
            else{
                vs.put(currentASCII, 1);
            }
        }

        for (Map.Entry<Integer, Integer> pair : vs.entrySet()){
            int key = pair.getKey();
            int value = pair.getValue();
            System.out.println((char)key+" "+value);
        }

        fileInputStream.close();


    }
}

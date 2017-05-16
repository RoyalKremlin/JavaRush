package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        BufferedReader bufferedReader1 = new BufferedReader(fileReader);
        String buffer;
        while ((buffer=bufferedReader1.readLine())!=null){
            StringBuilder stringBuilder = new StringBuilder(buffer);
            stringBuilder.reverse();
            String reverseString = stringBuilder.toString();
            System.out.println(reverseString);
        }
        bufferedReader.close();
        bufferedReader1.close();
        fileReader.close();
    }
}

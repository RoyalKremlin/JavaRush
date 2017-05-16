package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileReaderName = bufferedReader.readLine();
        bufferedReader.close();
        FileReader fileReader = new FileReader(fileReaderName);
        BufferedReader bufferedReader1 = new BufferedReader(fileReader);
        String buffer;
        int count=0;
        while ((buffer=bufferedReader1.readLine())!=null){
            String[] s = buffer.split("\\W");
            for (String element : s){
                if(element.equals("world")) count++;
            }
        }
        System.out.println(count);
        fileReader.close();
        bufferedReader1.close();

    }
}

package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileReaderName = bufferedReader.readLine();
        String fileWriterName = bufferedReader.readLine();
        bufferedReader.close();
        FileReader fileReader = new FileReader(fileReaderName);
        FileWriter fileWriter = new FileWriter(fileWriterName);
        String line = "";
        while (fileReader.ready()){
            int data = fileReader.read();
            char symbol = (char) data;
            line += symbol;
        }
        String[] words = line.split("[\\s\\n]");
        for (String word : words){
            if (word.matches("\\d+")) fileWriter.write(word+" ");
        }
        fileReader.close();
        fileWriter.close();
        }
    }


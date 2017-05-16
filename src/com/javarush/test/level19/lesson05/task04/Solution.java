package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
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

        while(fileReader.ready()){
            int data = fileReader.read();
            char symbol = (char) data;
            if (symbol=='.'){
                symbol='!';
            }
            fileWriter.write(symbol);
        }
        fileReader.close();
        fileWriter.close();

    }
}

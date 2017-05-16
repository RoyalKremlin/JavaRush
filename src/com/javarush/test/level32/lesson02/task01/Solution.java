package com.javarush.test.level32.lesson02.task01;

import java.io.IOException;
import java.io.RandomAccessFile;

/* Запись в файл
В метод main приходят три параметра:
1) fileName - путь к файлу
2) number - число, позиция в файле
3) text - текст
Записать text в файл fileName начиная с позиции number.
Если файл слишком короткий, то записать в конец файла.
*/
public class Solution
{
    public static void main(String... args)
    {
        String fileName = args[0].trim();
        String text = args[2];
        int number = Integer.valueOf(args[1]);
        if (number < 0) return;
        RandomAccessFile raf;
        try
        {
            raf = new RandomAccessFile(fileName, "rw");
            if (text.length() < number)
            {
                raf.seek(raf.length());
            } else
            {
                raf.seek(number);
            }
            raf.writeBytes(text);
            raf.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

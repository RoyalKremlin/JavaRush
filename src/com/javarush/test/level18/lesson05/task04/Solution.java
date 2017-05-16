package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1name = br.readLine();
        String file2name = br.readLine();
        br.close();
        FileInputStream file1 = new FileInputStream(file1name);
        FileOutputStream file2 = new FileOutputStream(file2name);
        byte [] buffer = new byte[file1.available()];
        byte [] reffub = new byte[file1.available()];
        int buf_size = file1.read(buffer);
        for(int i = buf_size - 1; i >= 0; i--)
        {
            reffub[buf_size - 1 - i] = buffer[i];
        }
        file2.write(reffub);
        file1.close();
        file2.close();


    }
}

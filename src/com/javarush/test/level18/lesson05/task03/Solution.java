package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1name = br.readLine();
        String file2name = br.readLine();
        String file3name = br.readLine();
        br.close();
        FileInputStream file1 = new FileInputStream(file1name);
        FileOutputStream file2 = new FileOutputStream(file2name);
        FileOutputStream file3 = new FileOutputStream(file3name);

        int date1 = file1.available()/2+ file1.available()%2;
        int date2 = file1.available()-date1;

        byte[] Date1 = new byte[date1];
        byte[] Date2 = new byte[date2];

        file2.write(Date1, 0, file1.read(Date1));
        file3.write(Date2, 0, file1.read(Date2));

        file1.close();
        file2.close();
        file3.close();
    }
}

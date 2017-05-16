package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String firstName = bufferedReader.readLine();
        String secondName = bufferedReader.readLine();
        bufferedReader.close();
        FileInputStream first = new FileInputStream(firstName);
        FileInputStream second = new FileInputStream(secondName);

        byte[] s1 = new byte[first.available()];
        first.read(s1);

        byte[] s2= new byte[second.available()];
        second.read(s2);

        FileOutputStream third = new FileOutputStream(firstName,false);
        third.write(s2);

        FileOutputStream fourth = new FileOutputStream(firstName,true);
        fourth.write(s1);
        first.close();
        second.close();
        third.close();
        fourth.close();



    }
}

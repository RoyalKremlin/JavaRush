package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        String filename = args[0];
        FileInputStream fileInputStream = new FileInputStream(filename);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        int letteramount = 0;
        int bytesimbol;
        while ((bytesimbol= fileInputStream.read())!=-1){
        if (alphabet.contains((char)bytesimbol+" ")) letteramount++;
        }
        fileInputStream.close();
        System.out.println(letteramount);

    }
}

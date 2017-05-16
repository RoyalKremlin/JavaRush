package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Character.toUpperCase;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] arr = s.toCharArray();
        arr[0] = toUpperCase(arr[0]);

        for (int i=0; i<arr.length-1; i++){
            if ((arr[i] == ' ') && arr[i + 1] != ' ' ) {
                arr[i + 1] = toUpperCase(arr[i + 1]);
            }
        }

        String news = new String(arr);
        System.out.println(news);
        //напишите тут ваш код
    }


}

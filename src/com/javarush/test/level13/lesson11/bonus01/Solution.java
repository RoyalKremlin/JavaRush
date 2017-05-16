package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        ArrayList<Integer> arrayList = new ArrayList<>();
        String buffer;
        while ((buffer=bufferedReader.readLine())!=null){
            int a = Integer.parseInt(buffer);
            if (a%2==0) arrayList.add(a);
        }
        Collections.sort(arrayList);
        for (Integer x : arrayList){
            System.out.println(x);
        }
    }
}

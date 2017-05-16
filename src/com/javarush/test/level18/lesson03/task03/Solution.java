package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filename = br.readLine();
        br.close();
        FileInputStream file = new FileInputStream(filename);

        int[] bytesArray = new int[256];
        while (file.available()>0)
        {
            int currentByte = file.read();
            bytesArray[currentByte]++;
        }
        int max=0;
        for(int x=0;x<bytesArray.length;x++){
            if(bytesArray[x]>max){max=bytesArray[x];
            }
        }
        for(int x=0;x<bytesArray.length;x++){
            if(bytesArray[x]==max) System.out.print(x + " ");
        }
        file.close();
        System.out.println();
    }
}

package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String file1Name = args[0];
        String file2Name = args[1];
        FileReader fileReader = new FileReader(file1Name);
        FileWriter fileWriter = new FileWriter(file2Name);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String buffer;
        String s="";
        while ((buffer=bufferedReader.readLine())!=null){
            String[] words = buffer.split(" ");
            for (int i = 0; i<words.length; i++){
                if (words[i].length()>6){
                    s+=words[i]+",";
                }
            }
        }
        String t=s.substring(0,(s.length()-1));
        fileWriter.write(t);
        fileReader.close();
        fileWriter.close();
        bufferedReader.close();
    }
}

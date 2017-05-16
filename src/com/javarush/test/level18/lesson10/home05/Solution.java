package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String doublefileName = bufferedReader.readLine();
        String integerfileName = bufferedReader.readLine();

        FileReader fileReader = new FileReader(doublefileName);
        BufferedReader bufferedReader1 = new BufferedReader(fileReader);

        FileWriter fileWriter = new FileWriter(integerfileName);

        String line;
        String s="";
        while ((line=bufferedReader1.readLine())!=null){
            s+=line+" ";
        }

        String[] strings = s.split(" ");
        String x = "";
        for (int i =0; i < strings.length;i++ ){
            x += Math.round(Double.parseDouble(strings[i])) + " ";
        }
        fileWriter.write(x.trim());

        bufferedReader.close();
        bufferedReader1.close();
        fileReader.close();
        fileWriter.close();

    }
}

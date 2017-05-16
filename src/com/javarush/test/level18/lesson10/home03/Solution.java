package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file1Name = bufferedReader.readLine();
        String file2Name = bufferedReader.readLine();
        String file3Name = bufferedReader.readLine();
        bufferedReader.close();

        FileInputStream file2 = new FileInputStream(file2Name);
        FileOutputStream file1 = new FileOutputStream(file1Name);
        FileInputStream file3 = new FileInputStream(file3Name);

        while (file2.available()>0){
            file1.write(file2.read());
        }
        while (file3.available()>0){
            file1.write(file3.read());
        }
        file1.close();
        file2.close();
        file3.close();
    }
}

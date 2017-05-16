package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со словами, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
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
        String out="";
        while ((buffer=bufferedReader.readLine())!=null){
            String [] words = buffer.split(" ");
            for (int i =0; i<words.length;i++){
                if (words[i].matches(".*\\d.*")){
                    out=out+" "+words[i];
                }
            }
        }
        out=out.replaceFirst("^\\s","");
        fileWriter.write(out);
        fileReader.close();
        fileWriter.close();
        bufferedReader.close();
    }
}

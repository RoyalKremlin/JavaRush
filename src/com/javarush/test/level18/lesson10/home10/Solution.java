package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/
import java.io.*;
import java.util.Comparator;
import java.util.TreeSet;
public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //Создаю отсортированный сет имен файлов
        TreeSet<String> fileNamesSet = new TreeSet<String>(new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                int k = Integer.parseInt(o1.substring(o1.indexOf(".part")+5));
                int m = Integer.parseInt(o2.substring(o2.indexOf(".part")+5));
                if (k > m)return 1;
                else if (k < m) return -1;
                else return 0;
            }
        });
        //Читаю с консоли имена файлов
        while (true){
            String fileName = bufferedReader.readLine();
            if (!fileName.equals("end"))
                fileNamesSet.add(fileName);
            else break;
        }
        bufferedReader.close();
        //Создаю имя для нового файла на базе существующих, без .part
        String origNameFile = "";
        for(String s:fileNamesSet) {
            origNameFile = s;
        }
        String newFile = origNameFile.substring(0, origNameFile.indexOf(".part"));
        //Запись текста в новый файл
        FileOutputStream fileOutputStream = new FileOutputStream(new File(newFile));
        for(String fileName:fileNamesSet){
            FileInputStream fileInputStream = new FileInputStream(fileName);
            byte[] bytes = new byte[fileInputStream.available()];
            while (fileInputStream.available()>0){
                fileInputStream.read(bytes);
                fileOutputStream.write(bytes);
            }
            fileInputStream.close();
        }
        fileOutputStream.close();
    }
}
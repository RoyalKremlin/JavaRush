package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        String fileName =args[0];
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String buffer;
        while ((buffer=bufferedReader.readLine())!=null){
            String[] lines = buffer.split(" ");
            String name=lines[0];
            int day=0;
            int month=0;
            int year=0;
            for (int i=1;i<lines.length;i++){
                if(lines[i].matches("\\d+")){
                    day=Integer.parseInt(lines[i]);
                    month=Integer.parseInt(lines[i+1]);
                    year=Integer.parseInt(lines[i+2]);
                    break;
                }
                else name = name+" "+lines[i];
            }
            GregorianCalendar calendar = new GregorianCalendar(year, month-1, day);
            Date birthday = calendar.getTime();
            PEOPLE.add(new Person(name,birthday));
        }
        fileReader.close();
        bufferedReader.close();
    }
}

package com.javarush.test.level03.lesson12.home01;

/* Жить хорошо, а хорошо жить еще лучше
Вывести на экран надпись «Жить хорошо, а хорошо жить еще лучше»
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution
{

    public static void main(String[] args)
    {


        System.out.println("Жить хорошо, а хорошо жить еще лучше");


        PrintStream consoleStream = System.out;

    //Создаем динамический массив
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    //создаем адаптер к классу PrintStream
    PrintStream stream = new PrintStream(outputStream);
    //Устанавливаем его как текущий System.out
    System.setOut(stream);

    //Вызываем функцию, которая ничего не знает о наших манипуляциях
    printSomething();

    //Преобразовываем записанные в наш ByteArray данные в строку
    String result = outputStream.toString();

    //Возвращаем все как было
    System.setOut(consoleStream);

    //разворачиваем строку
    StringBuilder stringBuilder = new StringBuilder(result);
    stringBuilder.reverse();
    String reverseString = stringBuilder.toString();

    //выводим ее в консоль
    System.out.println(reverseString);
}


    public static void printSomething()
    {
        System.out.println("Hi");
        System.out.println("My name is Amigo");
        System.out.println("Bye-bye!");
    }
}


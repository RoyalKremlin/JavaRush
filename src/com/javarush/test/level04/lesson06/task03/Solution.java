package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(r.readLine());
        int b =Integer.parseInt(r.readLine());
        int c = Integer.parseInt(r.readLine());
        int max=0,mid=0,min=0;
        if (a>=b && a>=c)
            max=a;
        else if (b>=a && b>=c)
                max=b;
        else if (c>=a && c>=b)
                max=c;

        if ((a>=b && a<=c) || (a>=c && a<=b))
            mid=a;
        else if ((b>=a && b<=c) || (b>=c && b<=a))
            mid=b;
        else if ((c>=a && c<=b) || (c>=b && c<=a))
        mid=c;

        if (a<=b && a<=c)
            min=a;
        else if (b<=a && b<=c)
            min=b;
        else if (c<=a && c<=b)
            min=c;

        System.out.println(max+" "+mid+" "+min);



    }
}

/*
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String aS = reader.readLine();
        String bS = reader.readLine();
        String cS = reader.readLine();
        int a = Integer.parseInt(aS);
        int b = Integer.parseInt(bS);
        int c = Integer.parseInt(cS);
        System.out.println(min(a,b,c));
        System.out.println(mid(a,b,c));
        System.out.println(max(a,b,c));
    }
    //выискиваем минимальное значение
    public static int min(int a,int b, int c)
    {
        if ((a < b) && (a < c))
           return a;
        else
            if ((b > a ) && (b < c))
                return b;
            else
                return c;
    }
    //выискиваем среднее значение
    public static int mid(int a, int b, int c)
    {
        if (((a < b) && (a > c)) || ((a > b) && (a < c)))
            return a;
        else
            if (((b < a) && (b > c)) || ((b > a) && (b < c)))
                return b;
            else
                return c;
    }
    //выискиваем максимальное значение
    public static int max(int a, int b, int c)
    {
        if ((a > b) && (a > c))
            return a;
        else
        if ((b > a ) && (b > c))
            return b;
        else
            return c;
    }
}




 */
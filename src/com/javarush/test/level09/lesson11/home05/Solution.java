package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String line = r.readLine();

        ArrayList<Character> notvowels = new ArrayList<Character>();
        ArrayList<Character> vowels = new ArrayList<Character>();

        for (int i =0; i<line.length();i++){

            char currentChar = line.charAt(i);
            boolean vowelChar = isVowel(currentChar);
            if (vowelChar) {
                vowels.add(currentChar);
            } else {
                if (currentChar != ' ') {
                    notvowels.add(currentChar);
                }
            }
        }
        for (int i = 0; i < vowels.size(); i++) {
            if (i < vowels.size() - 1) {
                System.out.print(vowels.get(i) + " ");
            } else {
                System.out.print(vowels.get(i));
            }
        }
        System.out.println();
        for (int i = 0; i < notvowels.size(); i++) {
            if (i < notvowels.size() - 1) {
                System.out.print(notvowels.get(i) + " ");
            } else {
                System.out.print(notvowels.get(i));
            }
        }
    }





        //напишите тут ваш код



    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}

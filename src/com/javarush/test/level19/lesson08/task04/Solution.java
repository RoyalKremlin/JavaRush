package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);
        char[] ch = result.toCharArray();
        String intA = "";
        String intB = "";
        String operator = "";
        for (int i=0;i<ch.length;i++){
            if (ch[i]==' ')
            {
                operator=String.valueOf(ch[i+1]);
                for (int k=i+3;k<ch.length;k++){
                    if (ch[k]==' ') break;
                    intB += ch[k];
                }
                break;
            }
            intA += ch[i];
        }
        int a = Integer.parseInt(intA);
        int b = Integer.parseInt(intB);
        int c = 0;
        if (operator.equals("+")){
            c=a+b;
        }
        if (operator.equals("-")){
            c=a-b;
        }
        if (operator.equals("*")){
            c=a*b;
        }
        System.out.println(a+" "+operator+" "+b+" = "+c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}


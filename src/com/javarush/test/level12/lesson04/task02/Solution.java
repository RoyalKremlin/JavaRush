package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Solution s = new Solution();
     s.print(3);
        s.print(new Integer(4));
    }

    void print(int i){
        System.out.println(i);
    }

    void print(Integer l){
        System.out.println(l);
    }

    //Напишите тут ваши методы
}

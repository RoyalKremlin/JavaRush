package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {

    public static int[] getNumbers(int N) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=1; i<=N;i++){
            String s = Integer.toString(i);
            int M = s.length();
            int Sv=0;
            for (int k = 0;k<M;k++){
                int l = Integer.parseInt(s.substring(k,k+1));
                int v = (int) Math.pow(l,M);
                Sv +=v;
            }
            if (i==Sv) {
                list.add(i);
            }
        }
        int[] result = new int [list.size()];
        for (int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;
    }
}

package com.javarush.test.level12.lesson12.bonus03;

/* Задача по алгоритмам
Написать метод, который возвращает минимальное число в массиве и его позицию (индекс).
*/

import java.util.Arrays;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndIndex(data);

        System.out.println("Minimum is " + result.x);
        System.out.println("Index of minimum element is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndIndex(int[] array)
    {
        if (array == null || array.length == 0)
        {
            return new Pair<Integer, Integer>(null, null);
        }

        int[] array1=new int[array.length];
        array1= Arrays.copyOf(array, array.length);
        for (int i=0;i<array1.length-1;i++){
            for (int s=0;s<array1.length-1-i;s++){
                if (array1[s]>array1[s+1])
                {
                    int replace=array1[s+1];
                    array1[s+1]=array1[s];
                    array1[s]=replace;
                }
            }
        }
        //Ищем индекс, сравнивая минимальное число с числами исходной версии массива
        int sss = 0;
        for (int n=0;n<array.length;n++){
            if (array1[0]==array[n]) sss=n;
        }
        return new Pair<Integer, Integer>(array1[0], sss);
    }


    public static class Pair<X, Y>
    {
        public X x;
        public Y y;

        public Pair(X x, Y y)
        {
            this.x = x;
            this.y = y;
        }
    }
}

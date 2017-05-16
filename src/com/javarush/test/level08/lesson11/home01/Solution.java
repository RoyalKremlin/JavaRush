package com.javarush.test.level08.lesson11.home01;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый кот с новой строки.
*/

public class Solution
{

    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Iterator<Cat> i = cats.iterator();
        i.next();
        i.remove();
        printCats(cats);

        //напишите тут ваш код. пункт 3

    }

    public static Set<Cat> createCats()
    {
        Set<Cat> cats2 = new HashSet<Cat>();
        cats2.add(new Cat());
        cats2.add(new Cat());
        cats2.add(new Cat());

        //напишите тут ваш код. пункт 2
        return cats2;
    }

    public static void printCats(Set<Cat> cats)
    {
        for (Object cats2 : cats)
        {
            System.out.println(cats2);
        }
        // пункт 4
    }

    public static class Cat {

    }
    // пункт 1
}

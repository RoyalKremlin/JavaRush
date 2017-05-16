package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {

        ArrayList<Human> list = new ArrayList<Human>();

        Human child1 = new Human("child1", true, 22,list);
        Human child2 = new Human("child2", true, 20,list);
        Human child3 = new Human("child3", false, 19,list);

        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);


        list.add(child1);
        list.add(child2);
        list.add(child3);

        Human father = new Human("father", true, 55, list);
        Human mother = new Human("mother", false, 44, list);

        System.out.println(father);
        System.out.println(mother);



        list.clear();
        list.add(mother);

        Human grandpa1 = new Human("grandpa1", true, 83, list);
        Human grandma1 = new Human("grandma1", false, 77, list);

        System.out.println(grandpa1);
        System.out.println(grandma1);

        list.clear();
        list.add(father);

        Human grandpa2 = new Human("grandpa2", true, 75, list);
        Human grandma2 = new Human("grandma2", false, 72, list);

        System.out.println(grandpa2);
        System.out.println(grandma2);




        //напишите тут ваш код
    }

    public static class Human
    {


        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();
        //напишите тут ваш код

        public Human(String name, Boolean sex, int age, ArrayList<Human> children ) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children  = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}

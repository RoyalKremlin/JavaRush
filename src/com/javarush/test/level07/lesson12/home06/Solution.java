package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
 Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей.
 Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Human grandpa1 = new Human("grandpa1", true, 80, null, null);


        Human grandpa2 = new Human("grandpa2", true, 70, null, null);


        Human grandma1 = new Human("grandma1", false, 66, null, null);


        Human grandma2 = new Human("grandma2", false, 68, null, null);


        Human father = new Human("father", true, 45, grandpa1,grandma1);


        Human mother = new Human("mother", false, 41, grandpa2,grandma2);


        Human child1 = new Human("child1", true, 14, father, mother);


        Human child2 = new Human("child2", true, 11, father, mother);


        Human child3 = new Human("child3", false, 8, father, mother);

        System.out.println(grandpa1);
        System.out.println(grandpa2);
        System.out.println(grandma1);
        System.out.println(grandma2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);

        //напишите тут ваш код
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father=father;
            this.mother=mother;

        }

        //напишите тут ваш код

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}

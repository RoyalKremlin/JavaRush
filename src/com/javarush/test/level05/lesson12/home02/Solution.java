package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        Man man1 = new Man("Sanya","Moscow",25);
        Man man2 = new Man("Petya","Urupinsk",22);

       // System.out.println(man1.name+man1.address+man1.age);
      //  System.out.println(man2.name+man2.address+man2.age);

        Woman woman1 = new Woman("Irina","Blagodat",23);
        Woman woman2 = new Woman("Nastya","Shluholand",24);

     //   System.out.println(woman1.name+woman1.address+woman1.age);
     //   System.out.println(woman2.name+woman2.address+woman2.age);


    }

    public static class Man{
        String name,address;
        int age;

        Man(String name,String address,int age){
            this.name=name;
            this.address=address;
            this.age=age;
            System.out.println(name+" "+address+" "+age);
        }
    }

    public static class Woman{
        String name,address;
        int age;

        Woman(String name, String address, int age){
            this.name=name;
            this.address=address;
            this.age=age;
            System.out.println(name+" "+address+" "+age);
        }
    }
}

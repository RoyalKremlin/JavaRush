package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);
        Mouse mickeyMouse = new Mouse("Mickey",10,10);

        Dog angryDog = new Dog("Angry",100,13);

        Cat tomCat = new Cat("Tom",12,23);
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    public static class Dog
    {
        String name;
        int strength;
        int hate;

        public Dog(String name, int strength,int hate)
        {
            this.name=name;
            this.strength=strength;
            this.hate=hate;
        }

    }

    public static class Cat
    {
        String name;
        int speed;
        int clever;

        public Cat(String name, int speed, int clever)
        {
            this.name=name;
            this.speed=speed;
            this.clever=clever;
        }
    }

}
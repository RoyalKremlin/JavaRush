package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
      public  String FirstName,LastName,FathersName;
      public  int height,weight;
        public int age;

        public Human(String FirstName, String LastName)
        {
            this.FirstName=FirstName;
            this.LastName=LastName;
        }

        public Human(String FirstName, String LastName, String FathersName)
        {
            this.FirstName = FirstName;
            this.LastName = LastName;
            this.FathersName = FathersName;
        }

        public Human(String FirstName, String LastName, String FathersName, int age)
        {
            this.FirstName = FirstName;
            this.LastName = LastName;
            this.FathersName = FathersName;
            this.age=age;
        }

        public Human(String FirstName, String LastName, String FathersName,int age,int weight,int height)
        {
            this.FirstName = FirstName;
            this.LastName = LastName;
            this.FathersName = FathersName;
            this.age=age;
            this.weight=weight;
            this.height=height;
        }

        public Human(String FirstName, String LastName, String FathersName,int age,int height)
        {
            this.FirstName = FirstName;
            this.LastName = LastName;
            this.FathersName = FathersName;
            this.age=age;
            this.height=height;
        }
        public Human(String FirstName)
        {
            this.FirstName = FirstName;
        }
        public Human(String FirstName,int age,int height)
        {
            this.FirstName = FirstName;
            this.age=age;
            this.height=height;
        }

        public Human(int age,int weight,int height)
        {

            this.age=age;
            this.weight=weight;
            this.height=height;

        }
        public Human(String FirstName, String LastName,int weight,int height)
        {
            this.FirstName = FirstName;
            this.LastName = LastName;
            this.weight=weight;
            this.height=height;

        }

        public Human(String LastName,int age){
            this.LastName=LastName;
            this.age=age;
        }


        //напишите тут ваши переменные и конструкторы
    }
}

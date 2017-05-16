package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws CloneNotSupportedException
    {
        A a = new A(1,2);
        A a1 = (A) a.clone();
        B b = new B(3,4,"0");

        C c = new C(5,6,"00");
        C c1 = (C) c.clone();
        System.out.println(a.getI());
        System.out.println(a1.getI());
        System.out.println(b.getI());

        System.out.println(c.getI());
        System.out.println(c1.getI());
    }


    public static class A implements Cloneable {
        private int i;
        private int j;

        public Object clone() throws CloneNotSupportedException
        {
        return super.clone();
        }

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public B clone() throws  CloneNotSupportedException{
            throw new CloneNotSupportedException();
        }

    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }
        public C clone() throws  CloneNotSupportedException
        {
            return new C(getI(),getJ(),getName());
        }
    }
}

package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Sanya on 12.01.2017.
 */
public class Hippodrome
{

    public static Hippodrome game;
    ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();
        Horse splu = new Horse("Splu", 3, 0);
        Horse neznau = new Horse("Neznau", 3, 0);
        Horse sampridumai = new Horse("Sampridumai", 3, 0);
        game.getHorses().add(splu);
        game.getHorses().add(neznau);
        game.getHorses().add(sampridumai);
        game.run();
        game.printWinner();
    }

    public void run() throws InterruptedException
    {
        for (int i = 1; i <= 100; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move()
    {
        for (Horse horse : getHorses())
        {
            horse.move();
        }
    }

    public void print()
    {
        for (Horse horse : getHorses())
        {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner()
    {
        double max = 0;
        int k = 0;
        for (int i = 0; i < getHorses().size(); i++)
        {
            if (getHorses().get(i).getDistance() >= max)
            {
                max = getHorses().get(i).getDistance();
                k = i;
            }
        }
        return getHorses().get(k);
    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

}

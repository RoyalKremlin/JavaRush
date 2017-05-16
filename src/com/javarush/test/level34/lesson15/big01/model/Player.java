package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created on 15.05.2017 at 22:50 :)
 */
public class Player extends CollisionObject implements Movable
{
    public Player(int x, int y)
    {
        super(x, y);
    }


    @Override
    public void move(int x, int y)
    {
        setX(getX()+x);
        setY(getY()+y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.BLUE);
        graphics.fillOval(getX(),getY(),this.getWidth(),this.getHeight());
    }
}

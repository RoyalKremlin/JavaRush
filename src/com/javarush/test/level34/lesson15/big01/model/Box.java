package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created on 15.05.2017 at 22:51 :)
 */
public class Box extends CollisionObject implements Movable
{
    public Box(int x, int y)
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
        graphics.setColor(Color.ORANGE);
        graphics.fillRect(getX(),getY(),this.getWidth(),this.getHeight());

        graphics.setColor(Color.BLACK);
        graphics.drawLine(getX(),getY(),getX()+getWidth(),getY()+getHeight());
        graphics.drawLine(getX()+getWidth(),getY(),getX(),getY()+getHeight());
    }
}

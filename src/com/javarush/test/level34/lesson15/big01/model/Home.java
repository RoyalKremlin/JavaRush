package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created on 15.05.2017 at 23:21 :)
 */
public class Home extends GameObject
{
    public Home(int x, int y)
    {
        super(x, y,2,2);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.GREEN);
        graphics.drawOval(getX(),getY(), getWidth()+15, getHeight()+15);
    }
}

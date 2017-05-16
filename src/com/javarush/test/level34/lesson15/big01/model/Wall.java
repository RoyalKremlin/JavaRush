package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created on 15.05.2017 at 23:33 :)
 */
public class Wall extends CollisionObject
{
    public Wall(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(getX(),getY(),this.getWidth(),this.getHeight());
    }
}

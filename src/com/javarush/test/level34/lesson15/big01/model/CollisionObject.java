package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created on 15.05.2017 at 19:50 :)
 */
public class CollisionObject extends GameObject
{
    @Override
    public void draw(Graphics graphics)
    {

    }

    public CollisionObject(int x, int y)
    {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction)
    {
        switch (direction)
        {
            case RIGHT:
                return (getX() + Model.FIELD_SELL_SIZE == gameObject.getX() && getY() == gameObject.getY());

            case LEFT:
                return (getX() - Model.FIELD_SELL_SIZE == gameObject.getX() && getY() == gameObject.getY());

            case UP:
                return (getX() == gameObject.getX() && getY() - Model.FIELD_SELL_SIZE == gameObject.getY());

            case DOWN:
                return (getX() == gameObject.getX() && getY() + Model.FIELD_SELL_SIZE == gameObject.getY());

            default:
                return false;
        }
    }
}

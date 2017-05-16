package com.javarush.test.level34.lesson15.big01.view;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;
import com.javarush.test.level34.lesson15.big01.model.Direction;
import com.javarush.test.level34.lesson15.big01.model.GameObject;
import com.javarush.test.level34.lesson15.big01.model.GameObjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;


/**
 * Created on 15.05.2017 at 19:39 :)
 */
public class Field extends JPanel
{
    private View view;
    private EventListener eventListener;

    public Field(View view)
    {
        this.view = view;
        KeyHandler keyHandler = new KeyHandler();
        addKeyListener(keyHandler);
        setFocusable(true);
    }

    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;
    }

    public void paint(Graphics graphics)
    {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,getWidth()-1,getHeight()-1);
        GameObjects gameObjects = view.getGameObjects();
        Set<GameObject> all = gameObjects.getAll();
        for (GameObject gameObject: all)
        {
            gameObject.draw(graphics);
        }

    }

    public class KeyHandler extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_LEFT:
                eventListener.move(Direction.LEFT);
                    break;
                case KeyEvent.VK_RIGHT:
                    eventListener.move(Direction.RIGHT);
                    break;
                case KeyEvent.VK_UP :
                    eventListener.move(Direction.UP);
                    break;
                case KeyEvent.VK_DOWN :
                    eventListener.move(Direction.DOWN);
                    break;
                case KeyEvent.VK_R:
                    eventListener.restart();
                    break;
                case KeyEvent.VK_N:
                    eventListener.startNextLevel();
                    break;
            }
        }
    }
}

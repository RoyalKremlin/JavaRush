package com.javarush.test.level34.lesson15.big01.controller;

import com.javarush.test.level34.lesson15.big01.model.Direction;

/**
 * Created on 16.05.2017 at 11:07 :)
 */
public interface EventListener
{
   void move(Direction direction);
   void restart();
   void startNextLevel();
   void levelCompleted(int level);
}

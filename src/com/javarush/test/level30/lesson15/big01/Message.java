package com.javarush.test.level30.lesson15.big01;

import java.io.Serializable;

/**
 * Created by Sanya on 11.03.2017.
 */
public class Message implements Serializable
{
    final private MessageType type;
    final private String data;

    public Message(MessageType messageType)
    {
        this.type = messageType;
        this.data=null;
    }

    public Message(MessageType messageType, String data)
    {
        this.type = messageType;
        this.data = data;
    }

    public MessageType getType()
    {
        return type;
    }

    public String getData()
    {
        return data;
    }

}

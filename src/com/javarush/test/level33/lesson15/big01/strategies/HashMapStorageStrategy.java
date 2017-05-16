package com.javarush.test.level33.lesson15.big01.strategies;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 06.05.2017 at 11:54 :)
 */
public class HashMapStorageStrategy implements StorageStrategy
{
    private HashMap<Long, String> data = new HashMap<>();


    @Override
    public boolean containsKey(Long key)
    {
        if (data.containsKey(key)) return true;
        return false;
    }

    @Override
    public boolean containsValue(String value)
    {
        if (data.containsValue(value)) return true;
        return false;
    }

    @Override
    public void put(Long key, String value)
    {
        data.put(key,value);
    }

    @Override
    public Long getKey(String value)
    {
        Long res = null;
        for (Map.Entry<Long, String> entry : data.entrySet()) {
            if (entry.getValue().equals(value)) {
                res = entry.getKey();
            }
        }
        return res;
    }

    @Override
    public String getValue(Long key)
    {
        return data.get(key);
    }
}

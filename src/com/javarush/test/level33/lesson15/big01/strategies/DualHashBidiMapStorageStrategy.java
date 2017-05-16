package com.javarush.test.level33.lesson15.big01.strategies;

import org.apache.commons.collections4.bidimap.DualHashBidiMap;

/**
 * Created on 11.05.2017 at 23:26 :)
 */
public class DualHashBidiMapStorageStrategy implements StorageStrategy
{

    private DualHashBidiMap<Long,String> data = new DualHashBidiMap<>();

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
        return data.getKey(value);
    }

    @Override
    public String getValue(Long key)
    {
        return data.get(key);
    }
}

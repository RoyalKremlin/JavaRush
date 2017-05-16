package com.javarush.test.level33.lesson15.big01.strategies;

import com.google.common.collect.HashBiMap;

/**
 * Created on 11.05.2017 at 23:07 :)
 */
public class HashBiMapStorageStrategy implements StorageStrategy
{
    private HashBiMap<Long,String> data = HashBiMap.create();

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
        return data.inverse().get(value);
    }

    @Override
    public String getValue(Long key)
    {
        return data.get(key);
    }
}

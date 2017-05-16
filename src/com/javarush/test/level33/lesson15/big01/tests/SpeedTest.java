package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created on 12.05.2017 at 15:17 :)
 */
public class SpeedTest
{
    private Set<Long> Longs = new HashSet<>();

    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids)
    {
        Date dateBefore = new Date();
        long timeBefore = dateBefore.getTime();

        for (String string: strings)
        {
            ids.add(shortener.getId(string));
        }
        Date dateAfter = new Date();
        long timeAfter = dateAfter.getTime();

        return (timeAfter-timeBefore);
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings)
    {
        Date dateBefore = new Date();
        long timeBefore = dateBefore.getTime();

        for (Long longs: ids)
        {
            strings.add(shortener.getString(longs));
        }
        Date dateAfter = new Date();
        long timeAfter = dateAfter.getTime();

        return (timeAfter-timeBefore);
    }
    @Test
    public void testHashMapStorage()
    {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        for (int i=0;i<1000;i++)
        {
          origStrings.add(Helper.generateRandomString());
        }
        long timeForGettingIdsS1 = getTimeForGettingIds(shortener1, origStrings, Longs);
        long timeForGettingIdsS2 = getTimeForGettingIds(shortener2, origStrings, Longs);
        Assert.assertTrue(timeForGettingIdsS1>timeForGettingIdsS2);

        long timeForGettingStringsS1 = getTimeForGettingStrings(shortener1, Longs, origStrings);
        long timeForGettingStringsS2 = getTimeForGettingStrings(shortener2, Longs, origStrings);
        Assert.assertEquals(timeForGettingStringsS1,timeForGettingStringsS2,5);
    }
}

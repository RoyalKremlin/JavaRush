package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created on 10.05.2017 at 16:17 :)
 */
public class Solution
{

   public static Set<Long> getIds(Shortener shortener, Set<String> strings)
   {
       Set<Long> longs = new HashSet<>();
       for (String string : strings)
       {
           longs.add(shortener.getId(string));
       }
       return longs;
   }

   public static Set<String> getStrings(Shortener shortener, Set<Long> keys)
   {
       Set<String> strings = new HashSet<>();
       for (Long key: keys)
       {
           strings.add(shortener.getString(key));
       }
       return strings;
   }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber)
    {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> strings = new HashSet<>();
        for (int i=0;i<elementsNumber;i++)
        {
           strings.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);


        long beforeIds = new Date().getTime();
        Set<Long> getIds = getIds(shortener, strings);
        long afterIds = new Date().getTime();
        Helper.printMessage(String.valueOf(afterIds-beforeIds));

        long beforeStrings = new Date().getTime();
        Set<String> getStrings = getStrings(shortener, getIds);
        long afterStrings = new Date().getTime();
        Helper.printMessage(String.valueOf(afterStrings-beforeStrings));

        if (getStrings.equals(strings))
            Helper.printMessage("Тест пройден.");
        else
            Helper.printMessage("Тест не пройден.");
    }

    public static void main(String[] args)
    {
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        OurHashMapStorageStrategy ourHashMapStorageStrategy = new OurHashMapStorageStrategy();
        OurHashBiMapStorageStrategy ourHashBiMapStorageStrategy = new OurHashBiMapStorageStrategy();
        HashBiMapStorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();
        DualHashBidiMapStorageStrategy dualHashBidiMapStorageStrategy = new DualHashBidiMapStorageStrategy();
        FileStorageStrategy fileStorageStrategy = new FileStorageStrategy();


        testStrategy(hashMapStorageStrategy,40000);
        testStrategy(ourHashMapStorageStrategy,40000);
        testStrategy(ourHashBiMapStorageStrategy, 40000);
        testStrategy(hashBiMapStorageStrategy, 40000);
        testStrategy(dualHashBidiMapStorageStrategy, 40000);
        testStrategy(fileStorageStrategy, 100);

    }

}

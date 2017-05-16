package com.javarush.test.level27.lesson15.big01.ad;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Sanya on 15.02.2017.
 */
public class AdvertisementManager
{
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private int timeSeconds;

    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException
    {
        for (Advertisement advertisement : storage.list())
        {
            advertisement.revalidate();
        }

        if (storage.list().isEmpty()) throw new NoVideoAvailableException();

        Comparator<Advertisement> compareByAPOD = new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                return Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
            }
        };
        List<Advertisement> advertisements = new ArrayList<>();
        int timeLeft = timeSeconds;
        for (Advertisement item : storage.list())
        {
            if (item.getDuration() <= timeLeft)
            {
                advertisements.add(item);
                timeLeft -= item.getDuration();
            }
        }
        if (advertisements.isEmpty() || timeLeft == timeSeconds)
            throw new NoVideoAvailableException();
        Collections.sort(advertisements, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                if (o1.getAmountPerOneDisplaying() == o2.getAmountPerOneDisplaying())
                {
                    long oneSecondCost1 = (o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration());
                    long oneSecondCost2 = (o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration());
                    return Long.compare(oneSecondCost1, oneSecondCost2);
                }
                return Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
            }
        });





        for (Advertisement advertisement : advertisements)
        {
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d",
                    advertisement.getName(),
                    advertisement.getAmountPerOneDisplaying(),
                    advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration()));
            advertisement.revalidate();
        }
    }
}
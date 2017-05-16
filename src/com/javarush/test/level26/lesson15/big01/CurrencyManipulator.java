package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Sanya on 04.02.2017.
 */
public class CurrencyManipulator
{

    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void addAmount(int denomination, int count)
    {
        if (denominations.containsKey(denomination))
        {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else
        {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount()
    {
        int totalAmount = 0;
        for (Map.Entry entry : denominations.entrySet())
        {
            int a = (Integer) entry.getKey();
            int b = (Integer) entry.getValue();
            totalAmount += a * b;
        }
        return totalAmount;
    }

    public boolean hasMoney()
    {
        return !(denominations.isEmpty());
    }

    public boolean isAmountAvailable(int expectedAmount)
    {
        return (expectedAmount <= getTotalAmount());
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        TreeMap<Integer,Integer> amount = new TreeMap<>(Collections.reverseOrder());
        amount.putAll(denominations);
        Map<Integer,Integer> putAmount;
        int expected;
        while (!amount.isEmpty())
        {
            putAmount = new TreeMap<>(Collections.reverseOrder());
            expected = expectedAmount;
            for (Map.Entry<Integer, Integer> entry : amount.entrySet())
            {
                if (expected / entry.getKey() > 0 && entry.getValue() >= expected / entry.getKey())
                {
                    putAmount.put(entry.getKey(), expected / entry.getKey());
                    expected = expected - entry.getKey() * (int) (expected / entry.getKey());
                }
                else if(expected / entry.getKey() > 0 && entry.getValue() < expected / entry.getKey() && entry.getValue() > 0)
                {
                    putAmount.put(entry.getKey(), entry.getValue());
                    expected = expected - entry.getKey() * entry.getValue();
                }
            }
            if (expected == 0)
            {
                for (Map.Entry<Integer, Integer> entry : putAmount.entrySet())
                    denominations.put(entry.getKey(), denominations.get(entry.getKey()) - entry.getValue());
                return putAmount;
            }
            else{
                if (amount.get(amount.firstKey()) == 0) amount.remove(amount.firstKey());
                if (!amount.isEmpty()) amount.put(amount.firstKey(),amount.get(amount.firstKey())-1);
            }
        }
        throw new NotEnoughMoneyException();
    }
}
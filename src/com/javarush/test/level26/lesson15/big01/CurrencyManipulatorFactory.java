package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sanya on 04.02.2017.
 */
public class CurrencyManipulatorFactory {

    private static Map<String, CurrencyManipulator> currencyManipulators = new HashMap<>();

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){

        if (currencyManipulators.containsKey(currencyCode)) {
            return currencyManipulators.get(currencyCode);
        }
        else{
            CurrencyManipulator temp = new CurrencyManipulator(currencyCode);
            currencyManipulators.put(currencyCode,temp);
            return temp;
        }
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return currencyManipulators.values();
    }
}
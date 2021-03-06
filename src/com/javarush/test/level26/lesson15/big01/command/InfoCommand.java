package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Sanya on 05.02.2017.
 */
class InfoCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"info_en", Locale.ENGLISH);

    @Override
    public void execute()
    {
        if (CurrencyManipulatorFactory.getAllCurrencyManipulators().isEmpty())
            ConsoleHelper.writeMessage(res.getString("no.money"));
        else
        {
            for (CurrencyManipulator c : CurrencyManipulatorFactory.getAllCurrencyManipulators())
            {
                if (c.hasMoney())
                    ConsoleHelper.writeMessage(res.getString("before")+ c.getCurrencyCode() + " - " + c.getTotalAmount());
                else
                    ConsoleHelper.writeMessage(res.getString("no.money"));
            }
        }
    }
}

package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Sanya on 05.02.2017.
 */
class DepositCommand implements Command

{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"deposit_en", Locale.ENGLISH);

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currenceCode = ConsoleHelper.askCurrencyCode();
        String[] tdata = ConsoleHelper.getValidTwoDigits(currenceCode);
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currenceCode);
        currencyManipulator.addAmount(Integer.parseInt(tdata[0]), Integer.parseInt(tdata[1]));
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"),(Integer.parseInt(tdata[0]) * Integer.parseInt(tdata[1])),currenceCode ));
    }
}

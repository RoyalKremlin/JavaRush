package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Sanya on 05.02.2017.
 */
class WithdrawCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"withdraw_en", Locale.ENGLISH);

    @Override
    public void execute()throws InterruptOperationException
    {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        int withdraw = 0;
        while (true)
        {
            System.out.println(res.getString("specify.amount"));
            try{
                withdraw = Integer.parseInt(ConsoleHelper.readString());
                if (withdraw <= 0) throw new NumberFormatException();
                if (!manipulator.isAmountAvailable(withdraw)) throw new NotEnoughMoneyException();
                Map<Integer, Integer> withdrawMap = manipulator.withdrawAmount(withdraw);
                for (Map.Entry<Integer, Integer> entry : withdrawMap.entrySet())
                    ConsoleHelper.writeMessage("\t" + entry.getKey() + " - " + entry.getValue());
               ConsoleHelper.writeMessage("Transaction  was successfully done");
                break;
            }
            catch (NotEnoughMoneyException e)
            {
               ConsoleHelper.writeMessage(res.getString("not.enough.money"));
            }
            catch (NumberFormatException e){
             ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            }
        }
    }
}
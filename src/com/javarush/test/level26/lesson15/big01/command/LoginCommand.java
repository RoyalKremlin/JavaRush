package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Sanya on 06.02.2017.
 */
class LoginCommand implements Command
{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"verifiedCards", Locale.ENGLISH);
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"login_en", Locale.ENGLISH);


    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String enteredCardNumber = ConsoleHelper.readString();
            String enteredCardCode = ConsoleHelper.readString();

            if (enteredCardNumber.matches("\\d{12}") &&  enteredCardCode.matches("\\d{4}"))
            {
                if (validCreditCards.containsKey(enteredCardNumber) && enteredCardCode.equals(validCreditCards.getString(enteredCardNumber)))
                {
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"),enteredCardNumber));
                    break;
                }
                else
                {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"),enteredCardNumber));
                }
            }
            else
            {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            }
        }
    }
}

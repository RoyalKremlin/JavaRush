package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Sanya on 05.02.2017.
 */
public class CommandExecutor

{
  private static Map<Operation, Command> map = new HashMap<>();

    static
    {   map.put(Operation.LOGIN, new LoginCommand());
        map.put(Operation.INFO, new InfoCommand());
        map.put(Operation.DEPOSIT,new DepositCommand());
        map.put(Operation.EXIT,new ExitCommand());
        map.put(Operation.WITHDRAW,new WithdrawCommand());
    }

    private CommandExecutor()
    {
    }

    public static final void execute(Operation operation) throws InterruptOperationException
    {
        map.get(operation).execute();
    }
}


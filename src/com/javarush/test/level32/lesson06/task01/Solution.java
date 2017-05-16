package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution
{
    public static void main(String[] args)
    {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword()
    {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String lettersLow = "abcdefghijklmnopqrstuvwxyz";
        String lettersHigh = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "1234567890";

        int STR_LENGTH = 8; //
        Random random = new Random();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 2; i++)
        {
            int number = random.nextInt(lettersLow.length());
            char ch = lettersLow.charAt(number);
            builder.append(ch);
        }
        for (int i = 2; i < 5; i++)
        {
            int number = random.nextInt(lettersHigh.length());
            char ch = lettersHigh.charAt(number);
            builder.append(ch);
        }
        for (int i = 5; i < STR_LENGTH; i++)
        {
            int number = random.nextInt(digits.length());
            char ch = digits.charAt(number);
            builder.append(ch);
        }


        try
        {
            byteArrayOutputStream.write(builder.toString().getBytes());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return byteArrayOutputStream;
    }
}

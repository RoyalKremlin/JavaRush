package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        if (args[0].equals("-u")){

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = bufferedReader.readLine();
            bufferedReader.close();
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileName));
            ArrayList<String> goods = new ArrayList<String>();

            while (true){
                String str = bufferedReader1.readLine();
                if (str != null) goods.add(str);
                else break;
            }

            StringBuilder stringName = new StringBuilder();
            StringBuilder stringPrice = new StringBuilder();
            StringBuilder stringQuantity = new StringBuilder();
            StringBuilder stringId = new StringBuilder();

            for (int i = 1; i < args.length; i++)
            {
                stringName.append(args[i] + " ");
            }






        }


        else if (args[0].equals("-d")){
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = bufferedReader.readLine();
            bufferedReader.close();
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileName));

        }
    }
}

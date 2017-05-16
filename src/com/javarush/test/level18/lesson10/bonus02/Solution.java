package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
            if (args[0].equals("-c"))
            {

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String fileName = bufferedReader.readLine();
                bufferedReader.close();
                BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileName)); //создаем считыватель файла
                LinkedList<String> goods = new LinkedList<String>(); //создаем список строк


                while (true)
                {
                    String str = bufferedReader1.readLine();
                    if (str != null) goods.add(str);
                    else break;
                }
                bufferedReader1.close();


                StringBuilder stringName = new StringBuilder();
                StringBuilder stringPrice = new StringBuilder();
                StringBuilder stringQuantity = new StringBuilder();
                StringBuilder stringId = new StringBuilder();
                for (int i = 1; i < args.length; i++)
                {
                    stringName.append(args[i] + " ");
                }
                if (stringName.length() > 30) stringName.setLength(30);
                if (stringName.length() < 30)
                {
                    while (stringName.length() < 30) stringName.append(" ");
                }
                double price = Double.parseDouble(args[args.length - 2]);
                stringPrice.append(price);
                if (stringPrice.length() > 8) stringPrice.setLength(8);
                if (stringPrice.length() < 8)
                {
                    while (stringPrice.length() < 8) stringPrice.append(" ");
                }
                Integer quantity = Integer.parseInt(args[args.length - 1]);
                stringQuantity.append(String.valueOf(quantity));
                if (stringQuantity.length() > 4) stringQuantity.setLength(8);
                if (stringQuantity.length() < 4)
                {
                    while (stringQuantity.length() < 4) stringQuantity.append(" ");
                }


                int[] ids = new int[goods.size()];
                for (int i = 0; i < goods.size(); i++)
                {
                    String str = "";
                    char[] c = goods.get(i).toCharArray();
                    for (int j = 0; j < 8; j++)
                    {
                        if (c[j] == ' ') break;
                        else
                            str += c[j];
                    }
                    ids[i] = Integer.parseInt(str);
                }
                int maxId = 0;
                for (int n : ids)
                {
                    maxId = Math.max(maxId, n);
                }
                stringId.append(++maxId);
                if(stringId.length()>8)stringId.setLength(8);
                if(stringId.length()<8){
                    while(stringId.length()<8) stringId.append(" ");
                }

                StringBuilder FinalString = new StringBuilder();
                FinalString.append(stringId).append(stringName).append(stringPrice).append(stringQuantity);
                FileOutputStream outputStream = new FileOutputStream(fileName,true);
                outputStream.write(FinalString.toString().getBytes());
                outputStream.close();
            }
        }
    }

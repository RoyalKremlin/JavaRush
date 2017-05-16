package com.javarush.test.level31.lesson06.home01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        ZipFile zipFile = new ZipFile(args[1]);
        Map<String, byte[]> entryMap = new HashMap<>();
        Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();
        while (zipEntries.hasMoreElements())
        {
            ZipEntry zipEntry = zipEntries.nextElement();
            if (!zipEntry.isDirectory())
            {
                InputStream inputStream = zipFile.getInputStream(zipEntry);
                byte[] buff = new byte[inputStream.available()];
                inputStream.read(buff);
                inputStream.close();
                entryMap.put(zipEntry.getName(), buff);
            }
        }
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(args[1]));
        Path newFilePath = Paths.get(args[0]);
        String newFileName = newFilePath.getFileName().toString();
        for (Map.Entry<String, byte[]> mapEntry : entryMap.entrySet())
        {
            if (!mapEntry.getKey().equals(newFileName) && !mapEntry.getKey().equals("new/" + newFileName))
            {
                zipOutputStream.putNextEntry(new ZipEntry(mapEntry.getKey()));
                zipOutputStream.write(mapEntry.getValue());
            }
        }
        zipOutputStream.putNextEntry(new ZipEntry("new/" + newFileName));
        Files.copy(newFilePath, zipOutputStream);
        zipOutputStream.close();
    }
}
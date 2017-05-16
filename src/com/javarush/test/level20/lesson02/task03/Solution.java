package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception
    {
        this.load(new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine()));
        //implement this method - реализуйте этот метод
    }
    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        for (Map.Entry<String,String> map: properties.entrySet()){
            prop.setProperty((map.getKey()),(map.getValue()));
        }
        prop.store(outputStream,"No comments");
        outputStream.close();
        //implement this method - реализуйте этот метод
    }
    public void load(InputStream inputStream) throws Exception {
        Properties prop = new Properties();
        prop.load(inputStream);
        for (String q: prop.stringPropertyNames())
            properties.put(q,prop.getProperty(q));
        inputStream.close();
        //implement this method - реализуйте этот метод
    }
}

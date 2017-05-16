package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private static  ArrayList<Integer> openTags = new ArrayList<>();
    private static ArrayList<Integer> closeTags = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        final String OPEN_TAG = "<" + args[0] + " +>|<" + args[0] + ">|<" + args[0] + "\\s";
        final String CLOSE_TAG = "</" + args[0] + ">";
        String mainStr = "";
        TreeMap<Integer, Integer> result = new TreeMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(new File(reader.readLine()));
        reader.close();
        while (fileReader.ready()){
            mainStr += (char) fileReader.read();
        }
        fileReader.close();
        getIndexs(mainStr, OPEN_TAG, openTags);
        getIndexs(mainStr, CLOSE_TAG, closeTags);
        for (Integer i : closeTags){
            int index = 0;
            int openIndex = 0;
            int closeIndex = 0;
            while (i > openTags.get(index)){
                openIndex = openTags.get(index);
                closeIndex = i;
                index++;
                if (index >= openTags.size()) break;
            }
            openTags.remove(index-1);
            result.put(openIndex, closeIndex + CLOSE_TAG.length());
        }
        for (Map.Entry<Integer, Integer> pair : result.entrySet()){
            System.out.println(mainStr.substring(pair.getKey(), pair.getValue()).replaceAll("\r\n", ""));
        }
    }
    private static void getIndexs(String str, String regex, ArrayList<Integer> list){
        Pattern tagPattern = Pattern.compile(regex);
        Matcher tagMatcher = tagPattern.matcher(str);
        Integer previousTagIndex = 0;
        while (tagMatcher.find()){
            Integer tagIndex = tagMatcher.start();
            list.add(tagIndex + previousTagIndex);
            previousTagIndex += tagIndex + 1;
            str = str.substring(tagIndex + 1);
            tagMatcher = tagPattern.matcher(str);
        }
    }
}

package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Alexandr on 02.05.2017.
 */
public class HTMLFileFilter extends FileFilter
{
    @Override
    public boolean accept(File f)
    {
        String name = f.getName().toLowerCase();
        return f.isDirectory() || name.endsWith(".html") || name.endsWith(".htm");
    }

    @Override
    public String getDescription()
    {
        return "HTML и HTM файлы";
    }
}

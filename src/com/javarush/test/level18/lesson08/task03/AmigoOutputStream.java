package com.javarush.test.level18.lesson08.task03;

import java.io.*;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используйте наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends FileOutputStream
{
    public static String fileName = "D:\\11";
    private FileOutputStream fileOutputStream;
    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException
    {
        super(fileName);
        this.fileOutputStream = fileOutputStream;
    }
    public void write(int x) throws IOException
    {
        fileOutputStream.write(x);
    }
    public void write(byte[] x) throws IOException
    {
        fileOutputStream.write(x);
    }
    public void write(byte[] x,int y,int z) throws IOException
    {
        fileOutputStream.write(x,y,z);
    }
    public void flush() throws IOException
    {
        fileOutputStream.flush();
    }
    public void close() throws IOException
    {
        fileOutputStream.flush();
        String y = "JavaRush © 2012-2013 All rights reserved.";
        fileOutputStream.write(y.getBytes());
        fileOutputStream.close();
    }
    public static void main(String[] args) throws FileNotFoundException
    {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }
}

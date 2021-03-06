package com.javarush.test.level33.lesson15.big01.strategies;
import com.javarush.test.level33.lesson15.big01.ExceptionHandler;
import com.javarush.test.level33.lesson15.big01.Helper;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket
{
    private Path path;

    public FileBucket()
    {
        try {
            path = Files.createTempFile(Helper.generateRandomString(), null);
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
        path.toFile().deleteOnExit();
    }
    public long getFileSize()
    {
        return path.toFile().length();
    }
    public void putEntry(Entry entry) {
        try (ObjectOutputStream s = new ObjectOutputStream(Files.newOutputStream(path))) {
            s.writeObject(entry);
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
    }
    public Entry getEntry() {
        if (getFileSize() == 0) return null;
        try (ObjectInputStream s = new ObjectInputStream(Files.newInputStream(path)))
        {
            Entry result = (Entry) s.readObject();
            return result;
        }
        catch (Exception e) {
            ExceptionHandler.log(e);
            return null;
        }
    }
    public void remove(){
        try {
            Files.delete(path);
        }
        catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }
}
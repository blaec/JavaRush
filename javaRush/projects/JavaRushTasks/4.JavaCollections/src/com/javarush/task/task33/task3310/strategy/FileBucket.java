package com.javarush.task.task33.task3310.strategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Files.size;

/**
 * Created by blaec on 15\07\17.
 */
public class FileBucket {
    private Path path;

    // create temp file: temp3310.tmp in temp directory tempfiles
    public FileBucket() {
        try {
            path = Files.createTempFile(null,null);
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            // skip here
        }

        path.toFile().deleteOnExit();
    }

    public long getFileSize() {
        long fileSize = 0;

        try {
            fileSize = size(path);
        } catch (IOException e) { }

        return fileSize;
    }

    public void putEntry(Entry entry) {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(Files.newOutputStream(path));
            oos.writeObject(entry);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Entry getEntry() {
        Entry output = null;
        ObjectInputStream ois = null;

        if (getFileSize() == 0)
            output = null;
        else {
            try {
                ois = new ObjectInputStream(Files.newInputStream(path));
                output = (Entry) ois.readObject();
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return output;
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

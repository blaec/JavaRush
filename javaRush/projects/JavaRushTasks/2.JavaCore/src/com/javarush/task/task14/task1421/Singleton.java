package com.javarush.task.task14.task1421;

/**
 * Created by blaec on 24\05\17.
 */
public class Singleton {
    private static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }

    private Singleton() {
    }
}

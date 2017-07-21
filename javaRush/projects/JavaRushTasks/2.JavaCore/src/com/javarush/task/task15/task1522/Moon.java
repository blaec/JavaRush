package com.javarush.task.task15.task1522;

/**
 * Created by blaec on 28\05\17.
 */
public class Moon implements Planet{
    private static Moon instance = null;

    protected Moon() {
        // Exists only to defeat instantiation.
    }

    public static Moon getInstance() {
        if (instance == null)
            instance = new Moon();
        return instance;
    }
}

package com.javarush.task.task15.task1522;

/**
 * Created by blaec on 28\05\17.
 */
public class Earth implements Planet{
    private static Earth instance = null;

    protected Earth() {
        // Exists only to defeat instantiation.
    }

    public static Earth getInstance() {
        if (instance == null)
            instance = new Earth();
        return instance;
    }
}

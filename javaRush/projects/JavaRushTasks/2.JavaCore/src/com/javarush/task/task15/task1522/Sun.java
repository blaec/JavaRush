package com.javarush.task.task15.task1522;

/**
 * Created by blaec on 28\05\17.
 */
public class Sun implements Planet{
    private static Sun instance = null;

    protected Sun() {
        // Exists only to defeat instantiation.
    }

    public static Sun getInstance() {
        if (instance == null)
            instance = new Sun();
        return instance;
    }
}

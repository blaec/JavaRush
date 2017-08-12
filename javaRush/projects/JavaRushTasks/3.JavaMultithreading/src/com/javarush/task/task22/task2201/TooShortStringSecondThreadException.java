package com.javarush.task.task22.task2201;

public class TooShortStringSecondThreadException extends RuntimeException {
    public TooShortStringSecondThreadException(StringIndexOutOfBoundsException e) {
//        super(e.getClass().getCanonicalName() + ": " + e.getMessage());
        super(e);
    }
}

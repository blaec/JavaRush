package com.javarush.task.task22.task2201;

public class TooShortStringFirstThreadException extends RuntimeException {
    public TooShortStringFirstThreadException(StringIndexOutOfBoundsException e) {
//        super(e.getClass().getCanonicalName() + ": " + e.getMessage());
        super(e);
    }
}

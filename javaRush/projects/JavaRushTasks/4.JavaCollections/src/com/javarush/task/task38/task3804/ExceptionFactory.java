package com.javarush.task.task38.task3804;

public class ExceptionFactory {
    public static Throwable getException (Enum element) {
        if (element == null)                    return new IllegalArgumentException();

        String message = element.toString().substring(0, 1) + element.toString().toLowerCase().replaceAll("_", " ").substring(1);

        switch (element.getClass().getSimpleName()) {
            case "ExceptionApplicationMessage": return new Exception(message);
            case "ExceptionDBMessage":          return new RuntimeException(message);
            case "ExceptionUserMessage":        return new Error(message);
        }

        return new IllegalArgumentException();
    }
}

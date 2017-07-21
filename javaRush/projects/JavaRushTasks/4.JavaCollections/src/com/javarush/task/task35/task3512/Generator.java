package com.javarush.task.task35.task3512;

public class Generator<T> {
    private Class<T> cls;

    public Generator(Class<T> cls) {
        this.cls = cls;
    }

//    T createContents(Class<T> clazz) throws IllegalAccessException, InstantiationException {
//        return (T) clazz.newInstance();

//    System.out.println(eventGenerator.createContents(Event.class).getId());
//    }


    T newInstance() throws IllegalAccessException, InstantiationException {
        return (T) cls.newInstance();
    }
}

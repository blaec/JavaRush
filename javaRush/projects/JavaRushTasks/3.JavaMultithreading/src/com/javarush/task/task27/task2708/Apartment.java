package com.javarush.task.task27.task2708;

public class Apartment {
    private String location;
    private final RealEstate realEstate;

    public Apartment(RealEstate realEstate) {
        this.realEstate = realEstate;
        setLocation(String.valueOf(Math.random() * 10));
    }

    public synchronized String getLocation() {
        return location;
    }

    public synchronized void setLocation(String location) {
        this.location = location;
    }

    public void revalidate(boolean isEmpty) {
        System.out.println("IN :  Ap_revalidate: " + Thread.currentThread().getName());
        if (isEmpty) realEstate.up(this);
        System.out.println("OUT:  Ap_revalidate: " + Thread.currentThread().getName());
    }
}

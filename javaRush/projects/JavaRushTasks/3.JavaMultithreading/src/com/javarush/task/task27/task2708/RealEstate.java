package com.javarush.task.task27.task2708;

import java.util.HashSet;
import java.util.Set;

public class RealEstate {

    private final Set<Apartment> allApartments;
    private final Set<Apartment> activeApartments;

    public RealEstate() {
        allApartments = new HashSet();
        activeApartments = new HashSet();

        //add some data
        allApartments.add(new Apartment(this));
        allApartments.add(new Apartment(this));
        allApartments.add(new Apartment(this));
        allApartments.add(new Apartment(this));
        allApartments.add(new Apartment(this));
        allApartments.add(new Apartment(this));
    }

    public Set<Apartment> getAllApartments() {
        return allApartments;
    }

    public synchronized void up(Apartment apartment) {
        System.out.println("IN :   RE_up: " + Thread.currentThread().getName());

            activeApartments.add(apartment);
        System.out.println("OUT:   RE_up: " + Thread.currentThread().getName());
    }

    public void revalidate() {
        System.out.println("IN : RE_revalidate: " + Thread.currentThread().getName());
        synchronized (this) {
            activeApartments.clear();
            for (Apartment apartment : allApartments) {
                // randomValue always false, now it could change false/true
//                boolean randomValue = ((int) (Math.random() * 2)) % 2 == 0;
                boolean randomValue = Math.random() * 2 % 2 == 0;
                apartment.revalidate(randomValue);
            }
        }
        System.out.println("OUT: RE_revalidate: " + Thread.currentThread().getName());
    }
}

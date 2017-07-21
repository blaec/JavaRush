package com.javarush.task.task15.task1529;

/**
 * Created by blaec on 29\05\17.
 */
public class Plane implements Flyable{
    int passangers;
    @Override
    public void fly() {

    }

    public Plane(int passangers) {
        this.passangers = passangers;
    }
}

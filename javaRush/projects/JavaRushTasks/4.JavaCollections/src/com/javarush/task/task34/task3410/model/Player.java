package com.javarush.task.task34.task3410.model;

import javax.jws.WebParam;
import java.awt.*;

public class Player extends CollisionObject implements Movable{
    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.drawOval(getX(), getY(), getWidth(), getHeight());
        graphics.fillOval(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void move(int x, int y) {
        setX(this.getX() + x);
        setY(this.getY() + y);
    }
}

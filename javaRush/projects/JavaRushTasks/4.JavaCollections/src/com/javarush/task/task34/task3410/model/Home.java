package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Home extends GameObject{
    public Home(int x, int y) {
        super(x, y);
        setWidth(2);
        setHeight(2);
    }

    @Override
    public void draw(Graphics graphics) {
        int center = Model.FIELD_CELL_SIZE / 2;
        graphics.setColor(Color.RED);
        graphics.drawOval(getX() + center, getY() + center, getWidth(), getHeight());
    }
}

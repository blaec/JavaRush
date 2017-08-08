package com.javarush.task.task34.task3410.model;

import com.sun.org.apache.xpath.internal.operations.Mod;

public abstract class CollisionObject extends GameObject{
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        int shiftX = 0;
        int shiftY = 0;

        switch (direction) {
            case UP:        shiftY -= Model.FIELD_CELL_SIZE;    break;
            case DOWN:      shiftY += Model.FIELD_CELL_SIZE;    break;
            case LEFT:      shiftX -= Model.FIELD_CELL_SIZE;    break;
            case RIGHT:     shiftX += Model.FIELD_CELL_SIZE;    break;
        }

        return (this.getX() + shiftX == gameObject.getX()) && (this.getY() + shiftY == gameObject.getY());
    }
}

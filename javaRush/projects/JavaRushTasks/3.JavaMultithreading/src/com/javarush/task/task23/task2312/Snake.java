package com.javarush.task.task23.task2312;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;
    private int x;
    private int y;

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
        SnakeSection head = new SnakeSection(x, y);
        sections = new ArrayList<>();
        sections.add(head);
        isAlive = true;
    }

    public void move() {

        if (isAlive) {
            switch (direction) {
                case UP:    move(0, -1);    break;
                case RIGHT: move(1, 0);     break;
                case DOWN:  move(0, 1);     break;
                case LEFT:  move(-1, 0);    break;
            }
        }
    }
    public void move(int x, int y) {}

    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }


    public void checkBorders(SnakeSection head) {
        int headX = head.getX();
        int headY = head.getY();

        if (headX < 0 || headY < 0 || headX >= Room.game.getWidth() || headY >= Room.game.getHeight()) {
            isAlive = false;
        }
    }

    public void checkBody(SnakeSection head) {
        List<SnakeSection> body = new ArrayList<>(sections);
        body.remove(0);

        if (body.contains(head)) isAlive = false;
    }
}

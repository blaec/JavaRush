package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.nio.file.Paths;
import java.util.Set;

public class Model {
    public static final int FIELD_CELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
//    private LevelLoader levelLoader = new LevelLoader(Paths.get(Model.class.getPackage().getName() + ".res.levels.txt"));
    private LevelLoader levelLoader = new LevelLoader(Paths.get("C:\\Users\\blaec\\Google Drive\\Java\\javaRush\\projects\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task34\\task3410\\res\\levels.txt"));

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        currentLevel++;
        restartLevel(currentLevel);
    }

    public void move(Direction direction) {
        Player player = this.getGameObjects().getPlayer();

        if (!checkWallCollision(player, direction) && !checkBoxCollisionAndMoveIfAvaliable(direction)) {
            int shiftX = 0;
            int shiftY = 0;
            switch (direction) {
                case RIGHT: shiftX += FIELD_CELL_SIZE;    break;
                case LEFT:  shiftX -= FIELD_CELL_SIZE;    break;
                case DOWN:  shiftY += FIELD_CELL_SIZE;    break;
                case UP:    shiftY -= FIELD_CELL_SIZE;    break;
            }
            player.move(shiftX, shiftY);
            checkCompletion();
        }
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        boolean wasCollistion = false;

        Set<Wall> walls = this.getGameObjects().getWalls();

        for (Wall wall : walls) {
            if (gameObject.isCollision(wall, direction)) {
                wasCollistion = true;
                break;
            }
        }

        return wasCollistion;
    }

    public boolean checkBoxCollisionAndMoveIfAvaliable(Direction direction) {
        boolean cantMove = false;

        Set<Box> boxes = this.getGameObjects().getBoxes();
        Player player = this.getGameObjects().getPlayer();

        // Check if was collision with box
        for (Box box : boxes) {
            if (player.isCollision(box, direction)) {

                // If wall's behind the box - change flag and exit
                if (checkWallCollision(box, direction)) {
                    cantMove = true;
                    break;
                }

                // If box's behind the box - change flag and exit
                for (Box nextBox : boxes) {
                    if (box != nextBox && box.isCollision(nextBox, direction)) {
                        cantMove = true;
                        break;
                    }
                }

                // move a box if can
                if (!cantMove) {
                    int shiftX = 0;
                    int shiftY = 0;
                    switch (direction) {
                        case RIGHT: shiftX += FIELD_CELL_SIZE;    break;
                        case LEFT:  shiftX -= FIELD_CELL_SIZE;    break;
                        case DOWN:  shiftY += FIELD_CELL_SIZE;    break;
                        case UP:    shiftY -= FIELD_CELL_SIZE;    break;
                    }
                    box.move(shiftX, shiftY);
                    break;
                }
            }
        }

        return cantMove;
    }

    public void checkCompletion() {
        boolean notComplete = false;

        Set<Home> homes = this.getGameObjects().getHomes();
        Set<Box> boxes = this.getGameObjects().getBoxes();

        // Iterate all homes
        for (Home home : homes) {
            boolean homeFull = false;
            int x = home.getX();
            int y = home.getY();

            // Check if this home is full with any box
            for (Box box : boxes) {
                if (box.getX() == x && box.getY() == y) {
                    homeFull = true;
                    break;
                }
            }

            // If at least one home's not full - exit
            if (!homeFull) {
                notComplete = true;
                break;
            }
        }

        if (!notComplete) {
            eventListener.levelCompleted(currentLevel);
        }
    }
}

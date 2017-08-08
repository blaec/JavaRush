package com.javarush.task.task34.task3410.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    public LevelLoader(Path levels) {
    }

    public GameObjects getLevel(int level) {
        int center = Model.FIELD_CELL_SIZE / 2;

        Set<Wall> walls = new HashSet<>();
        walls.add(new Wall(center, center));
        walls.add(new Wall(Model.FIELD_CELL_SIZE + center, center));

        Set<Box> boxes = new HashSet<>();
        boxes.add(new Box(Model.FIELD_CELL_SIZE + center, Model.FIELD_CELL_SIZE + center));

        Set<Home> homes = new HashSet<>();
        homes.add(new Home(center, Model.FIELD_CELL_SIZE + center));

        return new GameObjects(walls, boxes, homes, new Player(Model.FIELD_CELL_SIZE * 2 + center, Model.FIELD_CELL_SIZE * 2 + center));
    }
}

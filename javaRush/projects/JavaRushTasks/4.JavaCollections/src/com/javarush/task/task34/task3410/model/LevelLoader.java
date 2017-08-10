package com.javarush.task.task34.task3410.model;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LevelLoader {
    private Path levels;
    private List<String> lines = new ArrayList<>();

    public LevelLoader(Path levels) {
        this.levels = levels;
        readFile();
    }

    private void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(levels.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    public GameObjects getLevel(int level) {
        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;
        int loopLevel = (level - 1) % 60 + 1;

        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains("Maze: ")) {
                String nextLevel = lines.get(i).replace("Maze: ","");
                if (nextLevel.equals(String.valueOf(loopLevel))) {
//                    int width = Integer.parseInt(lines.get(i + 2).replace("Size X: ", ""));
                    int height = Integer.parseInt(lines.get(i + 3).replace("Size Y: ", ""));

                    for (int y = 0; y < height; y++) {
                        String levelLine = lines.get(i + y + 7);
                        for (int x = 0; x < levelLine.length(); x++) {
                            int xPos = Model.FIELD_CELL_SIZE * (x + 1/2);
                            int yPos = Model.FIELD_CELL_SIZE * (y + 1/2);

                            switch (levelLine.charAt(x)) {
                                case 'X':
                                    walls.add(new Wall(xPos, yPos));
                                    break;
                                case '*':
                                    boxes.add(new Box(xPos, yPos));
                                    break;
                                case '.':
                                    homes.add(new Home(xPos, yPos));
                                    break;
                                case '@':
                                    player = new Player(xPos, yPos);
                                    break;
                                case '&':
                                    boxes.add(new Box(xPos, yPos));
                                    homes.add(new Home(xPos, yPos));
                                    break;
                            }
                        }
                    }
                }
            }
        }

        return new GameObjects(walls, boxes, homes, player);
    }
}

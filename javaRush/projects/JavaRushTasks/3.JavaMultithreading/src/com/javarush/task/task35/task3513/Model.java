package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Contain game logic and save game field
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    public int score = 0;
    public int maxTile = 2;

    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();

        if (emptyTiles != null && emptyTiles.size() > 0) {
            Tile rndTile = emptyTiles.get((int) (Math.random() * emptyTiles.size()));
            rndTile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                if (gameTiles[i][j].isEmpty())
                    emptyTiles.add(gameTiles[i][j]);
            }
        }

        return emptyTiles;
    }

    void resetGameTiles() {
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private boolean compressTiles(Tile[] tiles) {
        int shifts = 0;
        boolean isCompressed = false;

        // no need to check last tile (it cannot be compressed)
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].isEmpty()) {

                // move all tiles to the left
                for (int j = i; j < tiles.length - 1; j++) {
                    tiles[j].value = tiles[j +1].value;

                    // Try to change flag to true only when it's already false and non-empty tile is shifted
                    if (!isCompressed) isCompressed = !tiles[i].isEmpty();
                }

                // move empty tile to the end
                // check again this position (in case if 2 empty tiles goes one after another)
                tiles[tiles.length - 1].value = 0;
                i--;
                shifts++;
            }

            // Exit point from eternal loop {0,0,0,0}, {0,0,4,0}...
            if (shifts > tiles.length) break;
        }

        return isCompressed;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isMerged = false;

        // no need to check last tile (it cannot be merged)
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == tiles[i + 1].value && !tiles[i].isEmpty()) {

                // change weight of this tile
                tiles[i].value *= 2;
                score += tiles[i].value;
                maxTile = maxTile > tiles[i].value ? maxTile : tiles[i].value;

                // move all tiles to the left
                for (int j = i + 1; j < tiles.length - 1; j++) {
                    tiles[j].value = tiles[j +1].value;
                }

                // last tile now is empty
                tiles[tiles.length - 1].value = 0;
                isMerged = true;
            }
        }

        return isMerged;
    }

    public void left() {
        boolean isChanged = false;

        if (isSaveNeeded) saveState(gameTiles);

        for (int i = 0; i < gameTiles.length; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) isChanged = true;
        }

        // Flag needed to add tile only once if at least one row was changed
        if (isChanged) addTile();
        isSaveNeeded = true;
    }

    public void right() {
        saveState(gameTiles);
        for (int i = 0; i < 2; i++) {
            gameTiles = rotate();
        }
        left();
        for (int i = 0; i < 2; i++) {
            gameTiles = rotate();
        }
    }

    public void down() {
        saveState(gameTiles);
        for (int i = 0; i < 3; i++) {
            gameTiles = rotate();
        }
        left();
        gameTiles = rotate();
    }

    public void up() {
        saveState(gameTiles);
        gameTiles = rotate();
        left();
        for (int i = 0; i < 3; i++) {
            gameTiles = rotate();
        }
    }

    // rotate counter-clockwise
    private Tile[][] rotate() {
        int w = gameTiles.length;
        int h = gameTiles[0].length;
        Tile[][] rotated = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                rotated[i][j] = gameTiles[j][h - i - 1];
            }
        }

        return rotated;
    }

    public boolean canMove() {
        boolean output = false;

        // if can compress
        if (getEmptyTiles().size() > 0)
            output = true;

        // if can merge horizontally or vertically
        else {
            for (int i = 0; i < gameTiles.length; i++) {
                for (int j = 0; j < gameTiles[0].length; j++) {
                    if ((i < gameTiles.length - 1 && gameTiles[i][j].value == gameTiles[i + 1][j].value) |
                            (j < gameTiles[0].length - 1 && gameTiles[i][j].value == gameTiles[i][j + 1].value)) {
                        output = true;
                        break;
                    }
                }
                if (output) break;
            }
        }

        return output;
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private void saveState(Tile[][] state) {

        // Create instances of fields to save
        Tile[][] gameToSave = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[0].length; j++) {
                gameToSave[i][j] = new Tile(state[i][j].value);
            }
        }
        int scoreToSave = score;

        previousStates.push(gameToSave);
        previousScores.push(scoreToSave);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void randomMove() {
        int rndMove = ((int) (Math.random() * 100) % 4);
        switch (rndMove) {
            case 0: left();     break;
            case 1: right();    break;
            case 2: up();       break;
            case 3: down();     break;
        }
    }
}

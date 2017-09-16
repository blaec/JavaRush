package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

// Contain game logic and save game field
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    public int score = 0;
    public int maxTile = 2;

    public Model() {
        resetGameTiles();
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();

        Tile rndTile = emptyTiles.get((int) (Math.random()*emptyTiles.size()));
        rndTile.value = Math.random() < 0.9 ? 2 : 4;
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

    private void compressTiles(Tile[] tiles) {
        int shifts = 0;

        // no need to check last tile (it cannot be compressed)
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].isEmpty()) {

                // move all tiles to the right
                for (int j = i; j < tiles.length - 1; j++) {
                    tiles[j].value = tiles[j +1].value;
                }

                // move empty tile to the end
                // check again this position (in case if 2 empty tiles goes one after another)
                tiles[tiles.length - 1].value = 0;
                i--;
                shifts++;
            }

            // Exit point from eternal loop {0,0,0,0}
            if (shifts > tiles.length) break;
        }
    }

    private void mergeTiles(Tile[] tiles) {

        // no need to check last tile (it cannot be merged)
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == tiles[i + 1].value && !tiles[i].isEmpty()) {

                // change weight of this tile
                tiles[i].value *= 2;
                score += tiles[i].value;
                maxTile = maxTile > tiles[i].value ? maxTile : tiles[i].value;

                // move all tiles to the right
                for (int j = i + 1; j < tiles.length - 1; j++) {
                    tiles[j].value = tiles[j +1].value;
                }

                // last tile now is empty
                tiles[tiles.length - 1].value = 0;
            }
        }
    }
}

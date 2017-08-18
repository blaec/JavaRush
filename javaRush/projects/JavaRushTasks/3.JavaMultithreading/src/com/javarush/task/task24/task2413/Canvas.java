package com.javarush.task.task24.task2413;

public class Canvas {
    private int height;
    private int width;
    private char[][] matrix;

    // order important for validation
    public Canvas(int width, int height) {
        this.height = height;
        this.width = width;

        // instead of this line can execute clear() method
        matrix = new char[height + 2][ width + 2];
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    // round the double and then cast int
    public void setPoint(double x, double y, char c) {
        int intX = (int) Math.round(x);
        int intY = (int) Math.round(y);
        if (!(intX < 0 || intY < 0 || intX > matrix[0].length || intY > matrix.length)) {
            matrix[intY][intX] = c;
        }
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c) {

        for (int my = 0; my < matrix.length; my++) {
            for (int mx = 0; mx < matrix[my].length; mx++) {
                setPoint(x + mx, y + my, c);
            }
        }
    }

    public void clear() {
        matrix = new char[height + 2][ width + 2];
    }

    public void print() {
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                System.out.print(matrix[y][x]);
            }
            System.out.println();
        }
    }
}

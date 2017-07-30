package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/


public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {
                {0,0,1,1,0,0,1,1,0,1,0},
                {0,0,1,1,0,0,1,1,0,1,1},
                {0,0,1,1,1,1,1,1,0,1,0},
                {0,0,0,1,1,1,1,1,0,1,1},
                {0,0,1,1,1,1,1,1,0,1,0},
                {0,0,0,1,1,1,1,1,0,1,1},
                {0,0,1,1,1,1,1,1,0,1,0},
                {0,0,1,1,0,0,1,1,0,1,0},
                {0,0,1,1,0,0,1,1,0,1,1},
                {0,0,1,1,0,0,1,1,0,1,1}
                };
        Solution solution = new Solution();
        System.out.println(solution.maxSquare(matrix));
    }

    public static int maxSquare(int[][] matrix) {
        int result = 0;

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][col] == 1) {
                    int left = matrix[row][col-1];
                    int top = matrix[row-1][col];
                    int topLeft = matrix[row-1][col-1];

                    matrix[row][col] = Math.min(topLeft, Math.min(left, top)) + 1;

                    result = result > matrix[row][col] ? result : matrix[row][col];
                }
            }
        }

        return result * result;
    }
}

package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        for (Word word: detectAllWords(crossword, "home", "same", "emoh"))
            System.out.println(word.toString());
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        int wordLen = 0;
        List<Word> list = new ArrayList<>();

        for (String word: words) {
            wordLen = word.length() - 1;
            Word seekWord = new Word(word);

            for (int row = 0; row < crossword.length; row++) {
                for (int col = 0; col < crossword[row].length; col++) {
                    if (crossword[row][col] ==  word.charAt(0)) {


                        // top right
                        if ((col + wordLen) <= (crossword[row].length - 1) && (row - wordLen) > 0) {
                            String testWord = tempWord(crossword, row, col, wordLen,-1,1);
                            if (word.equals(testWord)) {
                                seekWord.setStartPoint(col, row);
                                seekWord.setEndPoint(col + wordLen, row - wordLen);

                            }
                        }

                        // right
                        if ((col + wordLen) <= (crossword[row].length) - 1) {
                            String testWord = tempWord(crossword, row, col, wordLen,0,1);
                            if (word.equals(testWord)) {
                                seekWord.setStartPoint(col, row);
                                seekWord.setEndPoint(col + wordLen, row);
                            }
                        }

                        // bottom right
                        if ((col + wordLen) <= (crossword[row].length - 1) && (row + wordLen) <= (crossword.length - 1)) {
                            String testWord = tempWord(crossword, row, col, wordLen,1,1);
                            if (word.equals(testWord)) {
                                seekWord.setStartPoint(col, row);
                                seekWord.setEndPoint(col + wordLen, row + wordLen);
                            }
                        }

                        // bottom
                        if ((row + wordLen) <= (crossword.length - 1)) {
                            String testWord = tempWord(crossword, row, col, wordLen,1,0);
                            if (word.equals(testWord)) {
                                seekWord.setStartPoint(col, row);
                                seekWord.setEndPoint(col, row + wordLen);
                            }
                        }

                        // bottom left
                        if ((col - wordLen) >= 0 && (row + wordLen) <= (crossword.length - 1)) {
                            String testWord = tempWord(crossword, row, col, wordLen,1,-1);
                            if (word.equals(testWord)) {
                                seekWord.setStartPoint(col, row);
                                seekWord.setEndPoint(col - wordLen, row + wordLen);
                            }
                        }

                        // left
                        if ((col - wordLen)>= 0) {
                            String testWord = tempWord(crossword, row, col, wordLen,0,-1);
                            if (word.equals(testWord)) {
                                seekWord.setStartPoint(col, row);
                                seekWord.setEndPoint(col - wordLen, row);
                            }
                        }

                        // top left
                        if ((col - wordLen) >= 0 && (row - wordLen) >= 0) {
                            String testWord = tempWord(crossword, row, col, wordLen,-1,-1);
                            if (word.equals(testWord)) {
                                seekWord.setStartPoint(col, row);
                                seekWord.setEndPoint(col - wordLen, row - wordLen);
                            }
                        }

                        //  top
                        if ((row - wordLen) >= 0) {
                            String testWord = tempWord(crossword, row, col, wordLen,-1,0);
                            if (word.equals(testWord)) {
                                seekWord.setStartPoint(col, row);
                                seekWord.setEndPoint(col, row - wordLen);
                            }
                        }
                    }
                }
            }
            list.add(seekWord);
        }

        return list;
    }


    private static String tempWord(int[][] crossword,int row, int col, int len, int rdir, int rcol) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= len; i++) {
            sb.append((char)crossword[row + i*rdir][col + i*rcol]);
        }
        return sb.toString();
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}

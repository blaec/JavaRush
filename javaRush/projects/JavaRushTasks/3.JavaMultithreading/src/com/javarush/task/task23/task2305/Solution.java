package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] output = new Solution[2];

        for (int i = 0; i < 2; i++) {
            output[i] = new Solution();
            output[i].innerClasses[0] = output[i].new InnerClass();
            output[i].innerClasses[1] = output[i].new InnerClass();
        }

        return output;
    }

    public static void main(String[] args) {

    }
}

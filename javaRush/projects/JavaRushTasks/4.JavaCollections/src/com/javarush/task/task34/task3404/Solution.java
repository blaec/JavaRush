package com.javarush.task.task34.task3404;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.Locale;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
    }

    public void recursion(final String expression, int countOperation) {
        //implement
        Locale.setDefault(Locale.ENGLISH);
        String value = expression.replaceAll(" ", "");

        int currentCountOperation = countOperation + 1;
        int curPosition = 0;    // 0 - outside; <0 - inside parentheses; >0 - impossible, means expression's wrong
        int order1 = -1;
        int order2 = -1;
        int order3 = -1;
        char[] s = value.toCharArray();

        /**
         * Iterate the string backwards and get math operation order
         * ^ -      higher order [3]
         * * or / - lower order [2]
         * + or - - lowest order [1]
         *
         * update current position: inside or outside the parentheses
         */
        for (int i = s.length - 1; i >= 0; i--) {
            switch (s[i]) {
                case '^':
                    if (curPosition == 0 && order3 == -1) order3 = i;
                    break;
                case '*':
                case '/':
                    if (curPosition == 0 && order2 == -1) order2 = i;
                    break;
                case '+':
                case '-':
                    if (curPosition == 0 && order1 == -1) order1 = i;
                    break;
                case '(':
                    curPosition++;
                    break;
                case ')':
                    curPosition--;
                    break;
            }
        }

        // "Break" the expression by lowest order operation: because this operation should be done in the end
        if (order1 != -1) order2 = order1;
        if (order2 != -1) order3 = order2;
        if (order3 != -1) {

            // Replace System.out
            PrintStream oldStream = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream newStream = new PrintStream(outputStream);
            System.setOut(newStream);

            // Process left part expression
            recursion(value.substring(0, order3), currentCountOperation);
            String[] leftExpr = splitStream(outputStream);
            currentCountOperation = restoreCurrentCountOperation(currentCountOperation, leftExpr);

            outputStream.reset();

            // Process right part expression
            recursion(value.substring(order3 + 1), currentCountOperation);
            String[] rightExpr = splitStream(outputStream);
            currentCountOperation = restoreCurrentCountOperation(currentCountOperation, rightExpr);

            System.setOut(oldStream);

            // Print the operation between left and right expressions
            switch (s[order3]) {
                case '^':
                    customPrint(Math.pow(Double.parseDouble(leftExpr[0]), Double.parseDouble(rightExpr[0])), currentCountOperation);
                    return;
                case '*':
                    customPrint(Double.parseDouble(leftExpr[0]) * Double.parseDouble(rightExpr[0]), currentCountOperation);
                    return;
                case '/':
                    customPrint(Double.parseDouble(leftExpr[0]) / Double.parseDouble(rightExpr[0]), currentCountOperation);
                    return;
                case '+':
                    customPrint(Double.parseDouble(leftExpr[0]) + Double.parseDouble(rightExpr[0]), currentCountOperation);
                    return;
                case '-':
                    customPrint(Double.parseDouble(leftExpr[0]) - Double.parseDouble(rightExpr[0]), currentCountOperation);
                    return;
            }
        }

        // If expression not empty and enclosed with parentheses, then remove them and process expression
        if (s.length > 0 && s[0] == '(' && s[s.length - 1] == ')') {
            recursion(value.substring(1, s.length - 1), countOperation);
            return;
        }

        /**
         * if it's math functions: sin, cos...
         * RegEx - equivalent: 3 letters + ( + any expression with at least 1 char + )
        */
        if (expression.matches("[a-zA-Z]{3}\\(.+\\)")) {
//        if (s.length > 5 && Character.isAlphabetic(s[0]) && s[3] == '(' && s[s.length - 1] == ')') {

            // Store math function
            String funcName = value.substring(0, 3);

            // Replace System.out
            PrintStream oldStream = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream newStream = new PrintStream(outputStream);
            System.setOut(newStream);

            // process expression striped from math function and parentheses
            recursion(value.substring(4, s.length - 1), currentCountOperation);
            String[] part = splitStream(outputStream);
            currentCountOperation = restoreCurrentCountOperation(currentCountOperation, part);

            System.setOut(oldStream);

            if ("sin".equals(funcName)) {
                customPrint(Math.sin(Math.toRadians(Double.parseDouble(part[0]))), currentCountOperation);
                return;
            }
            if ("cos".equals(funcName)) {
                customPrint(Math.cos(Math.toRadians(Double.parseDouble(part[0]))), currentCountOperation);
                return;
            }
            if ("tan".equals(funcName)) {
                customPrint(Math.tan(Math.toRadians(Double.parseDouble(part[0]))), currentCountOperation);
                return;
            }
        }

        customPrint(parseDouble(s), countOperation);
    }


    // Used to pass data to recursive functions (when System.out is replaced
    // and prints to console final result, when System.out - restored
    private void customPrint(double v, int currentCountOperation) {
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println(df.format(v) + " " + currentCountOperation);
    }


    // Split the expression printed to replaced System.out
    private String[] splitStream(ByteArrayOutputStream outputStream) {
        return outputStream.toString().split("\\s");
    }


    // get current count operation from expression extracted from outputStream
    private int restoreCurrentCountOperation(int currentCountOperation, String[] expression) {
        return currentCountOperation < Integer.parseInt(expression[1]) ? Integer.parseInt(expression[1]) : currentCountOperation;
    }


    // Convert potential value into double, this value should contain digits and .
    private double parseDouble(char[] s) {
        double n = 0d;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length && (Character.isDigit(s[i]) || s[i] == '.'); i++) {
            sb.append(s[i]);
        }
        if (sb.length() > 0) {
            n = Double.parseDouble(sb.toString());
        }

        return n;
    }


    public Solution() {
        //don't delete
    }
}

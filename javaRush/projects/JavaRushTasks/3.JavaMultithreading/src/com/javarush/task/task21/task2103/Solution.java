package com.javarush.task.task21.task2103;

/* 
Все гениальное - просто!
*/
public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        /*
        * http://info.javarush.ru/JavaRush_tasks_discussion/2014/04/10/package-com-javarush-test-level21-lesson02-task03-.html
        * (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
        * c && (a && b && !d) || !a || !b || d
        */
        return c;

    }

    public static void main(String[] args) {
    }
}



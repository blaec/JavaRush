package com.javarush.task.task09.task0906;

/* 
Логирование стек трейса
*/

import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        //напишите тут ваш код
        /*
        //com.javarush.task.task09.task0906.Solution: main: In main method
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        System.out.println(ste[2].getClassName() + ": " + ste[2].getMethodName() + ": " +  s);
        System.out.println();
        printStack(ste);
        */
        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        for(Thread t : map.keySet())
        {
            StackTraceElement[] frames = map.get(t);

        }

    }

    public static void printStack (StackTraceElement[] st)
    {
        System.out.println("Текущий метод: " + st[1].getMethodName());
        System.out.println("Размер стека элементов: "+st.length);
        System.out.println("Содержание стека:");
        for (int i =0; i < st.length;i++)
        {
            System.out.println("Индекс элемента: "+i+", значение элемента: "+st[i].getMethodName());
        }
        System.out.println("===============================");
        System.out.println("");
    }

}

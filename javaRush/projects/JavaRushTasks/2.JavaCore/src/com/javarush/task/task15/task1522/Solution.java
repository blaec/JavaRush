package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем Singleton pattern
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        Solution.readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = reader.readLine();
            if (line.equals(thePlanet.SUN))
                thePlanet = new Sun();
            else if (line.equals(thePlanet.MOON))
                thePlanet = new Moon();
            else if (line.equals(thePlanet.EARTH))
                thePlanet = new Earth();
            else
                thePlanet = null;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

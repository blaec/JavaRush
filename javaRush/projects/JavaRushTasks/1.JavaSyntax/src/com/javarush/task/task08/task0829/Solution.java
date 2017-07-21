package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        HashMap<String, String> addresses = new HashMap<>();
        String town = "";
        while (true) {
            //System.out.print("Add town: ");
            town = reader.readLine();
            if (town.isEmpty()) break;
            //System.out.print("Who lives in tows(" + town + "): ");
            String family = reader.readLine();

            addresses.put(town,family);
        }

        //read home number
        //System.out.print("Town: ");
        town = reader.readLine();

        if (!town.isEmpty()) {
            String familySecondName = addresses.get(town);
            System.out.println(familySecondName);
        }
    }
}

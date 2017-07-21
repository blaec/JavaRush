package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader file = new BufferedReader(new FileReader(args[0]));
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        while (file.ready()) {
            String[] line = file.readLine().split(" ");
            StringBuilder name = new StringBuilder();
            StringBuilder date = new StringBuilder();
            for (int i = 0; i < line.length; i++) {
                if (i < line.length -3)
                    name.append(line[i]);
                else
                    date.append(line[i]);

                if (i < line.length - 4)
                    name.append(" ");
                if (i != line.length-1 && i > line.length - 4)
                    date.append("/");
            }

            PEOPLE.add(new Person(name.toString(), df.parse(date.toString())));
        }

        file.close();

    }
}

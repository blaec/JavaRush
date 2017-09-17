package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
https://www.mkyong.com/java/java-properties-file-examples/
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();

            try (InputStream stream = new FileInputStream(fileName)) {
                load(stream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();

        for (String key : properties.keySet()) {
            prop.setProperty(key, properties.get(key));
        }

        prop.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);

        Enumeration<?> e = prop.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String)e.nextElement();
            String value = prop.getProperty(key);

            properties.put(key, value);
        }
    }

    public static void main(String[] args) {

    }
}

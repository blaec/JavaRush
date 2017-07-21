package com.javarush.task.task31.task3109;

import java.io.*;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("C:\\Users\\blaec\\Google Drive\\Java\\javaRush\\projects\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task31\\task3109\\properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("C:\\Users\\blaec\\Google Drive\\Java\\javaRush\\projects\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task31\\task3109\\properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        File file = new File(fileName);
        Properties properties = new Properties();
        try {
            if (fileName.endsWith("xml")) {
                properties.loadFromXML(new FileInputStream(file)) ;
            }
            else {
                properties.load(new FileReader(file));
            }
        } catch (IOException e) {
            properties = new Properties();
        }
        return properties;
    }
}

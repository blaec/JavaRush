package com.javarush.task.task35.task3507;

import java.io.*;
import java.lang.reflect.Constructor;
import java.nio.file.*;
import java.util.*;

/*
ClassLoader - что это такое?
http://java-online.ru/java-classloader.xhtml
https://docs.oracle.com/javase/7/docs/api/java/lang/ClassLoader.html
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() +
                Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");

        System.out.println(allAnimals);
    }

    /**
     * Accepted but not working
     * new File(pathToAnimals).listFiles() - returns empty array (pathToAnimals - wrong path)
     *
     * if (file.isFile() && file.getName().endsWith(".class")) - package's missing compiled classes, all with ext. .java
     */
    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> set = new HashSet<>();

        File[] list = new File(pathToAnimals).listFiles();
        for (File file : list) {
            if (file.isFile() && file.getName().endsWith(".class")) {

                String packageName = Solution.class.getPackage().getName() + ".data"; //some bed solution (Hardcore data)
                Class clazz = new ClassFromPath().load(file.toPath(), packageName); //Loading class from path

                int score = 0;
                //find interface Animal
                Class[] interfaces = clazz.getInterfaces();
                for (Class interf : interfaces)
                    if (interf.getSimpleName().equals("Animal")) {
                        score++;
                        break;
                    }

                //Find default constuctor
                Constructor[] constructors = clazz.getConstructors();
                for (Constructor constructor : constructors)
                    if (constructor.getParameterCount() == 0) {
                        score++;
                    }

                //if all ok, add to set
                if (score == 2)
                    try {
                        Animal animal = (Animal) clazz.newInstance();
                        set.add(animal);
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
            }
        }

        return set;
    }

    public static class ClassFromPath extends ClassLoader {
        public Class<?> load(Path path, String packageName) {
            try {
                String className = packageName + "." + path.getFileName().toString().replace(".class", "");
                byte[] b = Files.readAllBytes(path);
                return defineClass(className, b, 0, b.length); //here main magic
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
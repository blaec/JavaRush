package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args)  {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {

        // Loop though all collection classes: System.out.println("Collection name: " + clazz.getName())
        /*
         * getDeclaredClasses:
         * Returns an array of {@code Class} objects reflecting all the
         * classes and interfaces declared as members of the class represented by
         * this {@code Class} object. This includes public, protected, default
         * (package) access, and private classes and interfaces declared by the
         * class, but excludes inherited classes and interfaces.  This method
         * returns an array of length 0 if the class declares no classes or
         * interfaces as members, or if this {@code Class} object represents a
         * primitive type, an array class, or void.
        */
        for (Class cls : Collections.class.getDeclaredClasses()) {

            /*
             * Determines if the class or interface represented by this
             * {@code Class} object is either the same as, or is a superclass or
             * superinterface of, the class or interface represented by the specified
             * {@code Class} parameter. It returns {@code true} if so;
             * otherwise it returns {@code false}. If this {@code Class}
             * object represents a primitive type, this method returns
             * {@code true} if the specified {@code Class} parameter is
             * exactly this {@code Class} object; otherwise it returns
             * {@code false}.
             */
            // and its modifiers are Private and Static
            if (List.class.isAssignableFrom(cls)
                    && Modifier.isPrivate(cls.getModifiers())
                    && Modifier.isStatic(cls.getModifiers())) {
                try {

                    // Для внутренних закрытых классов нужно получить их конструктор
                    Class clazz = Solution.class.getClassLoader().loadClass(cls.getName());
                    Constructor constructor = clazz.getDeclaredConstructor();

                    // сделать его доступным
                    constructor.setAccessible(true);

                    // и, затем, из него инстанцировать объект
                    List list = (List) constructor.newInstance();
                    try {
                        list.get(0);
                    } catch (IndexOutOfBoundsException e) {
                        return cls;
                    }
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                }
            }
        }

        return null;
    }
}

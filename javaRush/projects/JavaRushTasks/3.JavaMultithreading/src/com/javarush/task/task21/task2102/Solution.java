package com.javarush.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* 
Сравниваем модификаторы
*/
public class Solution {
    public static void main(String[] args) {
        int modifiersOfThisClass = Solution.class.getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.PUBLIC));   //true
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.STATIC));   //false

        int modifiersOfMethod = getMainMethod().getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfMethod, Modifier.STATIC));      //true
    }

    /*
    * from Modifier class:
    * --------------------------------------------------------
    * public static final int PUBLIC           = 0x00000001; |
    * public static final int PRIVATE          = 0x00000002; |
    * public static final int PROTECTED        = 0x00000004; |
    * public static final int STATIC           = 0x00000008; |
    * public static final int FINAL            = 0x00000010; |
    * public static final int SYNCHRONIZED     = 0x00000020; |
    * public static final int VOLATILE         = 0x00000040; |
    * public static final int TRANSIENT        = 0x00000080; |
    * public static final int NATIVE           = 0x00000100; |
    * public static final int INTERFACE        = 0x00000200; |
    * public static final int ABSTRACT         = 0x00000400; |
    * public static final int STRICT           = 0x00000800; |
    * --------------------------------------------------------
    * while allModifiers - represents sum of bites,
    * and with logic AND one can check if this sum contains specific bit
    * when specificModifier serves as bit-mask
    */
    public static boolean isAllModifiersContainSpecificModifier(int allModifiers, int specificModifier) {
        return (allModifiers & specificModifier) == specificModifier;
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}

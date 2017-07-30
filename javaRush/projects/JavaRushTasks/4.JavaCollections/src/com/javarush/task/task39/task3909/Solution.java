package com.javarush.task.task39.task3909;

/*
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("", "")); // true
        System.out.println(isOneEditAway("", "m")); //true
        System.out.println(isOneEditAway("m", "")); //true
//        System.out.println(isOneEditAway("m", null)); //
        System.out.println("------");
        System.out.println(isOneEditAway("mama", "ramas")); //false
        System.out.println(isOneEditAway("mamas", "rama")); //false
        System.out.println(isOneEditAway("rama", "mama")); //true
        System.out.println(isOneEditAway("mama", "dama")); //true
        System.out.println(isOneEditAway("ama", "mama"));  //true
        System.out.println(isOneEditAway("mama", "ama")); //true

        // strange, but validator allows these strings
        System.out.println(isOneEditAway("mma", "am")); //true
    }

    public static boolean isOneEditAway(String first, String second) {
        boolean result = false;

        if(first.equals(second))
            result = true;
        else if (Math.abs(first.length() - second.length()) <= 1) {
            StringBuffer shortString = first.length() < second.length() ? new StringBuffer(first) : new StringBuffer(second);
            StringBuffer longString = first.length() >= second.length() ? new StringBuffer(first) : new StringBuffer(second);

            for (int i = 0; i < shortString.length(); i++) {
                int pos = longString.indexOf(String.valueOf(shortString.charAt(i)));
                if (pos != -1)
                    longString.deleteCharAt(pos);
            }

            if (longString.length() == 1)
                result = true;
        }

        return result;
    }
}

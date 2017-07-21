package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        Map<String, String> people = new HashMap<>();
        people.put("aa","abc");
        people.put("bb","abc");
        people.put("bb","bcd");
        people.put("cc","bcd");
        people.put("dd","cde");
        people.put("dd","def");
        people.put("ee","def");
        people.put("ff","efg");
        people.put("gg","ghi");
        people.put("hh","hij");

        return people;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}

package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> hm = new HashMap<>();
        hm.put("Арбузов","Еж");
        hm.put("Борисов","Вобл");
        hm.put("Борщов","Борщ");
        hm.put("Воблов","Вобл");
        hm.put("Гудков","Гудок");
        hm.put("Дятлов","Лятел");
        hm.put("Егоров","Егор");
        hm.put("Егерев","Егерь");
        hm.put("Ежов","Еж");
        hm.put("Яблоков","Перс");
        return hm;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count=0;
        for(Map.Entry<String, String> entry : map.entrySet()) {
            String firstName = entry.getValue();
            if (firstName.equals(name))
                count++;
        }
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int count=0;
        for(Map.Entry<String, String> entry : map.entrySet()) {
            String name = entry.getKey();
            if (name.equals(lastName))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
    }
}

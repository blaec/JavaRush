package com.javarush.task.task33.task3310;

import com.fasterxml.jackson.databind.node.ShortNode;
import com.javarush.task.task33.task3310.strategy.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by blaec on 14\07\17.
 */
public class Solution {
    public static void main(String[] args) {
        testStrategy(new DualHashBidiMapStorageStrategy(), 500000);
    }

    // 6.1. return set of ids for corresponding set of strings
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> ids = new HashSet<>();

        for (String string : strings) {
            ids.add(shortener.getId(string));
        }
        return ids;
    }

    // 6.2. return set of strings for corresponding set of ids
    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> strings = new HashSet<>();

        for (Long key : keys) {
            strings.add(shortener.getString(key));
        }
        return strings;
    }

    // tests current strategy with sent number of elements
    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {

        // 6.3. Strategy class name
        System.out.println(strategy.toString());

        // 6.4. Set of elementNumber randome strings
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            strings.add(Helper.generateRandomString());
        }

        // 6.5. Shortener object
        Shortener shortener = new Shortener(strategy);

        // 6.6. getIds & getStrings
        Date date = new Date();
        Set<Long> ids = getIds(shortener, strings);
        System.out.println((new Date()).getTime() - date.getTime());

        date = new Date();
        Set<String> outputStrings = getStrings(shortener, ids);
        System.out.println((new Date()).getTime() - date.getTime());

        // 6.7. Compare strings sets
        String compareMsg = "Тест не пройден.";
        if (strings.size() == outputStrings.size()) {
            compareMsg = "Тест пройден.";
        }
        System.out.println(compareMsg);
    }
}

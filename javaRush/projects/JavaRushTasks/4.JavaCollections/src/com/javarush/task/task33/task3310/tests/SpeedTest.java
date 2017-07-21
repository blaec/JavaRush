package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by blaec on 15\07\17.
 */
public class SpeedTest {

    // 15.2 get ids from strings' Set, put ids to Set<Long>
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date date = new Date();

        for (String string : strings) {
            ids.add(shortener.getId(string));
        }

        return (new Date()).getTime() - date.getTime();
    }

    // 15.3 get strings from ids' Set, put these strings to Set<String>
    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date date = new Date();

        for (Long key : ids) {
            strings.add(shortener.getString(key));
        }

        return (new Date()).getTime() - date.getTime();
    }

    // 15.4 compare 2 strategies
    @Test
    public void testHashMapStorage() {

        // ..1 Create 2 Shortner objects
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        // ..2 Populate Set<String> with 10K rnd strings [via Helper]
        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        // ..3 Get time for retrieving ids
        Set<Long> ids1 = new HashSet<>();
        long idTime1 = getTimeForGettingIds(shortener1, origStrings, ids1);
        Set<Long> ids2 = new HashSet<>();
        long idTime2 = getTimeForGettingIds(shortener2, origStrings, ids2);

        // ..4 Compare time
        Assert.assertTrue(idTime1 > idTime2);

        // ..5 Get time for retrieving strings
        long stTime1 = getTimeForGettingStrings(shortener1, ids1, new HashSet<String>());
        long stTime2 = getTimeForGettingStrings(shortener2, ids2, new HashSet<String>());

        // ..6 Compare time
        Assert.assertEquals(stTime1, stTime2, 30);
    }
}


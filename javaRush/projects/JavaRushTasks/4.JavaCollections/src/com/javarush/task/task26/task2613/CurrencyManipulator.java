package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;
import org.omg.CORBA.INTERNAL;

import java.util.*;

/*
    String currencyCode                 — код валюты, например, USD. Состоит из трех букв.
    Map<Integer, Integer> denominations — это Map<номинал, количество>.
 */

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        int updatedCount = count;

        if (denominations.containsKey(denomination))
            updatedCount = denominations.get(denomination) + count;

        denominations.put(denomination, updatedCount);
    }

    public int getTotalAmount() {
        int total = 0;

        Iterator it = denominations.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            total += (int)(pair.getKey()) * (int)(pair.getValue());
        }

        return total;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return expectedAmount >= getTotalAmount();
    }

    public boolean hasMoney() {
        return denominations.size() != 0;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        Map<Integer, Integer> output = new HashMap<>();

        // sort the denominators
        Map<Integer, Integer> sorted = new TreeMap<>(Collections.reverseOrder());
        sorted.putAll(denominations);

        // try to withdraw
        Iterator it = sorted.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            int key = (int)pair.getKey();
            int value = (int)pair.getValue();

            if (expectedAmount >= key) {
                int count = expectedAmount/key;
                count = Math.min(count, value);
                expectedAmount -= count * key;
                output.put(key, count);
            }
        }

        // if failed to withdraw exact expected amount - raise error
        if (expectedAmount > 0)throw new NotEnoughMoneyException();

        return output;
    }
}

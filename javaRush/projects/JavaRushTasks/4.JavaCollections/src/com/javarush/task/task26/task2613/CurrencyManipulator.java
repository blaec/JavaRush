package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

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
        return 0;
    }
}

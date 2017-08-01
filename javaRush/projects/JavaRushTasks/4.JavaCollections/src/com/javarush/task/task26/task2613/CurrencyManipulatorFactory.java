package com.javarush.task.task26.task2613;

import java.util.*;

public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    private CurrencyManipulatorFactory() {}

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        String upperCode = currencyCode.toUpperCase();

        if (!map.containsKey(upperCode)) {
            map.put(upperCode, new CurrencyManipulator(upperCode));
        }

        return map.get(upperCode);
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return map.values();
    }
}

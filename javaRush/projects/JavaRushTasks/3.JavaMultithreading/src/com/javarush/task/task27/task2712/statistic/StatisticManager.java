package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {}

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }


    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage;

        public StatisticStorage() {
            storage = new HashMap<>();
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<>());
            }
        }

        private void put(EventDataRow data) {
            EventType key = data.getType();
            List<EventDataRow> value = storage.get(key);
            value.add(data);
            storage.put(key, value);
        }
    }
}

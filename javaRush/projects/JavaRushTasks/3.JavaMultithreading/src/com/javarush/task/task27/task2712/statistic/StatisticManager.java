package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {}

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public void register(Cook cook) {
        cooks.add(cook);
    }

    public Map<Date, Double> getVideoDailyProfit() {
        Map<Date, Double> ads = new TreeMap<>(Collections.reverseOrder());

        List<EventDataRow> videos = statisticStorage.get(EventType.SELECTED_VIDEOS);
        for (EventDataRow video : videos) {
            VideoSelectedEventDataRow nextVideo = (VideoSelectedEventDataRow) video;
            Date date = getDateWithoutTime(nextVideo.getDate());
            double newValue = 0.01d * (double)nextVideo.getAmount();
            double value = newValue;

            if (ads.containsKey(date)) {
                value = ads.get(date) + newValue;
            }
            ads.put(date, value);
        }

        return ads;
    }

    private Date getDateWithoutTime(Date input) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date output = null;

        try {
            output = formatter.parse(formatter.format(input));
        } catch (ParseException e) {}

        return output;
    }

    public Map<Date, Map<String, Integer>> getCookTime() {
        Map<Date, Map<String, Integer>> dateMap = new TreeMap<>(Collections.reverseOrder());


        List<EventDataRow> orders = statisticStorage.get(EventType.COOKED_ORDER);
        for (EventDataRow order : orders) {
            Map<String, Integer> cookMap = new TreeMap<>();
            CookedOrderEventDataRow nextOrder = (CookedOrderEventDataRow) order;
            Date date = getDateWithoutTime(nextOrder.getDate());
            int time = roundTime(nextOrder.getTime());
            int value = time;
            String cook = nextOrder.getCookName();

            if (dateMap.containsKey(date)) {
                cookMap = dateMap.get(date);

                if (cookMap.containsKey(cook)) {
                    value = cookMap.get(cook) + time;
                }
            }
            cookMap.put(cook, value);
            dateMap.put(date, cookMap);
        }

        return dateMap;
    }

    private int roundTime(int time) {
        int output = 0;

        if (time != 0)
            output = (time % 60 == 0) ? time / 60 : time / 60 + 1;

        return output;
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

        private List<EventDataRow> get(EventType key) {
            return storage.get(key);
        }
    }
}

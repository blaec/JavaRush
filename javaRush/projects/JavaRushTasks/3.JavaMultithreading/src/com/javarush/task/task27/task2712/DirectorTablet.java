package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class DirectorTablet {
    DateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public void printAdvertisementProfit() {
        Map<Date, Double> data = StatisticManager.getInstance().getVideoDailyProfit();
        double total = 0;

        for (Date date : data.keySet()) {
            double profit = data.get(date);
            total += profit;

            ConsoleHelper.writeMessage(String.format("%s - %.2f", df.format(date), profit));
        }
        if (total > 0) ConsoleHelper.writeMessage(String.format("Total - %.2f", total));
    }

    public void printCookWorkloading() {
        Map<Date, Map<String, Integer>> data = StatisticManager.getInstance().getCookTime();

        for (Date date : data.keySet()) {
            Map<String, Integer> cooks = data.get(date);

            ConsoleHelper.writeMessage(df.format(date));
            for (String cook : cooks.keySet()) {
                int time = cooks.get(cook);

                if (time > 0) ConsoleHelper.writeMessage(String.format("%s - %d min",cook, time));
            }

        }
    }

    public void printActiveVideoSet() {}
    public void printArchivedVideoSet() {}
}

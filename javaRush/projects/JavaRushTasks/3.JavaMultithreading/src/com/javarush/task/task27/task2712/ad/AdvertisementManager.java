package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos(){
        List<Advertisement> ads = storage.list();
        Collections.sort(ads, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
                if (result != 0) return -result;

                long secCost1 = 1000 * o1.getAmountPerOneDisplaying() / o1.getDuration();
                long secCost2 = 1000 * o2.getAmountPerOneDisplaying() / o2.getDuration();

                return Long.compare(secCost1, secCost2);
            }
        });

        // Calculate stats
        List<Advertisement> displayAds = new ArrayList<>();
        int adsTime = 0;
        long adsCost = 0;
        for (Advertisement ad : ads) {
            if (timeSeconds < ad.getDuration()) {
                continue;
            }

            displayAds.add(ad);
            adsTime += ad.getDuration();
            adsCost += ad.getAmountPerOneDisplaying();
        }

        // register video selected event
        VideoSelectedEventDataRow videoSelected = new VideoSelectedEventDataRow(ads, adsCost, adsTime);
        StatisticManager.getInstance().register(videoSelected);

        // display video
        for (Advertisement ad : displayAds) {

            long secCost = 1000 * ad.getAmountPerOneDisplaying() / ad.getDuration();
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", ad.getName(),
                                                                                   ad.getAmountPerOneDisplaying(),
                                                                                   secCost));

            ad.revalidate();
        }

        if (adsTime == timeSeconds) {
            throw new NoVideoAvailableException();
        }
    }

}

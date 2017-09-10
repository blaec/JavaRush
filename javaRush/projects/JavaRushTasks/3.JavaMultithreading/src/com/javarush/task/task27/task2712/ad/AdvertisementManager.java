package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

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

        int adsTime = timeSeconds;
        for (Advertisement ad : ads) {
            if (adsTime < ad.getDuration()) {
                continue;
            }

            long secCost = 1000 * ad.getAmountPerOneDisplaying() / ad.getDuration();
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", ad.getName(),
                                                                                   ad.getAmountPerOneDisplaying(),
                                                                                   secCost));

            adsTime -= ad.getDuration();
            ad.revalidate();
        }

        if (adsTime == timeSeconds) {
            throw new NoVideoAvailableException();
        }
    }

}

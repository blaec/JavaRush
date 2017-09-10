package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        // get list of available videos [max profit]
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        }
        /** Display all ads to display sorted by
         * 1st key: video cost (descending) [50 - 50 cents)
         * 2nd key: cost of 1 sec (ascending) [277 - 0.277 cent]
         * like
         * First Video is displaying... 50, 277
         */
    }
}

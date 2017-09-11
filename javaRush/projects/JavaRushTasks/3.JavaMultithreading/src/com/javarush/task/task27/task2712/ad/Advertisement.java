package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private Object content;                 // video
    private String name;                    // caption
    private long initialAmount;             // ad cost in cents
    private int hits;                       // qty of paid displays
    private int duration;                   // durations in secs
    private long amountPerOneDisplaying;    // single ad cost in cents

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying = initialAmount / hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void revalidate() {
        if (hits == 0) {
            throw new UnsupportedOperationException();
        }
        hits--;
    }

}

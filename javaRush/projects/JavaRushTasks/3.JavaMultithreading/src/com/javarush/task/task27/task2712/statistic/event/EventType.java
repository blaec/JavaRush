package com.javarush.task.task27.task2712.statistic.event;

public enum EventType {
    COOKED_ORDER,           // cook completed the order
    SELECTED_VIDEOS,        // list of video is ready for the order
    NO_AVAILABLE_VIDEO;     // not a single video to display while preparing the order
}

package com.javarush.task.task36.task3601;

import java.util.List;

/**
 * Created by blaec on 09\07\17.
 */
public class Model {
    public List<String> getStringDataList() {
        return new Service().getData();
    }
}

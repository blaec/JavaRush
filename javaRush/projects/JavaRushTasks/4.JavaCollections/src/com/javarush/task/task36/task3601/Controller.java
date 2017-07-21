package com.javarush.task.task36.task3601;

import java.util.List;

/**
 * Created by blaec on 09\07\17.
 */
public class Controller {

    public List<String> onDataListShow() {
        return new Model().getStringDataList();
    }
}

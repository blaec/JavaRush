package com.javarush.task.task36.task3601;

/**
 * Created by blaec on 09\07\17.
 */
public class View {
    public void fireEventShowData() {
        System.out.println(new Controller().onDataListShow());
    }
}

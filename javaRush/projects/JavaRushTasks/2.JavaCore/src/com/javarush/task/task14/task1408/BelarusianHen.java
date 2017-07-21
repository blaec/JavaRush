package com.javarush.task.task14.task1408;

/**
 * Created by blaec on 23\05\17.
 */

public class BelarusianHen extends Hen{
    @Override
    int getCountOfEggsPerMonth() { return 11; }

    String getDescription() {
        String country = Country.BELARUS;
        String description = " Моя страна - Sssss. Я несу N яиц в месяц.";
        String result = (description.replace("Sssss", country)).replace("N", this.getCountOfEggsPerMonth()+"");

        return super.getDescription() + result;
    }
}

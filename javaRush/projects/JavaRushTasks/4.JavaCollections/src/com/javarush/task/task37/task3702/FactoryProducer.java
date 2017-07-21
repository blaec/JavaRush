package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

/**
 * Created by blaec on 09\07\17.
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(HumanFactoryType hft) {
        switch (hft) {
            case MALE:
                return new MaleFactory();
            case FEMALE:
                return new FemaleFactory();
        }
        return null;
    }

    public enum HumanFactoryType {
        MALE, FEMALE;
    }

}

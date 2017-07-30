package com.javarush.task.task39.task3906;

/* 
Интерфейсы нас спасут!
*/
public class Solution {
    public static void main(String[] args) {
//        SecuritySystem securitySystem = new SecuritySystem();
        Switchable securitySystem = new SecuritySystem();
        ElectricPowerSwitch electricPowerSwitch = new ElectricPowerSwitch(securitySystem);

        electricPowerSwitch.press();
        electricPowerSwitch.press();


        Switchable lightBulb = new LightBulb();
        ElectricPowerSwitch electricLightBulb = new ElectricPowerSwitch(lightBulb);

        electricLightBulb.press();
        electricLightBulb.press();
    }
}

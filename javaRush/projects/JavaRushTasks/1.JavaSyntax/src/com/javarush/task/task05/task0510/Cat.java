package com.javarush.task.task05.task0510;/*
/*
Кошкоинициация
*/

public class Cat {
    String name;
    int weight;
    int age;
    String color;
    String address;

    public void initialize(String name){
        this.name = name;
        weight = 3;
        age = 10;
        color = "grey";
    }
    public void initialize(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        color = "white";
    }
    public void initialize(String name, int age){
        this.name = name;
        this.age = age;
        weight = 3;
        color = "ginger";
    }
    public void initialize(int weight, String color){
        this.weight = weight;
        this.color = color;
        age = 7;
    }
    public void initialize(int weight, String color , String address){
        this.weight = weight;
        this.color = color;
        this.address = address;
        age = 5;
    }

    public static void main(String[] args) {

    }
}
package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        int point = 0;

        if (this.age >= anotherCat.age)
            point += 1;

        if (this.weight >= anotherCat.weight)
            point +=1;

        if (this.strength >= anotherCat.strength)
            point += 1;

        if (point >= 2)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

    }
}

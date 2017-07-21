package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String firstName;
        private String lastName;
        private String address;
        private int age;
        private int weight;
        private boolean sex;

        public Human(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
            address = "Home";
            age=10;
            weight = 30;
            sex = true;
        }

        public Human(String firstName, String lastName, String address, int age, int weight, boolean sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.age = age;
            this.weight = weight;
            this.sex = sex;
        }

        public Human(String firstName, String lastName, String address) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            age=10;
            weight = 30;
            sex = true;
        }

        public Human(String firstName, String lastName, String address, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.age = age;
            weight = 30;
            sex = true;
        }

        public Human(String firstName, String lastName, String address, int age, int weight) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.age = age;
            this.weight = weight;
            sex = true;
        }

        public Human(String firstName, String lastName, int weight, boolean sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.weight = weight;
            this.sex = sex;
            address = "Home";
            age=10;
        }

        public Human(String firstName, String lastName, int age, int weight) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.weight = weight;
            address = "Home";
            sex = true;
        }

        public Human(int age, int weight, boolean sex) {
            this.age = age;
            this.weight = weight;
            this.sex = sex;
            address = "Home";
            firstName = "Sam";
            lastName = "Smith";
        }

        public Human(String lastName, int age) {
            this.lastName = lastName;
            this.age = age;
            address = "Home";
            firstName = "Sam";
            weight = 30;
            sex = true;
        }

        public Human(String lastName, boolean sex) {
            this.lastName = lastName;
            this.sex = sex;
            address = "Home";
            firstName = "Sam";
            age=10;
            weight = 30;
        }

    }
}

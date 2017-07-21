package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human gfather1 = new Human("Pete",true,55);
        Human gfather2 = new Human("Bete",true,65);
        Human gmother1 = new Human("Mete", false,55);
        Human gmother2 = new Human("Fete", false,65);
        Human mother = new Human("Zete", false,33, gfather1, gmother1);
        Human father = new Human("Yete", true ,36, gfather2, gmother2);
        Human son1 = new Human("Hete",true,16, father, mother);
        Human son2 = new Human("Rete",false,14, father, mother);
        Human son3 = new Human("Eete",true,18, father, mother);

        System.out.println(gfather1.toString());
        System.out.println(gmother1.toString());
        System.out.println(gfather2.toString());
        System.out.println(gmother2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(son1.toString());
        System.out.println(son2.toString());
        System.out.println(son3.toString());
    }

    public static class Human {
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        //напишите тут ваш код
        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}























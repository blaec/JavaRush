package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human child1 = new Human("a",false,10);
        Human child2 = new Human("b",true,11);
        Human child3 = new Human("c",false,9);
        ArrayList children = new ArrayList();
        Collections.addAll(children, child1, child2, child3);

        Human pa = new Human("aa",true,30,children);
        ArrayList<Human> fachild = new ArrayList<>();
        fachild.add(pa);
        Human ma = new Human("bb",false,25,children);
        ArrayList<Human> machild = new ArrayList<>();
        machild.add(ma);

        Human gpa1 = new Human("aaa", true,60, fachild);
        Human gma1 = new Human("nnn", false,61, fachild);
        Human gpa2 = new Human("ddd", true,62, machild);
        Human gma2 = new Human("www", false,63, machild);

        ArrayList family = new ArrayList();
        Collections.addAll(family,child1,child2,child3,pa,ma,gpa1,gpa2,gma1,gma2);
        for (Object member : family) {
            System.out.println(member.toString());
        }
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        Boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, Boolean sex, int age, ArrayList children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public Human(String name, Boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}

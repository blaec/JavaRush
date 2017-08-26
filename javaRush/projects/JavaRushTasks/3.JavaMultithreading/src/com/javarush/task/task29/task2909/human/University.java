package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        double maxGrade = 0;
        Student studentWithMaxGrade = null;

        for (Student student : students) {
            double grade = student.getAverageGrade();
            maxGrade = grade > maxGrade ? grade : maxGrade;
            studentWithMaxGrade = grade == maxGrade ? student : studentWithMaxGrade;
        }
        return studentWithMaxGrade;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        double minGrade = Double.MAX_VALUE;
        Student studentWithMaxGrade = null;

        for (Student student : students) {
            double grade = student.getAverageGrade();
            minGrade = grade < minGrade ? grade : minGrade;
            studentWithMaxGrade = grade == minGrade ? student : studentWithMaxGrade;
        }
        return studentWithMaxGrade;
    }

    public void expel(Student student) {
        //TODO:
        students.remove(student);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
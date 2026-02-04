package org.example.module;

public class Student {

    private int id;
    private String name;
    private int age;
    private String career;

    public Student() {}

    public Student(int id, String name, int age, String career) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.career = career;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }
}

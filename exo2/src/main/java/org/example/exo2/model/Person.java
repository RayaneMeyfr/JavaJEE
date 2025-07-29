package org.example.exo2.model;

public class Person {
    private String name;
    private String prenom;
    private int age;

    public Person(String name, String prenom, int age) {
        this.name = name;
        this.prenom = prenom;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }
}

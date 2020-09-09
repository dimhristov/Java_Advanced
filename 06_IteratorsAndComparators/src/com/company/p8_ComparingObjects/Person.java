package com.company.p8_ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        setName(name);
        setAge(age);
        setTown(town);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public int compareTo(Person o) {
        if (this.getName().compareTo(o.getName()) == 0) {
            if (this.getAge() == o.getAge()) {
                if (this.getTown().compareTo(o.getTown()) == 0) {
                    return 0;
                }
            }
        }
        return -1;
    }
}

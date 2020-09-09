package com.company.p9_Google;

public class Parent {
    private String name;
    private String birthday;

    public Parent(String parentName, String parentBirthday) {
        this.name = parentName;
        this.birthday = parentBirthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s", name, birthday);
    }
}

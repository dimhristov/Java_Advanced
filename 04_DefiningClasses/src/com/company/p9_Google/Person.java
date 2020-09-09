package com.company.p9_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Children> childrens;
    private Car car;

    public String getName() {
        return this.name;
    }

    public Company getCompany() {
        return this.company;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public List<Parent> getParents() {
        return this.parents;
    }

    public List<Children> getChildrens() {
        return this.childrens;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public void setChildrens(List<Children> childrens) {
        this.childrens = childrens;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Person(String name) {
        this.name = name;
        pokemons = new ArrayList<>();
        parents = new ArrayList<>();
        childrens = new ArrayList<>();
    }

    @Override
    public String toString() {
        String result = name + System.lineSeparator();
        if (company != null) {
            result +="Company:\n" +company + System.lineSeparator();
        } else {
            result +="Company:\n";
        }
        if (car != null) {
            result +="Car:\n" +car + System.lineSeparator();
        } else {
            result += "Car:\n";
        }

        result += "Pokemons:\n";
        if (pokemons != null) {

            for (Pokemon pokemon : pokemons) {
                result +=pokemon + System.lineSeparator();
            }
        }
        result += "Parents:\n";
        for (Parent parent : parents) {
            result += parent + System.lineSeparator();
        }
        result += "Children:\n";
        for (Children children : childrens) {
            result +=children + System.lineSeparator();
        }

        return result;
    }

}

package com.company.p6_PokemonChallenge;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemons;


    public Trainer(String name) {
        this.name = name;
        badges = 0;
        pokemons = new ArrayList<>();

    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public String getName() {
        return this.name;
    }

    public int getBadges() {
        return this.badges;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void setPokemons(Pokemon pokemon) {
        pokemons.add(pokemon);
    }
}

package org.example.exo3.model;

import java.util.Date;

public class Chat {
    String name;
    Race race;
    String bestMeal;
    String birthday;

    public Chat(String name, Race race, String bestMeal, String birthday) {
        this.name = name;
        this.race = race;
        this.bestMeal = bestMeal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public String getBestMeal() {
        return bestMeal;
    }

    public void setBestMeal(String bestMeal) {
        this.bestMeal = bestMeal;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}

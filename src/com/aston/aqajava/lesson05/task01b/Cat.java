package com.aston.aqajava.lesson05.task01b;

import java.util.Objects;

public class Cat {
    private String name;
    private boolean fullness;
    private int hunger;

    public Cat(String name, int hunger) {
        this.name = name;
        this.hunger = hunger;
        this.fullness = false;
    }

    public void eat(Plate p) {
         if (p.getFood() >= hunger){
             p.setFood(p.getFood() - hunger);
             setFullness(true);
         }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getFullness() {
        return fullness;
    }

    public void setFullness(boolean fullness) {
        this.fullness = fullness;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return fullness == cat.fullness && hunger == cat.hunger && Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, fullness, hunger);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", fullness=" + fullness +
                ", hunger=" + hunger +
                '}';
    }
}

package com.aston.aqajava.lesson05.task01b;

import java.util.Objects;

public class Plate {
    private int food;
    public Plate(int food) {
        if (food < 0){
            throw new RuntimeException("Amount of food should be positive.");
        }
        this.food = food;
    }
    public void info() {
        System.out.println("Total food amount: " + getFood());
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        if (food < 0){
            throw new RuntimeException("Amount of food should be positive.");
        }
        this.food = food;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plate plate = (Plate) o;
        return food == plate.food;
    }

    @Override
    public int hashCode() {
        return Objects.hash(food);
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }
}

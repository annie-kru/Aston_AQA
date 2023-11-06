package com.aston.aqajava.lesson05.task01;

import java.util.Objects;

public abstract class Animal {
    private String name;
    private static int count = 0;
    public Animal(String name) {
        this.name = name;
        count++;
    }
    public void run(int distance){
        if (distance > 0) {
            System.out.println(getName() + " пробежал " + distance + "м.");
        } else {
            System.out.println("Задание не выполнено. Отрицательная дистанция.");
        }
    }
    public void swim(int distance){
        if (distance > 0) {
            System.out.println(getName() + " проплыл " + distance + "м.");
        } else {
            System.out.println("Задание не выполнено. Отрицательная дистанция.");
        }
    }

    public String getName() {
        return name;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}

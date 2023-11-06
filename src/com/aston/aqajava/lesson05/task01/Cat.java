package com.aston.aqajava.lesson05.task01;

public class Cat extends Animal {
    private static int catCount = 0;
    public Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            super.run(distance);
        } else {
            System.out.println(getName() + " пробежал только 200м из " + distance);
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Котики не умеют плавать.");
    }

    public static int getCatCount() {
        return catCount;
    }

}
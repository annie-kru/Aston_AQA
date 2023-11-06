package com.aston.aqajava.lesson05.task01;

public class Dog extends Animal{
    private static int dogCount = 0;
    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int distance) {
        if(distance <= 500) {
            super.run(distance);
        } else {
            System.out.println(getName() + " пробежал только 500м из " + distance);
        }
    }

    @Override
    public void swim(int distance) {
        if(distance <= 10) {
            super.swim(distance);
        } else {
            System.out.println(getName() + " проплыл только 10м из " + distance);
        }
    }


    public static int getDogCount() {
        return dogCount;
    }
}

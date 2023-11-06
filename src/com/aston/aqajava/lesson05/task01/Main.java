package com.aston.aqajava.lesson05.task01;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Мурзик");
        cat1.run(300);
        Cat cat2 = new Cat("Матроскин");
        System.out.println("Создано котов: " + Cat.getCatCount());
        Dog dog = new Dog("Шарик");
        dog.swim(5);
        System.out.println("Создано собак: " + Dog.getDogCount());
        System.out.println("Создано животных: " + Animal.getCount());
    }
}

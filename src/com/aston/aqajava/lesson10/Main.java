package com.aston.aqajava.lesson10;

import com.aston.aqajava.lesson10.impl.Apple;
import com.aston.aqajava.lesson10.impl.Box;
import com.aston.aqajava.lesson10.impl.Orange;

public class Main {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();

        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();

        appleBox1.add(apple1);
        appleBox2.add(apple2,apple3);
        orangeBox1.add(orange1,orange2);

        System.out.println("First box of apples weights " + appleBox1.getWeight());
        appleBox1.move(appleBox2);
        System.out.println("First box of apples weights " + appleBox1.getWeight());

        System.out.println("Second and third boxes have the same weight: " + appleBox2.compare(orangeBox1));
    }
}

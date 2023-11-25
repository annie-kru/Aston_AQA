package com.aston.aqajava.lesson10.impl;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit>{
    private ArrayList<T> fruitUnits;
    public Box(){
        this.fruitUnits = new ArrayList<>();
    }
    public void add(T...fruitUnits){
        this.fruitUnits.addAll(Arrays.asList(fruitUnits));
    }
    public float getWeight(){
        float boxWeight = 0.0f;
        for (int i = 0; i < fruitUnits.size(); i++){
            boxWeight += fruitUnits.get(i).getWeight();
        }
        return boxWeight;
    }
    public boolean compare(Box<?> another){
        return this.getWeight() == another.getWeight();
    }
    public void move(Box<? super T> another) {
        another.fruitUnits.addAll((this.fruitUnits));
        this.fruitUnits.clear();
    }
}

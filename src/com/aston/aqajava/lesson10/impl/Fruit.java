package com.aston.aqajava.lesson10.impl;

 abstract class Fruit {
    private float weight;
    protected Fruit(float weight){
        this.weight = weight;
    }
    public float getWeight() {
        return weight;
    }
}

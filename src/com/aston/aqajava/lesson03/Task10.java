package com.aston.aqajava.lesson03;

import java.util.Arrays;

public class Task10 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayCreation(5,3)));
    }
    public static int[] arrayCreation (int len, int initialValue){
        int[] array = new int[len];
        for(int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}

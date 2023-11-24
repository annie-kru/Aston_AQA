package com.aston.aqajava.lesson09;

import java.util.ArrayList;
import java.util.Random;

public class Task01 {
    public static void main(String[] args) {
        numberedStream();
    }
    public static void numberedStream(){
        ArrayList<Integer> listOfNumbers = new ArrayList<>();
        Random random = new Random();
        int arrayLength = 10;
        int number;

        for(int i = 0; i < arrayLength; i++){
            number = random.nextInt(100);
            listOfNumbers.add(number);
        }
        System.out.println("Generated list of numbers: " + listOfNumbers);

        int count = (int) listOfNumbers.stream().filter(numbers -> (numbers % 2) == 0).count();
        System.out.println("Number of even numbers: " + count);
    }
}

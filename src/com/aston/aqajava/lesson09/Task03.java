package com.aston.aqajava.lesson09;

import java.util.*;
import java.util.stream.Collectors;

public class Task03 {
    public static void main(String[] args) {
        ArrayList<String> elementsArray = new ArrayList<String>();
        Collections.addAll(elementsArray, "f10", "f15", "f2", "f4", "f4");
        System.out.println("Sorted in ascending order: " + arrayCreation(elementsArray));
    }
    public static List arrayCreation(ArrayList<String> elementsArray){
       return elementsArray.stream().sorted().collect(Collectors.toList());
    }
}


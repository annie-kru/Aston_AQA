package com.aston.aqajava.lesson09;

import java.util.ArrayList;
import java.util.Collections;

public class Task02 {
    public static void main(String[] args) {
        ArrayList<String> wordsArray = new ArrayList<String>();
        Collections.addAll(wordsArray, "Highload", "High", "Load", "Highload");

        System.out.println("Object \"High\" appears " + wordCount(wordsArray, "High") + " times in the list.");
        System.out.println("First element in the list is: " + firstElementCheck(wordsArray));
        System.out.println("Last element in the list is: " + lastElementCheck(wordsArray));
    }
    public static int wordCount(ArrayList<String> wordsArray, String word){
        return (int)wordsArray.stream().filter(word::equals).count();
    }
    public static String firstElementCheck(ArrayList<String> wordsArray){
        return wordsArray.stream().findFirst().orElse("0");
    }
    public static String lastElementCheck(ArrayList<String> wordsArray){
       return wordsArray.stream().skip(wordsArray.size() - 1).findFirst().orElse("0");
    }
}

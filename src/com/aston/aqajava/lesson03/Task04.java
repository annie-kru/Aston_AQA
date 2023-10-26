package com.aston.aqajava.lesson03;

public class Task04 {
    public static void main(String[] args) {
        printString("Typing...", 3);
    }
    public static void printString(String s, int number) {
        for (int i = 1; i <= number; i++) {
            System.out.println(s);
        }
    }
}

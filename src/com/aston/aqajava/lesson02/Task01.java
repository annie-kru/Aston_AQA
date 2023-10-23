package com.aston.aqajava.lesson02;

public class Task01 {
    public static void main(String[] args) {
        printThreeWords();
        System.out.println("--------------");

        checkSumSign(-2, -4);
        checkSumSign(5, 10);
        System.out.println("--------------");

        printColour(-1);
        printColour(100);
        printColour(101);
        System.out.println("--------------");

        compareNumbers(5, 6);
        compareNumbers(3, -3);
        System.out.println("--------------");
    }

    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign(int a, int b) {
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная.");
        } else {
            System.out.println("Сумма отрицательная.");
        }
    }

    public static void printColour(int value) {
        if (value <= 0) {
            System.out.println("Красный.");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый.");
        } else {
            System.out.println("Зеленый.");
        }
    }

    public static void compareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

}

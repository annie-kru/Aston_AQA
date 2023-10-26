package com.aston.aqajava.lesson03;

public class Task05 {
    public static void main(String[] args) {
        checkLeapYear(1988);
        checkLeapYear(1989);
        checkLeapYear(1700);
        checkLeapYear(1600);
    }
    public static void checkLeapYear(int year){
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println("Год високосный.");
                } else {
                    System.out.println("Год не високосный.");
                }
            } else {
                System.out.println("Год високосный.");
            }
        } else {
            System.out.println("Год не високосный.");
        }
    }
}

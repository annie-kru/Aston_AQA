package com.aston.aqajava.lesson03;

public class Task02 {
    public static void main(String[] args) {
        checkSign(4);
        checkSign(-4);
    }
    public static void checkSign(int number) {
        if (number < 0) {
            System.out.println("Отрицательное число");
        } else {
            System.out.println("Положительное число");
        }
    }
}

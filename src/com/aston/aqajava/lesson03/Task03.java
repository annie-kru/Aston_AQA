package com.aston.aqajava.lesson03;

public class Task03 {
    public static void main(String[] args) {
        System.out.println(checkSign(-7));
        System.out.println(checkSign(7));
    }
    public static boolean checkSign(int number) {
        if (number < 0) {
            return true;
        } else {
            return false;
        }
    }
}

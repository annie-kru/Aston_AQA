package com.aston.aqajava.lesson03;

public class Task01 {
    public static void main(String[] args) {
        System.out.println(checkSum(5,6));
        System.out.println(checkSum(0,1));
        System.out.println(checkSum(20,3));
    }
    public static boolean checkSum(int a, int b) {
        int sum = a + b;
        if(sum >= 10 && sum <= 20){
            return true;
        } else {
            return false;
        }
    }
}

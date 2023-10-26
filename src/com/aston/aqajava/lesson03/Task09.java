package com.aston.aqajava.lesson03;

public class Task09 {
    public static void main(String[] args) {
        int[][] array = new int[7][7];
        for (int i = 0; i < array.length; i++) {
                array[i][i] = 1;
                array[i][(array[i].length - 1) - i] = 1;
        }
        printMassive(array);
    }
    public static void printMassive(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%4s", array[i][j]);
            }
            System.out.println();
        }
        System.out.println("----------------------------");
    }
}

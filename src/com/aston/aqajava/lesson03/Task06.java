package com.aston.aqajava.lesson03;

import java.util.Arrays;

public class Task06 {
    public static void main(String[] args) {
        int[] array = {1, 1, 0, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}

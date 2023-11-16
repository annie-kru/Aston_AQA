package com.aston.aqajava.lesson07;

public class ArraySum {
    public static void main(String[] args) {
        try{
            System.out.println("Array elements sum = " + arraySumCount(new String[][]{{"1", "2", "3", "4"},
                    {"5", "6", "7", "8"},{"9", "10", "11", "12"},{"13","14","15","16"}}));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }
    public static int arraySumCount(String[][] array ) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                if(array.length != 4 | array[i].length != 4)
                    throw new MyArraySizeException("Array size should be 4x4");
                try{
                    sum += Integer.parseInt(array[i][j]);
                } catch(NumberFormatException e){
                    throw new MyArrayDataException("Wrong data in cell with coordinates: [" +
                            i + "][" + j + "]");
                }
            }
        }
        return sum;
    }
}

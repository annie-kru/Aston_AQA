package com.aston.aqajava.lesson12;

import java.math.BigInteger;

public class Factorial {
    public static BigInteger findFactorial(int number) throws NegativeNumberException{
        if (number < 0){
            throw new NegativeNumberException("Factorial can be counted for positive integers only.");
        } else if(number <= 1) {
            return BigInteger.valueOf(1);
        } else{
            return BigInteger.valueOf(number).multiply(findFactorial(number - 1));
        }
    }
}

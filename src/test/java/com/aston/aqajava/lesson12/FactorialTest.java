package com.aston.aqajava.lesson12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialTest {
    @DisplayName("Checking positive numbers")
    @Test
    public void testPositiveNumbers()  {
        assertEquals(BigInteger.valueOf(120), Factorial.findFactorial(5));
    }
    @DisplayName("Checking negative numbers")
    @Test
    public void testNegativeNumbers(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            Factorial.findFactorial(-5);
        });
    }
    @DisplayName("Checking zero")
    @Test
    public void testZeroValue(){
        assertEquals(BigInteger.valueOf(1), Factorial.findFactorial(0));
    }
    @DisplayName("Checking big number")
    @Test
    public void testBigNumberFactorial(){
        assertEquals(new BigInteger("1307674368000"), Factorial.findFactorial(15));
    }
}
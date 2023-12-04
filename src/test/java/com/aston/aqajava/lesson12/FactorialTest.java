package com.aston.aqajava.lesson12;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import java.math.BigInteger;

public class FactorialTest {

    @Test
    public void testPositiveNumbers()  {
        assertEquals(BigInteger.valueOf(120), Factorial.findFactorial(5));
    }
    @Test(expectedExceptions = NegativeNumberException.class)
    public void testNegativeNumbers(){
            Factorial.findFactorial(-5);
    }
    @Test
    public void testZeroValue(){
        assertEquals(BigInteger.valueOf(1), Factorial.findFactorial(0));
    }
    @Test
    public void testBigNumberFactorial(){
        assertEquals(new BigInteger("1307674368000"), Factorial.findFactorial(15));
    }
}
package com.ontariotechu.sofe3980U;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Unit test for Binary class.
 */
public class BinaryTest
{
    // Original test cases

    /**
     * Test the constructor with a valid binary value.
     */
    @Test
    public void normalConstructor()
    {
        Binary binary = new Binary("1001001");
        assertTrue(binary.getValue().equals("1001001"));
    }

    /**
     * Test the constructor with an invalid binary value containing out-of-range digits.
     */
    @Test
    public void constructorWithInvalidDigits()
    {
        Binary binary = new Binary("1001001211");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test the constructor with an invalid binary value containing alphabetic characters.
     */
    @Test
    public void constructorWithInvalidChars()
    {
        Binary binary = new Binary("1001001A");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test the constructor with an invalid binary value that has a negative sign.
     */
    @Test
    public void constructorWithNegativeSign()
    {
        Binary binary = new Binary("-1001001");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test the constructor with a valid binary value that has leading zeros.
     */
    @Test
    public void constructorWithZeroTailing()
    {
        Binary binary = new Binary("00001001");
        assertTrue(binary.getValue().equals("1001"));
    }

    /**
     * Test the constructor with an empty string.
     */
    @Test
    public void constructorEmptyString()
    {
        Binary binary = new Binary("");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test the add function with two binary numbers of the same length.
     */
    @Test
    public void add()
    {
        Binary binary1 = new Binary("1000");
        Binary binary2 = new Binary("1111");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("10111"));
    }

    /**
     * Test the add function with two binary numbers, where the first argument is longer than the second.
     */
    @Test
    public void add2()
    {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("11");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1101"));
    }

    /**
     * Test the add function with two binary numbers, where the first argument is shorter than the second.
     */
    @Test
    public void add3()
    {
        Binary binary1 = new Binary("11");
        Binary binary2 = new Binary("1010");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1101"));
    }

    /**
     * Test the add function with a binary number and zero.
     */
    @Test
    public void add4()
    {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("1010");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1010"));
    }

    /**
     * Test the add function with two zeros.
     */
    @Test
    public void add5()
    {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("0");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("0"));
    }

    // New test cases for bitwiseOr method

    /**
     * Test the bitwiseOr function with two binary numbers of the same length.
     */
    @Test
    public void bitwiseOrSameLength()
    {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("1100");
        Binary result = Binary.bitwiseOr(binary1, binary2);
        assertTrue(result.getValue().equals("1110"));
    }

    /**
     * Test the bitwiseOr function with the first binary number longer than the second.
     */
    @Test
    public void bitwiseOrFirstLonger()
    {
        Binary binary1 = new Binary("10101");
        Binary binary2 = new Binary("110");
        Binary result = Binary.bitwiseOr(binary1, binary2);
        assertTrue(result.getValue().equals("10111"));
    }

    /**
     * Test the bitwiseOr function with the first binary number shorter than the second.
     */
    @Test
    public void bitwiseOrFirstShorter()
    {
        Binary binary1 = new Binary("110");
        Binary binary2 = new Binary("10101");
        Binary result = Binary.bitwiseOr(binary1, binary2);
        assertTrue(result.getValue().equals("10111"));
    }

    // New test cases for multiply method

    /**
     * Test the multiply function with two binary numbers.
     */
    @Test
    public void multiply()
    {
        Binary binary1 = new Binary("101");
        Binary binary2 = new Binary("11");
        Binary result = Binary.multiply(binary1, binary2);
        assertTrue(result.getValue().equals("1111"));
    }

    /**
     * Test the multiply function with a binary number and zero.
     */
    @Test
    public void multiplyWithZero()
    {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("0");
        Binary result = Binary.multiply(binary1, binary2);
        assertTrue(result.getValue().equals("0"));
    }

    /**
     * Test the multiply function with two binary numbers, one being one.
     */
    @Test
    public void multiplyWithOne()
    {
        Binary binary1 = new Binary("1");
        Binary binary2 = new Binary("1101");
        Binary result = Binary.multiply(binary1, binary2);
        assertTrue(result.getValue().equals("1101"));
    }
}

package com.ontariotechu.sofe3980U;

/**
 * Demonstrates operations on Binary numbers.
 */
public class App {
	/**
	 * Main program: The entry point of the program. It creates two binary variables,
	 * performs various operations (addition, bitwise OR, bitwise AND, multiplication),
	 * and prints the results.
	 *
	 * @param args not used
	 */
	public static void main(String[] args) {
		// Create two Binary objects
		Binary binary1 = new Binary("1010"); // Binary representation of 10
		Binary binary2 = new Binary("1100"); // Binary representation of 12

		// Display the binary numbers
		System.out.println("First binary number: " + binary1.getValue());
		System.out.println("Second binary number: " + binary2.getValue());

		// Perform addition
		Binary sum = Binary.add(binary1, binary2);
		System.out.println("Addition result: " + sum.getValue());

		// Perform bitwise OR
		Binary orResult = Binary.bitwiseOr(binary1, binary2);
		System.out.println("Bitwise OR result: " + orResult.getValue());

		// Perform bitwise AND
		Binary andResult = Binary.bitwiseAnd(binary1, binary2);
		System.out.println("Bitwise AND result: " + andResult.getValue());

		// Perform multiplication
		Binary product = Binary.multiply(binary1, binary2);
		System.out.println("Multiplication result: " + product.getValue());
	}
}

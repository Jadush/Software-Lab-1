package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 */
public class Binary {
	private String number = "0";  // String containing the binary value '0' or '1'

	/**
	 * Constructor that generates a binary object.
	 *
	 * @param number a String of the binary values. It should contain only zeros or ones with any length and order;
	 *               otherwise, the value of "0" will be stored. Leading zeros will be excluded, and an empty string
	 *               will be considered as zero.
	 */
	public Binary(String number) {
		if (number == null || number.isEmpty()) {
			this.number = "0"; // Default to "0" for null or empty input
			return;
		}

		// Validate the binary string (only '0' or '1' allowed)
		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);
			if (ch != '0' && ch != '1') {
				this.number = "0"; // Default to "0" for invalid input
				return;
			}
		}

		// Remove leading zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg) != '0') {
				break;
			}
		}

		// If all digits are '0', ensure number is "0"
		this.number = (beg == number.length()) ? "0" : number.substring(beg);

		// Ensure empty strings are replaced with "0"
		if (this.number.isEmpty()) {
			this.number = "0";
		}
	}

	/**
	 * Returns the binary value of the variable.
	 *
	 * @return the binary value in a string format.
	 */
	public String getValue() {
		return this.number;
	}

	/**
	 * Adds two binary variables.
	 *
	 * @param num1 The first addend object.
	 * @param num2 The second addend object.
	 * @return A binary variable with a value of num1 + num2.
	 */
	public static Binary add(Binary num1, Binary num2) {
		int ind1 = num1.number.length() - 1; // Index of the first digit of num1
		int ind2 = num2.number.length() - 1; // Index of the first digit of num2
		int carry = 0; // Initial carry
		StringBuilder result = new StringBuilder(); // StringBuilder for the result

		// Loop until all digits are processed
		while (ind1 >= 0 || ind2 >= 0 || carry != 0) {
			int sum = carry; // Start with the carry

			if (ind1 >= 0) {
				sum += (num1.number.charAt(ind1) == '1') ? 1 : 0; // Add digit from num1
				ind1--;
			}

			if (ind2 >= 0) {
				sum += (num2.number.charAt(ind2) == '1') ? 1 : 0; // Add digit from num2
				ind2--;
			}

			carry = sum / 2; // Calculate new carry
			sum = sum % 2; // Calculate the resultant digit
			result.insert(0, (sum == 0) ? '0' : '1'); // Prepend the digit to the result
		}

		return new Binary(result.toString());
	}

	/**
	 * Performs a bitwise OR operation between two binary variables.
	 *
	 * @param num1 The first binary object.
	 * @param num2 The second binary object.
	 * @return A binary variable with a value of num1 OR num2.
	 */
	public static Binary bitwiseOr(Binary num1, Binary num2) {
		// Determine the maximum length
		int maxLength = Math.max(num1.number.length(), num2.number.length());

		// Pad the shorter number with leading zeros
		String paddedNum1 = String.format("%" + maxLength + "s", num1.number).replace(' ', '0');
		String paddedNum2 = String.format("%" + maxLength + "s", num2.number).replace(' ', '0');

		StringBuilder result = new StringBuilder();

		// Perform bitwise OR operation
		for (int i = 0; i < maxLength; i++) {
			char bit1 = paddedNum1.charAt(i);
			char bit2 = paddedNum2.charAt(i);
			result.append((bit1 == '1' || bit2 == '1') ? '1' : '0');
		}

		return new Binary(result.toString());
	}

	/**
	 * Performs a bitwise AND operation between two binary variables.
	 *
	 * @param num1 The first binary object.
	 * @param num2 The second binary object.
	 * @return A binary variable with a value of num1 AND num2.
	 */
	public static Binary bitwiseAnd(Binary num1, Binary num2) {
		// Determine the maximum length
		int maxLength = Math.max(num1.number.length(), num2.number.length());

		// Pad the shorter number with leading zeros
		String paddedNum1 = String.format("%" + maxLength + "s", num1.number).replace(' ', '0');
		String paddedNum2 = String.format("%" + maxLength + "s", num2.number).replace(' ', '0');

		StringBuilder result = new StringBuilder();

		// Perform bitwise AND operation
		for (int i = 0; i < maxLength; i++) {
			char bit1 = paddedNum1.charAt(i);
			char bit2 = paddedNum2.charAt(i);
			result.append((bit1 == '1' && bit2 == '1') ? '1' : '0');
		}

		return new Binary(result.toString());
	}

	/**
	 * Multiplies two binary variables.
	 *
	 * @param num1 The first binary object.
	 * @param num2 The second binary object.
	 * @return A binary variable with a value of num1 * num2.
	 */
	public static Binary multiply(Binary num1, Binary num2) {
		Binary product = new Binary("0"); // Initialize product to zero

		// Iterate over each bit in num2 from right to left
		for (int i = num2.number.length() - 1; i >= 0; i--) {
			if (num2.number.charAt(i) == '1') {
				// Shift num1 left by the appropriate number of positions
				String shiftedNum1 = num1.number + "0".repeat(num2.number.length() - 1 - i);
				// Add the shifted num1 to the product
				product = add(product, new Binary(shiftedNum1));
			}
		}

		return product;
	}
}

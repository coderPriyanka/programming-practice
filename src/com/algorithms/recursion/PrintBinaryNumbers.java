package com.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given a positive integer N, the task is to find all the N bit binary numbers having more than or equal 1’s than 0’s 
 * for any prefix of the number.

	Example 1:
	Input:  N = 2
	Output: 11 10
	Explanation: 11 and 10 have more than 
	or equal 1's than 0's
	
	Example 2:
	Input:  N = 3
	Output: 111 110 101
	Explanation: 111, 110 and 101 have more 
	than or equal 1's than 0's

 * @author priyasar
 *
 */

public class PrintBinaryNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = in.nextInt();
		List<String> validBinaryNumbers = generateValidBinaryNumbers(count);
		for (String binaryNumber : validBinaryNumbers) {
			System.out.print(binaryNumber + " ");
		}
		System.out.println();
		in.close();
	}
	
	private static List<String> generateValidBinaryNumbers(int count) {
		List<String> validBinaryNumbers = new ArrayList<>();
		int one = 0, zero = 0;
		generateValidBinaryNumbers(one, zero, count, "", validBinaryNumbers);
		return validBinaryNumbers;
	}
	
	private static void generateValidBinaryNumbers(int one, int zero, int length, String result, List<String> binaryNumbers) {
		if (length > 0 && one == zero) {
			result += "1";
			one++;
			length--;
		}
		if (length == 0) {
			binaryNumbers.add(result);
			return;
		}
		generateValidBinaryNumbers(one + 1, zero, length - 1, result + "1", binaryNumbers);
		generateValidBinaryNumbers(one, zero + 1, length - 1, result + "0", binaryNumbers);
	}

}

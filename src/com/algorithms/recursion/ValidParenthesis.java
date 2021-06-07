package com.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Generate all valid balanced parenthesis from a given number of pairs
 * @author priyasar
 *
 */

public class ValidParenthesis {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int bracketPairs = in.nextInt();
		List<String> validParenthesis = getValidParenthesis(bracketPairs);
		for (String parenthesis : validParenthesis) {
			System.out.print(parenthesis + " ");
		}
		System.out.println();
		in.close();
	}
	
	private static List<String> getValidParenthesis(int count) {
		List<String> validParenthesis = new ArrayList<>();
		int openBracketCount = count;
		int closingBracketCount = count;
		getValidParenthesis(openBracketCount, closingBracketCount, "", validParenthesis);
		return validParenthesis;
	}
	
	private static void getValidParenthesis(int openBracketCount, int closingBracketCount, String result, List<String> validParenthesis) {
		if (openBracketCount == closingBracketCount) {
			result += "(";
			openBracketCount--;
		}
		if (openBracketCount == 0) {
			while (closingBracketCount > 0) {
				result += ")";
				closingBracketCount--;
			}
			validParenthesis.add(result);
			return;
		}
		getValidParenthesis(openBracketCount - 1, closingBracketCount, result + "(" , validParenthesis);
		getValidParenthesis(openBracketCount, closingBracketCount - 1, result + ")" , validParenthesis);
	}
	
}

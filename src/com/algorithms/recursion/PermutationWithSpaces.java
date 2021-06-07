package com.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given a string you need to print all possible strings that can be made by placing spaces (zero or one) 
 * in between them. The output should be printed in sorted increasing order of strings
 * Input: S = "ABC"
 * Output: (A B C)(A BC)(AB C)(ABC)
 * Explanation:
 * ABC
 * AB C
 * A BC
 * A B C
 * These are the possible combination of "ABC".
 * 
 * @author priyasar
 *
 */

public class PermutationWithSpaces {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		List<String> permutations = permutation(input);
		for (String value : permutations) {
			System.out.print(value + " ");
		}
		System.out.println();
		in.close();
	}
	
	private static List<String> permutation(String S){
        List<String> permutations = new ArrayList<>();
        findPermutations(S.substring(1), "(" + String.valueOf(S.charAt(0)), permutations);
        return permutations;
    }
	
    private static void findPermutations(String input, String output, List<String> permutations) {
        if (input.length() == 0) {
            permutations.add(output + ")");
            return;
        }
        String output1 = output + " " + input.substring(0, 1);
        String output2 = output + input.substring(0, 1);
        input = input.substring(1);
        findPermutations(input, output1, permutations);
        findPermutations(input, output2, permutations);
    }
}

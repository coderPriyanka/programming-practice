package com.algorithm.slidingwindow;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubstringWithAlllUniqueCharacters {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    int tests = in.nextInt();
	    for (int test = 1; test <= tests; test++) {
	        in.nextLine();
	        String input = in.nextLine();
	        System.out.println(longestSubstringWithoutRepeatingCharacters(input));
	    }
	    in.close();
	}
	
	private static int longestSubstringWithoutRepeatingCharacters(String input) {
		Map<Character, Integer> letterToFrequency = new HashMap<>();
		int i = 0, j = 0, length = 0, maxLength = 0;
		while (j < input.length()) {
			while (letterToFrequency.containsKey(input.charAt(j))) {
				maxLength = Math.max(length, maxLength);
				letterToFrequency.remove(input.charAt(i));
				length--;
				i++;
			}
			letterToFrequency.put(input.charAt(j), 1);
			length++;
			j++;
		}
		maxLength = Math.max(length, maxLength);
		return maxLength;
	}
}

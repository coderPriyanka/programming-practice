package com.algorithm.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *  Given a string you need to print the size of the longest possible substring that has exactly k unique characters. If there is no possible substring print -1.
	Example
	For the string aabacbebebe and k = 3 the substring will be cbebebe with length 7.
 *  @author priyasar
 *
 */

public class LongestSubstringKUniqueCharacters {

	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
	    int tests = in.nextInt();
	    for (int test = 1; test <= tests; test++) {
	        in.nextLine();
	        String input = in.nextLine();
	        int k = in.nextInt();
	        System.out.println(longestSubstringWithKUniqueCharacters(input, k));
	    }
	    in.close();
	}
	
	private static int longestSubstringWithKUniqueCharacters(String input, int k) {
    	Map<Character, Integer> letterToFrequency = new HashMap<>();
    	int i = 0, j = 0, count = 0, maxLength = 0, length = 0;
    	while (j < input.length()) {
    		if (count == k && !letterToFrequency.containsKey(input.charAt(j))) {
    			length = j - i;
    			maxLength = Math.max(length, maxLength);
    			while (count == k) {
    				int frequency = letterToFrequency.get(input.charAt(i));
    				if (frequency - 1 == 0) {
    					letterToFrequency.remove(input.charAt(i));
    					count--;
    				} else {
    					letterToFrequency.put(input.charAt(i), frequency - 1);
    				}
    				i++;
    			}
    		}
    		if (letterToFrequency.containsKey(input.charAt(j))) {
    			int frequency = letterToFrequency.get(input.charAt(j));
    			letterToFrequency.put(input.charAt(j), frequency + 1);
    		} else {
    			letterToFrequency.put(input.charAt(j), 1);
                count++;
            }
            j++;
    	}
    	if (count == k) {
    		length = j - i;
    		maxLength = Math.max(length, maxLength);
    	}
    	return maxLength;
    }

}

package com.gfg.dp.mcm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *  Given two strings S1 and S2 of equal length, the task is to determine if S2 is a scrambled form of S1.
	Scrambled string: 
	Given string str, we can represent it as a binary tree by partitioning it to two non-empty substrings recursively.
	Note: Scrambled string is not same as an Anagram
	Below is one possible representation of str = “coder”:
	
		coder
	   /    \
	  co    der
	 / \    /  \
	c   o  d   er
	           / \
	          e   r
	To scramble the string, we may choose any non-leaf node and swap its two children. 
	Suppose, we choose the node “co” and swap its two children, it produces a scrambled string “ocder”.
	 
	
	    ocder
	   /    \
	  oc    der
	 / \    /  \
	o   c  d   er
	           / \
	          e   r
	Thus, “ocder” is a scrambled string of “coder”.
	Similarly, if we continue to swap the children of nodes “der” and “er”, it produces a scrambled string “ocred”.
	 
	
	    ocred
	   /    \
	  oc    red
	 / \    /  \
	o   c  re  d
	       / \
	      r   e
	Thus, “ocred” is a scrambled string of “coder”.
	Examples:
	
	Input: S1=”coder”, S2=”ocder” 
	Output: Yes 
	Explanation: 
	“ocder” is a scrambled form of “coder”
	Input: S1=”abcde”, S2=”caebd” 
	Output: No 
	Explanation: 
	“caebd” is not a scrambled form of “abcde”

 * @author priyasar
 *
 */

public class ScrambledString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1 = in.nextLine();
		String s2 = in.nextLine();
		if (scrambledString(s1, s2)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		in.close();
	}
	
	private static boolean scrambledString(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false; 
		}
		if (s1.length() == 0 && s2.length() == 0) {
			return true;
		}
		Map<String, Boolean> map = new HashMap<>();
		return scrambledString(s1, s2, map);
	}

	private static boolean scrambledString(String s1, String s2, Map<String, Boolean> map) {
		if (s1.length() == 0 && s2.length() == 0) {
			return true;
		}
		String key = new String(s1 + "_" + s2);
		if (map.containsKey(key)) {
			return map.get(key);
		}
		if (s1.compareTo(s2) == 0) {
			map.put(key, true);
			return true;
		}
		boolean result = false;
		for (int i = 1; i < s1.length(); i++) {
			boolean condition1 = false, condition2 = false, condition3 = false, condition4 = false;
			condition1 = scrambledString(s1.substring(0, i), s2.substring(0, i), map);
			if (condition1) {
				condition2 = scrambledString(s1.substring(i), s2.substring(i), map);
			}
			if (!(condition1 && condition2)) {
				condition3 = scrambledString(s1.substring(0, i), s2.substring(s2.length() - i), map);
				if (condition3) {
					condition4 = scrambledString(s1.substring(i), s2.substring(0, s2.length() - i), map);
				}
			}
			if ((condition1 && condition2) || (condition3 && condition4)) {
				result = true;
				break;
			}
		}
		map.put(key, result);
		return result;
	}
}

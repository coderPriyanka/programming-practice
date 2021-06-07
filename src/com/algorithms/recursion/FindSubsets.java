package com.algorithms.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindSubsets {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		List<String> subsets = powerSet(input);
		for (String value : subsets) {
			System.out.print(value + " ");
		}
		System.out.println();
		in.close();
	}
	
	private static List<String> powerSet(String s) {
        List<String> subsets = new ArrayList<>();
    	findSubsets(s, "", subsets);
    	Collections.sort(subsets);
    	return subsets;
    }
	
    private static void findSubsets(String input, String output, List<String> subsets) {
    	if (input.length() == 0) {
    		subsets.add(output);
    		return;
    	}
    	String output1 = output;
    	String output2 = output + input.substring(0, 1);
    	input = input.substring(1);
    	findSubsets(input, output1, subsets);
    	findSubsets(input, output2, subsets);
    }
}

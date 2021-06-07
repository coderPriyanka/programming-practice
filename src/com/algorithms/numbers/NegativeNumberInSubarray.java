package com.algorithms.numbers;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Given an array and a positive integer k, find the first negative integer for each and every window
 * (contiguous subarray) of size k.
 * Example:
	Input:
	2
	5
	-8 2 3 -6 10
	2
	8
	12 -1 -7 8 -15 30 16 28
	3 
 * @author priyasar
 *
 */
public class NegativeNumberInSubarray {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int tests = in.nextInt();
		for (int test = 1; test <= tests; test++) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < n; i++) {
		    	arr[i] = in.nextInt();
		    }
		    int k = in.nextInt();
		    List<Integer> result = findNegativeNumbersInSubarrays(arr, n, k);
		    for (int i : result) {
		        System.out.print(i + " ");
		    }
		    System.out.println();
		}
		in.close();
	}
	
	private static List<Integer> findNegativeNumbersInSubarrays(int[] arr, int n, int k) {
	    List<Integer> result = new ArrayList<>();
	    Deque<Integer> numbers = new LinkedList<>();
	    for (int i = 0; i < k; i++) {
	        if (arr[i] < 0) {
	            numbers.addLast(arr[i]);
	        }
	    }
	    int i = k, j = 0;
	    while (i < n) {
	        if (numbers.size() == 0) {
	            result.add(0);
	        } else {
	            result.add(numbers.getFirst());
	        }
	        if (arr[i] < 0) {
	            numbers.addLast(arr[i]);
	        }
	        if (arr[j] == numbers.getFirst()) {
	            numbers.removeFirst();
	        }
	        i++; j++;
	    }
	    if (numbers.size() == 0) {
            result.add(0);
        } else {
            result.add(numbers.getFirst());
        }
	    return result;
	}

}

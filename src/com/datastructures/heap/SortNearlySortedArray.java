package com.datastructures.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Given an array of n elements, where each element is at most k away from its target position. The task is to print array in sorted form.

	Input:
	First line consists of T test cases. First line of every test case consists of two integers N and K, denoting number of elements in array and at most k positions away from its target position respectively. Second line of every test case consists of elements of array.
	
	Output:
	Single line output to print the sorted array.
	
	Constraints:
	1<=T<=100
	1<=N<=100
	1<=K<=N
	
	Example:
	Input:
	2
	3 3
	2 1 3
	6 3
	2 6 3 12 56 8
	Output:
	1 2 3
	2 3 6 8 12 56
	
 * @author priyasar
 *
 */

public class SortNearlySortedArray {

	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
	    int tests = in.nextInt();
	    for (int test = 1; test <= tests; test++) {
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int[] arr = new int[n];
	        for (int i = 0; i < n; i++) {
	            arr[i] = in.nextInt();
	        }
	        sortArray(arr, n, k);
	        for (int i = 0; i < n; i++) {
	            System.out.print(arr[i] + " ");
	        }
	        System.out.println();
	    }
	    in.close();
	}
	
	public static void sortArray(int[] arr, int n, int k) {
	    PriorityQueue<Integer> pq = new PriorityQueue<>();
	    int i = 0;
	    while (i < n && i <= k) {
	        pq.add(arr[i++]);
	    }
	    int index = 0;
	    while (i < n) {
	        arr[index++] = pq.remove();
	        pq.add(arr[i++]);
	    }
	    while (!pq.isEmpty()) {
	        arr[index++] = pq.remove();
	    }
	}
}

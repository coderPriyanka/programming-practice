package com.algorithms.binarysearch;

import java.util.Scanner;

public class FindOccurence {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int test = 1; test <= testCases; test++) {
		    int n = in.nextInt();
		    int se = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < n; i++) {
		        arr[i] = in.nextInt();
		    }
		    int[] result = occurrences(arr, se);
		    if (result == null) {
                System.out.println("-1");		    
		    } else {
		        System.out.println(result[0] + " " + result[1]);
		        System.out.println("The count of occurences is :" + (result[1] - result[0] + 1));
		    }
	    }
		in.close();
	}
	private static int[] occurrences (int [] arr, int searchElement) {
		int start = 0, end = arr.length - 1;
		int firstOccurence = findFirstOccurrence(arr, searchElement, start, end);
		if (firstOccurence == -1) {
			return null;
		}
		int lastOccurence = findLastOccurrence(arr, searchElement, start, end);
		return new int [] {firstOccurence, lastOccurence};
	}

	private static int findFirstOccurrence(int [] arr, int searchElement, int start, int end) {
		if (start > end) {
			return -1;
		}
		if (start == end) {
    	    return searchElement == arr[start] ? start : -1;
    	}
		int mid = start + (end - start) / 2;
		if (searchElement < arr[mid]) {
			return findFirstOccurrence(arr, searchElement, start, mid);
		}
		if (searchElement > arr[mid]) {
			return findFirstOccurrence(arr, searchElement, mid + 1, end);
		}
		return (mid == 0 || searchElement != arr[mid - 1]) ? mid : findFirstOccurrence(arr, searchElement, start, mid - 1);
	}

	private static int findLastOccurrence(int [] arr, int searchElement, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = start + (end - start) / 2;
		if (searchElement < arr[mid]) {
			return findLastOccurrence(arr, searchElement, start, mid);
		}
		if (searchElement > arr[mid]) {
			return findLastOccurrence(arr, searchElement, mid + 1, end);
		}
		return (mid == arr.length - 1 || searchElement != arr[mid + 1]) ? mid : findLastOccurrence(arr, searchElement, mid +1, end);
	}
}

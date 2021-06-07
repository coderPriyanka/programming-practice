package com.algorithms.binarysearch;

import java.util.Scanner;

public class AllocatePages {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] pages = new int[n];
		for (int i = 0; i < n; i++) {
			pages[i] = in.nextInt();
		}
		int m = in.nextInt();
		int[] result = findPages(pages, n, m);
		for (int i = 0; i < m; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
		in.close();
	}
	
	private static int[] findPages(int[]a, int n, int m)
    {
        int[] result = pagesAssignedToStudents(a, m);
        return result;
    }
    public static int[] pagesAssignedToStudents(int[] pages, int students) {
        int[] prefixSum = findPrefixSum(pages);
        int[] pagesAssigned = new int[students];
        int pagesRead = 0, start = 0, end = pages.length - 1;
        int totalPages = prefixSum[end];
        int index = 0;
    	while (students > 1) {
    		int pagesToRead = totalPages / students;
    		System.out.println("Pages to Read : " + pagesToRead);
    		int resultIndex = -1;
    		int key = pagesRead + pagesToRead;
    		if (key < prefixSum[start]) {
    			resultIndex = start;
    		} else if (key > prefixSum[end]) {
    			resultIndex = end;
    		}
    		if (resultIndex == -1) {
	    		int floorIndex = findFloorIndex(prefixSum, start, end, key);
	    		int ceilIndex = findCeilIndex(prefixSum, start, end, key);
	    		if (Math.abs(key - prefixSum[floorIndex]) > Math.abs(key - prefixSum[ceilIndex])) {
	    			resultIndex = ceilIndex;
	    		} else {
	    			resultIndex = floorIndex;
	    		}
    		}
    		pagesRead = prefixSum[resultIndex];
    		System.out.println("Pages Read : " + pagesRead);
    		pagesAssigned[index++] = start == 0 ? prefixSum[resultIndex] : prefixSum[resultIndex] - prefixSum[start - 1];
    		totalPages = prefixSum[end] - pagesRead;
    		start = resultIndex + 1;
    		students--;
    	}
		System.out.println("Pages to Read : " + totalPages);
		System.out.println("Pages Read : " + pagesRead);
        pagesAssigned[index] = totalPages;
        return pagesAssigned;
    }
        
    private static int[] findPrefixSum(int[] input) {
    	int[] prefixSum = new int[input.length];
    	prefixSum[0] = input[0];
    	for (int i = 1; i < input.length; i++) {
    		prefixSum[i] = prefixSum[i - 1] + input[i];
    	}
    	for (int i = 0; i < input.length; i++) {
			System.out.print(prefixSum[i] + " ");
		}
    	System.out.println();
    	return prefixSum;
    }
    private static int findFloorIndex(int[] input, int start, int end, int key) {
    	if (start > end) {
    		return -1;
    	}
    	int mid = start + (end - start) / 2;
    	if (key == input[mid]) {
    		return mid;
    	}
    	if (key < input[mid]) {
    		if (mid - 1 >= 0 && key > input[mid - 1]) {
    			return mid - 1;
    		}
    		return findFloorIndex(input, start, mid, key);
    	}
    	if (mid + 1 < input.length && key < input[mid + 1]) {
    		return mid;
    	}
        return findFloorIndex(input, mid  + 1, end, key);
    }
    
    private static int findCeilIndex(int[] input, int start, int end, int key) {
        if (start > end) {
        	return -1;
        }
    	int mid = start + (end - start) / 2;
    	if (key == input[mid]) {
    		return mid;
    	}
    	if (key < input[mid]) {
    		if (mid - 1 >= 0 && key > input[mid - 1]) {
    			return mid;
    		}
    		return findCeilIndex(input, start, mid, key);
    	}
    	if (mid + 1 < input.length && key < input[mid + 1]) {
    		return mid + 1;
    	}
    	return findCeilIndex(input, mid  + 1, end, key);
    }

}

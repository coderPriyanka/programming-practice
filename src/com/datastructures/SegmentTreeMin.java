package com.datastructures;

import java.util.Scanner;

public class SegmentTreeMin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = in.nextInt();
		}
		int exponent = (int) Math.ceil(Math.log(n) / Math.log(2));
		int size = 2 * (int) Math.pow(2, exponent) - 1;
		System.out.println("Length of Segment Tree : " + size);

		int[] segmentTreeMin = new int[size];
		initialiseTree(segmentTreeMin, Integer.MAX_VALUE);
		constructMinTree(input, segmentTreeMin, 0, n - 1, 0);
		System.out.println("Sum segment tree : ");
		printSegmentTree(segmentTreeMin);
		
		int[] lazyTree = new int[size];
		int query = in.nextInt();
		for (int q = 1; q <= query; q++) {
			int qLow = in.nextInt();
			int qHigh = in.nextInt();
			System.out.println("Sum of elements from " + qLow + " to " + qHigh + " = "
					+ rangeMinQuery(segmentTreeMin, lazyTree, 0, n - 1, qLow, qHigh, 0));
		}
		in.close();
	}
	
	private static void initialiseTree(int[] segmentTree, int value) {
		for (int i = 0; i < segmentTree.length; i++) {
			segmentTree[i] = value;
		}
	}
	
	private static void constructMinTree(int[] input, int[] segmentTree, int low, int high, int index) {
		if (low == high) {
			segmentTree[index] = input[low];
			return;
		}
		int mid = low + (high - low) / 2;
		constructMinTree(input, segmentTree, low, mid, index * 2 + 1);
		constructMinTree(input, segmentTree, mid + 1, high, index * 2 + 2);
		segmentTree[index] = Math.min(segmentTree[index * 2 + 1], segmentTree[index * 2 + 2]);
	}
	
	private static int rangeMinQuery(int[] segmentTree, int[] lazyTree, int low, int high, int qLow, int qHigh, int index) {
		
		if (low > high) {
			return Integer.MAX_VALUE;
		}
		
		if (lazyTree[index] != 0) {
			segmentTree[index] += lazyTree[index];
			if (low != high) {
				lazyTree[index * 2 + 1] = lazyTree[index];
				lazyTree[index * 2 + 2] = lazyTree[index];
			}
		}
		
		// No Overlap
		if (qHigh < low || high < qLow) {
			return Integer.MAX_VALUE;
		}

		// Total Overlap
		if (qLow <= low && high <= qHigh) {
			return segmentTree[index];
		}

		// Partial Overlap
		int mid = low + (high - low) / 2;
		return Math.min(rangeMinQuery(segmentTree, lazyTree, low, mid, qLow, qHigh, index * 2 + 1),
				rangeMinQuery(segmentTree, lazyTree, mid + 1, high, qLow, qHigh, index * 2 + 2));
	}

	
	private static void rangeUpdateQueryForMinTree(int[] segmentTree, int[] lazyTree, int low, int high, int qLow,
			int qHigh, int value, int index) {
		
		if (low > high) {
			return;
		}
		
		// If the value of lazyTree[index] != 0, add that value to segmentTree and push the updates one level down in the lazy tree
		if (lazyTree[index] != 0) {
			segmentTree[index] += lazyTree[index];
			if (low != high) {
				lazyTree[index * 2 + 1] = lazyTree[index];
				lazyTree[index * 2 + 2] = lazyTree[index];
			}
			lazyTree[index] = 0;
		}
		
		// No Overlap
		if (qHigh < low || high < qLow) {
			return;
		}
		
		// Total Overlap
		if (qLow <= low && high <= qHigh) {
			segmentTree[index] += value;
			if (low != high) {
				lazyTree[index * 2 + 1] += value;
				lazyTree[index * 2 + 2] += value;
			}
			return;
		}
		
		// Partial Overlap
		int mid = low + (high - low) / 2;
		rangeUpdateQueryForMinTree(segmentTree, lazyTree, low, mid, qLow, qHigh, value, index * 2 + 1);
		rangeUpdateQueryForMinTree(segmentTree, lazyTree, mid + 1, high, qLow, qHigh, value, index * 2 + 2);
		segmentTree[index] = Math.min(segmentTree[index * 2 + 1], segmentTree[index * 2 + 2]);
	}
	
	private static void printSegmentTree(int[] segmentTree) {
		int i = 0;
		while (i < segmentTree.length - 1) {
			System.out.print(segmentTree[i++] + ", ");
		}
		System.out.print(segmentTree[i]);
		System.out.println();
	}
	
}

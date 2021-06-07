package com.datastructures;

import java.util.Scanner;

public class SegmentTreeMax {

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

		int[] segmentTreeMax = new int[size];
		initialiseTree(segmentTreeMax, Integer.MIN_VALUE);
		constructMaxTree(input, segmentTreeMax, 0, n - 1, 0);
		System.out.println("Sum segment tree : ");
		printSegmentTree(segmentTreeMax);
		
		int[] lazyTree = new int[size];
		int query = in.nextInt();
		for (int q = 1; q <= query; q++) {
			int qLow = in.nextInt();
			int qHigh = in.nextInt();
			System.out.println("Sum of elements from " + qLow + " to " + qHigh + " = "
					+ rangeMaxQuery(segmentTreeMax, lazyTree, 0, n - 1, qLow, qHigh, 0));
		}
		in.close();
	}
	
	private static void initialiseTree(int[] segmentTree, int value) {
		for (int i = 0; i < segmentTree.length; i++) {
			segmentTree[i] = value;
		}
	}
	
	private static void constructMaxTree(int[] input, int[] segmentTree, int low, int high, int index) {
		if (low == high) {
			segmentTree[index] = input[low];
			return;
		}
		int mid = low + (high - low) / 2;
		constructMaxTree(input, segmentTree, low, mid, index * 2 + 1);
		constructMaxTree(input, segmentTree, mid + 1, high, index * 2 + 2);
		segmentTree[index] = Math.max(segmentTree[index * 2 + 1], segmentTree[index * 2 + 2]);
	}
	
	private static int rangeMaxQuery(int[] segmentTree, int[] lazyTree, int low, int high, int qLow, int qHigh, int index) {
		
		if (low > high) {
			return Integer.MIN_VALUE;
		}
		
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
			return Integer.MIN_VALUE;
		}

		// Total Overlap
		if (qLow <= low && high <= qHigh) {
			return segmentTree[index];
		}

		// Partial Overlap
		int mid = low + (high - low) / 2;
		return Math.max(rangeMaxQuery(segmentTree, lazyTree, low, mid, qLow, qHigh, index * 2 + 1),
				rangeMaxQuery(segmentTree, lazyTree, mid + 1, high, qLow, qHigh, index * 2 + 2));
	}
	
	private static void rangeUpdateQueryForMaxTree(int[] segmentTree, int[] lazyTree, int low, int high, int qLow,
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
		rangeUpdateQueryForMaxTree(segmentTree, lazyTree, low, mid, qLow, qHigh, value, index * 2 + 1);
		rangeUpdateQueryForMaxTree(segmentTree, lazyTree, mid + 1, high, qLow, qHigh, value, index * 2 + 2);
		segmentTree[index] = Math.max(segmentTree[index * 2 + 1], segmentTree[index * 2 + 2]);
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

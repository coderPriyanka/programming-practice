package com.datastructures;

import java.util.Scanner;

public class SegmentTreeSum {

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

		int[] segmentTreeSum = new int[size];
		constructSumTree(input, segmentTreeSum, 0, n - 1, 0);
		System.out.println("Sum segment tree : ");
		printSegmentTree(segmentTreeSum);

		int[] lazyTree = new int[size];
		int query = in.nextInt();
		for (int q = 1; q <= query; q++) {
			int qLow = in.nextInt();
			int qHigh = in.nextInt();
			System.out.println("Sum of elements from " + qLow + " to " + qHigh + " = "
					+ rangeSumQuery(segmentTreeSum, lazyTree, 0, n - 1, qLow, qHigh, 0));
		}
		in.close();
	}

	private static void constructSumTree(int[] input, int[] segmentTree, int low, int high, int index) {
		if (low == high) {
			segmentTree[index] = input[low];
			return;
		}
		int mid = low + (high - low) / 2;
		constructSumTree(input, segmentTree, low, mid, index * 2 + 1);
		constructSumTree(input, segmentTree, mid + 1, high, index * 2 + 2);
		segmentTree[index] = segmentTree[index * 2 + 1] + segmentTree[index * 2 + 2];
	}

	private static int rangeSumQuery(int[] segmentTree, int[] lazyTree, int low, int high, int qLow, int qHigh,
			int index) {

		if (low > high) {
			return 0;
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
			return 0;
		}

		// Total Overlap
		if (qLow <= low && high <= qHigh) {
			return segmentTree[index];
		}

		// Partial Overlap
		int mid = low + (high - low) / 2;
		return rangeSumQuery(segmentTree, lazyTree, low, mid, qLow, qHigh, index * 2 + 1)
				+ rangeSumQuery(segmentTree, lazyTree, mid + 1, high, qLow, qHigh, index * 2 + 2);
	}

	private static void rangeUpdateQueryForSumTree(int[] segmentTree, int[] lazyTree, int low, int high, int qLow,
			int qHigh, int value, int index) {
		
		if (low > high) {
			return;
		}

		// If the value of lazyTree[index] != 0, add that value to segmentTree and push
		// the updates one level down in the lazy tree
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
		rangeUpdateQueryForSumTree(segmentTree, lazyTree, low, mid, qLow, qHigh, value, index * 2 + 1);
		rangeUpdateQueryForSumTree(segmentTree, lazyTree, mid + 1, high, qLow, qHigh, value, index * 2 + 2);
		segmentTree[index] = segmentTree[index * 2 + 1] + segmentTree[index * 2 + 2];
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

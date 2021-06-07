package com.hackerrank.heaps;

import java.util.Scanner;

public class ArrayManipulation {

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

		int[] sTreeSum = new int[size];
		int[] lazyTree = new int[size];
		constructSumTree(input, sTreeSum, 0, n - 1, 0);
		System.out.println("Sum segment tree : ");
		printSegmentTree(sTreeSum);

		int[] sTreeMax = new int[size];
		initialiseTree(sTreeMax, Integer.MIN_VALUE);
		constructMaxTree(input, sTreeMax, 0, n - 1, 0);
		System.out.println("Max segment tree : ");
		printSegmentTree(sTreeMax);

		int[] sTreeMin = new int[size];
		initialiseTree(sTreeMin, Integer.MAX_VALUE);
		constructMinTree(input, sTreeMin, 0, n - 1, 0);
		System.out.println("Min segment tree : ");
		printSegmentTree(sTreeMin);

		int query = in.nextInt();
		for (int q = 1; q <= query; q++) {
			int qLow = in.nextInt();
			int qHigh = in.nextInt();
			System.out.println("Sum of elements from " + qLow + " to " + qHigh + " = "
					+ rangeSumQuery(sTreeSum, lazyTree, 0, n - 1, qLow, qHigh, 0));
			System.out.println("Max of elements from " + qLow + " to " + qHigh + " = "
					+ rangeMaxQuery(sTreeMax, lazyTree, 0, n - 1, qLow, qHigh, 0));
			System.out.println("Min of elements from " + qLow + " to " + qHigh + " = "
					+ rangeMinQuery(sTreeMin, lazyTree, 0, n - 1, qLow, qHigh, 0));
		}
		in.close();
	}

	private static void initialiseTree(int[] segmentTree, int value) {
		for (int i = 0; i < segmentTree.length; i++) {
			segmentTree[i] = value;
		}
	}

	private static void printSegmentTree(int[] segmentTree) {
		int i = 0;
		while (i < segmentTree.length - 1) {
			System.out.print(segmentTree[i++] + ", ");
		}
		System.out.print(segmentTree[i]);
		System.out.println();
	}

	private static void constructSumTree(int[] input, int[] sTree, int low, int high, int index) {
		if (low == high) {
			sTree[index] = input[low];
			return;
		}
		int mid = low + (high - low) / 2;
		constructSumTree(input, sTree, low, mid, index * 2 + 1);
		constructSumTree(input, sTree, mid + 1, high, index * 2 + 2);
		sTree[index] = sTree[index * 2 + 1] + sTree[index * 2 + 2];
	}

	private static void constructMaxTree(int[] input, int[] sTree, int low, int high, int index) {
		if (low == high) {
			sTree[index] = input[low];
			return;
		}
		int mid = low + (high - low) / 2;
		constructMaxTree(input, sTree, low, mid, index * 2 + 1);
		constructMaxTree(input, sTree, mid + 1, high, index * 2 + 2);
		sTree[index] = Math.max(sTree[index * 2 + 1], sTree[index * 2 + 2]);
	}

	private static void constructMinTree(int[] input, int[] sTree, int low, int high, int index) {
		if (low == high) {
			sTree[index] = input[low];
			return;
		}
		int mid = low + (high - low) / 2;
		constructMinTree(input, sTree, low, mid, index * 2 + 1);
		constructMinTree(input, sTree, mid + 1, high, index * 2 + 2);
		sTree[index] = Math.min(sTree[index * 2 + 1], sTree[index * 2 + 2]);
	}

	private static int rangeSumQuery(int[] sTree, int[] lazyTree, int low, int high, int qLow, int qHigh, int index) {
		// No Overlap
		if (noOverlap(low, high, qLow, qHigh)) {
			return 0;
		}

		// Total Overlap
		if (totalOverlap(low, high, qLow, qHigh)) {
			return sTree[index];
		}

		// Partial Overlap
		int mid = low + (high - low) / 2;
		return rangeSumQuery(sTree, lazyTree, low, mid, qLow, qHigh, index * 2 + 1)
				+ rangeSumQuery(sTree, lazyTree, mid + 1, high, qLow, qHigh, index * 2 + 2);
	}

	private static int rangeMaxQuery(int[] sTree, int[] lazyTree, int low, int high, int qLow, int qHigh, int index) {
		// No Overlap
		if (noOverlap(low, high, qLow, qHigh)) {
			return Integer.MIN_VALUE;
		}

		// Total Overlap
		if (totalOverlap(low, high, qLow, qHigh)) {
			return sTree[index];
		}

		// Partial Overlap
		int mid = low + (high - low) / 2;
		return Math.max(rangeMaxQuery(sTree, lazyTree, low, mid, qLow, qHigh, index * 2 + 1),
				rangeMaxQuery(sTree, lazyTree, mid + 1, high, qLow, qHigh, index * 2 + 2));
	}

	private static int rangeMinQuery(int[] sTree, int[] lazyTree, int low, int high, int qLow, int qHigh, int index) {
		// No Overlap
		if (noOverlap(low, high, qLow, qHigh)) {
			return Integer.MAX_VALUE;
		}
		
		if (lazyTree[index] != 0) {
			sTree[index] += lazyTree[index];
			if (low != high) {
				
			}
		}

		// Total Overlap
		if (totalOverlap(low, high, qLow, qHigh)) {
			return sTree[index];
		}

		// Partial Overlap
		int mid = low + (high - low) / 2;
		return Math.min(rangeMinQuery(sTree, lazyTree, low, mid, qLow, qHigh, index * 2 + 1),
				rangeMinQuery(sTree, lazyTree, mid + 1, high, qLow, qHigh, index * 2 + 2));
	}

	private static void rangeUpdateQueryForSumTree(int[] segmentTree, int[] lazyTree, int low, int high, int qLow,
			int qHigh, int value, int index) {
		if (low > high) {
			return;
		}
		if (lazyTree[index] != 0) {
			segmentTree[index] += lazyTree[index];
			if (low != high) {
				lazyTree[index * 2 + 1] = lazyTree[index];
				lazyTree[index * 2 + 2] = lazyTree[index];
			}
			lazyTree[index] = 0;
		}
		if (qHigh < low || high < qLow) {
			return;
		}
		if (qLow <= low && high <= qHigh) {
			segmentTree[index] += value;
			if (low != high) {
				lazyTree[index * 2 + 1] += value;
				lazyTree[index * 2 + 2] += value;
			}
		}
		int mid = low + (high - low) / 2;
		rangeUpdateQueryForSumTree(segmentTree, lazyTree, low, mid, qLow, qHigh, value, index * 2 + 1);
		rangeUpdateQueryForSumTree(segmentTree, lazyTree, mid + 1, high, qLow, qHigh, value, index * 2 + 2);
		segmentTree[index] = segmentTree[index * 2 + 1] + segmentTree[index * 2 + 2];
	}

	private static void rangeUpdateQueryForMaxTree(int[] segmentTree, int[] lazyTree, int low, int high, int qLow,
			int qHigh, int value, int index) {
		if (low > high) {
			return;
		}
		if (lazyTree[index] != 0) {
			segmentTree[index] += lazyTree[index];
			if (low != high) {
				lazyTree[index * 2 + 1] = lazyTree[index];
				lazyTree[index * 2 + 2] = lazyTree[index];
			}
			lazyTree[index] = 0;
		}
		if (qHigh < low || high < qLow) {
			return;
		}
		if (qLow <= low && high <= qHigh) {
			segmentTree[index] += value;
			if (low != high) {
				lazyTree[index * 2 + 1] += value;
				lazyTree[index * 2 + 2] += value;
			}
		}
		int mid = low + (high - low) / 2;
		rangeUpdateQueryForMaxTree(segmentTree, lazyTree, low, mid, qLow, qHigh, value, index * 2 + 1);
		rangeUpdateQueryForMaxTree(segmentTree, lazyTree, mid + 1, high, qLow, qHigh, value, index * 2 + 2);
		segmentTree[index] = Math.max(segmentTree[index * 2 + 1], segmentTree[index * 2 + 2]);
	}

	private static void rangeUpdateQueryForMinTree(int[] segmentTree, int[] lazyTree, int low, int high, int qLow,
			int qHigh, int value, int index) {
		if (low > high) {
			return;
		}
		if (lazyTree[index] != 0) {
			segmentTree[index] += lazyTree[index];
			if (low != high) {
				lazyTree[index * 2 + 1] = lazyTree[index];
				lazyTree[index * 2 + 2] = lazyTree[index];
			}
			lazyTree[index] = 0;
		}
		if (qHigh < low || high < qLow) {
			return;
		}
		if (qLow <= low && high <= qHigh) {
			segmentTree[index] += value;
			if (low != high) {
				lazyTree[index * 2 + 1] += value;
				lazyTree[index * 2 + 2] += value;
			}
		}
		int mid = low + (high - low) / 2;
		rangeUpdateQueryForMinTree(segmentTree, lazyTree, low, mid, qLow, qHigh, value, index * 2 + 1);
		rangeUpdateQueryForMinTree(segmentTree, lazyTree, mid + 1, high, qLow, qHigh, value, index * 2 + 2);
		segmentTree[index] = Math.min(segmentTree[index * 2 + 1], segmentTree[index * 2 + 2]);
	}

	private static boolean noOverlap(int low, int high, int qLow, int qHigh) {
		return qHigh < low || high < qLow;
	}

	private static boolean totalOverlap(int low, int high, int qLow, int qHigh) {
		return qLow <= low && high <= qHigh;
	}

}

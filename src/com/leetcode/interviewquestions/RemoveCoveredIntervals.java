package com.leetcode.interviewquestions;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveCoveredIntervals {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] intervals = new int[n][2];
		for (int i = 0; i < n; i++) {
			intervals[i][0] = in.nextInt();
			intervals[i][1] = in.nextInt();
		}
		System.out.println(uniqueIntervals(intervals));
		in.close();
	}
	
	private static int uniqueIntervals(int[][] intervals) {
		int result = 0;
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		int start = intervals[0][0], end = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] == start || intervals[i][1] <= end) {
				end = Math.max(end, intervals[i][1]);
				result++;
			} else {
				start = intervals[i][0];
				end = intervals[i][1];
			}
		}
		return result;
	}
}

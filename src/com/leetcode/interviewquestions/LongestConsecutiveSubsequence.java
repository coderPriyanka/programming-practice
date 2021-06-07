package com.leetcode.interviewquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LongestConsecutiveSubsequence {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
        	nums[i] = scanner.nextLong();
        }
        System.out.println(findLongestConsecutiveSubsequence(nums));
        scanner.close();
	}
	
	private static int findLongestConsecutiveSubsequence(long[] nums) {
		return 0;
	}

}

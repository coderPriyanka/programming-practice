package com.hackerrank.arrays;

import java.io.*;
import java.util.Scanner;

public class ArrayManipulation {

    static long arrayManipulation(int n, int[][] queries) {
    	long[] maxSum = new long[n + 1];
        for (int i = 0; i < queries.length; i++) {
            int leftIndex = queries[i][0] - 1;
            int rightIndex = queries[i][1] - 1;
            int value = queries[i][2];
            maxSum[leftIndex] += value;
            maxSum[rightIndex + 1] -= value;
        }
        long sum = 0, result = 0;
        for (int i = 0; i < n; i++) {
            sum += maxSum[i];
            result = Math.max(result, sum);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
         int n = scanner.nextInt();
         int m = scanner.nextInt();
         int[][] queries = new int[m][3];
         scanner.nextLine();
         for (int i = 0; i < m; i++) {
             String input = scanner.nextLine();
             queries[i][0] = Integer.parseInt(input.split(" ")[0]);
             queries[i][1] = Integer.parseInt(input.split(" ")[1]);
             queries[i][2] = Integer.parseInt(input.split(" ")[2]);
         }
         System.out.println(arrayManipulation(n, queries));
         scanner.close();
    }
}

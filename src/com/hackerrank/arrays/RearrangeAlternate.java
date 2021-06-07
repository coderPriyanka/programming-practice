package com.hackerrank.arrays;

import java.util.Scanner;

public class RearrangeAlternate {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		rearrange(arr, n);
		for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
		in.close();
	}
	
	private static void rearrange(int arr[], int n) {
        int maxIndex = n - 1, minIndex = 0, mod = arr[n - 1] + 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i] + (arr[maxIndex] % mod) * mod;
                maxIndex--;
            } else {
                arr[i] = arr[i] + (arr[minIndex] % mod) * mod;
                minIndex++;
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] /= mod;
        }
    }

}

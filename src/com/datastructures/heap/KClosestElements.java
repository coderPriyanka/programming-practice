package com.datastructures.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

	An integer a is closer to x than an integer b if:
	
	|a - x| < |b - x|, or
	|a - x| == |b - x| and a < b
	 
	
	Example 1:
	
	Input: arr = [1,2,3,4,5], k = 4, x = 3
	Output: [1,2,3,4]
	Example 2:
	
	Input: arr = [1,2,3,4,5], k = 4, x = -1
	Output: [1,2,3,4]

 * @author priyasar
 *
 */

public class KClosestElements {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int k = in.nextInt();
		int x = in.nextInt();
		List<Integer> result = findClosestElements(arr, k, x);
		for(Integer number : result) {
			System.out.print(number + " ");
		}
		System.out.println();
		in.close();
	}
	
	private static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if (x <= arr[0]) {
            int count = 0, index = 0;
            while (count < k) {
                result.add(arr[index++]);
                count++;
            }
            return result;
        }
        if (x >= arr[arr.length - 1]) {
            int count = 0, index = arr.length - 1;
            while (count < k) {
                result.add(arr[index--]);
                count++;
            }
            return result;
        }
        Comparator<Pair> comparator = (p1, p2) -> {
            return p1.getKey() > p2.getKey() ? 1 : -1;
        };
        PriorityQueue<Pair> pq = new PriorityQueue<>(arr.length, comparator);
        for (int i = 0; i < arr.length; i++) {
            Pair pair = new Pair((Math.abs(arr[i] - x)), arr[i]);
            pq.add(pair);
        }
        while (!pq.isEmpty()) {
            result.add(pq.remove().getValue());
        }
        return result;
    }
	
	static class Pair {
		private int key;
		private int value;
		public Pair(int key, int value) {
			this.key = key;
			this.value = value;
		}
		public int getKey() {
			return this.key;
		}
		public int getValue() {
			return this.value;
		}
	}

}

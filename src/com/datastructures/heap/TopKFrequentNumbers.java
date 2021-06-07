package com.datastructures.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TopKFrequentNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int k = in.nextInt();
		int[] result = findKFrequentElements(arr, k);
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
		in.close();
	}
	
	public static int[] findKFrequentElements(int[] arr, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> numberToCount = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            if (numberToCount.containsKey(arr[i])) {
                count += numberToCount.get(arr[i]);
            }
            numberToCount.put(arr[i], count);
        }
        Comparator<Pair> comparator = (p1, p2) -> {
            return p1.getValue() < p2.getValue() ? 1 : -1;
        };
        PriorityQueue<Pair> pq = new PriorityQueue<>(arr.length, comparator);
        for (Integer number : numberToCount.keySet()) {
            Pair pair = new Pair(number, numberToCount.get(number));
            pq.add(pair);
        }
        int count = 1, index = 0;
        while (count <= k) {
            result[index++] = pq.remove().getKey();
            count++;
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

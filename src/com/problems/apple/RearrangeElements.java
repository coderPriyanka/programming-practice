package com.problems.apple;

import java.util.Arrays;
import java.util.Collections;
import java.util.*;
import java.util.Scanner;

/**
 * Given an array of numbers, move all zeroes in the array to the end while maintaining the relative order of the other numbers.
Note: You must modify the array you’re given (i.e. you cannot create a new array).

E.g.: Given the following array of numbers

numbers = [3, 7, 0, 5, 0, 2], rearrange numbers to look like the following [3,7,5,2,0,0]
 * @author priyasar
 *
 */

public class RearrangeElements {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        in.nextLine();
        for (int test = 1; test <= tests; test++) {
            String input = in.nextLine();
            int m = in.nextInt();
            in.nextLine();
            for (int i = 0; i < m; i++) {
                char ch1 = in.next().charAt(0);
                char ch2 = in.next().charAt(0);
                System.out.println(ch1 + ", " + ch2);
            }
            System.out.println("YES");
        }
        in.close();
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		List<Integer> numbers = new ArrayList<>();
//		for (int i = 0; i < n; i++) {
//			numbers.add(in.nextInt());
//		}
//		Collections.sort(numbers);
//		for (int i = 0; i < n; i++) {
//			System.out.print(numbers.get(i) + " ");
//		}
//		System.out.println();
//		Collections.sort(numbers, (a, b) -> -1 * a.compareTo(b));
//		for (int i = 0; i < n; i++) {
//			System.out.print(numbers.get(i) + " ");
//		}
//		int index = findFirstIndexOfZero(numbers);
//		if (index == -1) {
//			System.out.println("No zeroes exist");
//		} else {
//			rearrangeElements(numbers, index);
//			for (int i = 0; i < n; i++) {
//				System.out.print(numbers[i] + " ");
//			}
//		}
	}
	
	private static void rearrangeElements(int[] numbers, int index) {
		int i = index + 1, start = index, end = index;
		while (i < numbers.length) {
			if (numbers[i] != 0) {
				numbers[start] = numbers[i];
				numbers[i] = 0;
				start++;
			}
			end++;
			i++;
		}
	}

	private static int findFirstIndexOfZero(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 0) {
				return i;
			}
		}
		return -1;
	}

}

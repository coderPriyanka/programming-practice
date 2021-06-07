package com.algorithms.numbers;

import java.util.Scanner;

public class RepeatingAndMissing {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
	    int[] arr = new int[n];
	    for (int i = 0; i < n; i++) {
	        arr[i] = in.nextInt();
	    }
	    int[] result = repeatedNumber(arr);
        System.out.println(result[0] + " " + result[1]);
		in.close();
	}
	private static int[] repeatedNumber(final int[] A) {
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
            xor ^= i + 1;
        }
        int index = rightmostBit(xor);
        int number1 = 0, number2 = 0;
        for (int i = 0; i < A.length; i++) {
            if (isSet(A[i], index)) {
                number1 ^= A[i];
            } else {
                number2 ^= A[i];
            }
        }
        for (int i = 1; i <= A.length; i++) {
            if (isSet(i, index)) {
                number1 ^= i;
            } else {
                number2 ^= i;
            }
        }
        int[] result = new int[2];
        boolean flag = false;
        for (int i = 0; i < A.length; i++) {
            if (number1 == A[i]) {
                flag = true;
                result[0] = number1;
                result[1] = number2;
                break;
            }
        }
        if (!flag) {
            result[0] = number2;
            result[1] = number1;
        }
        return result;
    }
    private static int rightmostBit(int number) {
        int i = 1, position = 0;
        while (((i << position) & number) == 0) {
            position++;
        }
        return position;
    }
    private static boolean isSet(int number, int bitPosition) {
        return (number & (1 << bitPosition)) == 0 ? false : true;
    }
}

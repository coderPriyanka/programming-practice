package com.problems.facebook;

import java.util.Scanner;

public class HammingDistance {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int larger = in.nextInt();
		int smaller = in.nextInt();
		int count = 0;
		if (larger < smaller) {
			int temp = larger;
			larger = smaller;
			smaller = temp;
		}
		while (larger > 0) {
			if (larger % 2 != smaller % 2) {
				count++;
			}
            larger = larger / 2;
			smaller = smaller / 2;
		}
		System.out.println(count);
		in.close();
	}

}

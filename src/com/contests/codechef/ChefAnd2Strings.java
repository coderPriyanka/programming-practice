package com.contests.codechef;

import java.util.Scanner;

public class ChefAnd2Strings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = in.nextInt();
		in.nextLine();
		for (int test = 1; test <= tests; test++) {
			String chef = in.nextLine();
			String computer = in.nextLine();
			int i = 0, j = 0, flag = 0;
			while (i < computer.length() && j < chef.length()) {
				if (computer.charAt(i) == chef.charAt(j)) {
					j++;
				} else {
					i++;
				}
				if (j == chef.length()) {
					flag = 1;
					break;
				}
			}
			if (flag == 1) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		in.close();
	}

}

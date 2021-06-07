package com.contests.codechef;

import java.util.Arrays;
import java.util.Scanner;

public class OrganisationUWCOI21C {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = in.nextInt();
		for (int test = 1; test <= tests; test++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int[][] ducks = new int[n + 1][2];
			for (int i = 0; i <= n; i++) {
				ducks[i][0] = in.nextInt();
				ducks[i][1] = i;
			}
			Arrays.sort(ducks, (a, b) -> Integer.compare(a[0], b[0]));
			int i = 0, j = ducks.length - 1;
			while (i <= j) {
				int countOfDucks = ducks[i][0];
				System.out.print(ducks[i][1] + " " + ducks[i][0] + " ");
				ducks[i][0] = 0;
				System.out.print(ducks[j][1] + " " + (k - countOfDucks));
				ducks[j][0] -= (k - countOfDucks);
				if (ducks[i][0] == 0) {
					i++;
				}
				if (ducks[j][0] == 0) {
					j--;
				}
				System.out.println();
			}
		}
		in.close();
	}

}

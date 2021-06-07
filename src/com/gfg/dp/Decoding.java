package com.gfg.dp;

import java.util.Scanner;

public class Decoding {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		System.out.println(findEncodings(input));
		in.close();
	}

	public static int findEncodings(String data) {
		if (data.length() == 0 || data.length() == 1) {
			return data.length();
		}
		if (data.charAt(0) == '0') {
			return 0;
		}
		int[] decodings = new int[data.length() + 1];
		decodings[0] = decodings[1] = 1;
		for (int i = 2; i <= data.length(); i++) {
			decodings[i] = decodings[i - 1];
			int value = findValue(data, i - 2, i - 1);
			if(value >= 10 && value <= 26) {
				decodings[i] += decodings[i - 2];	
			}
		}
		return decodings[data.length()];
	}


	private static int findValue(String input, int i, int j) {
		int value1 = input.charAt(i) - '0';
		int value2 = input.charAt(j) - '0';
		return value1 * 10 + value2;
	}

}

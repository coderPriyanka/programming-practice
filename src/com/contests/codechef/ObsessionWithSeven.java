package com.contests.codechef;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ObsessionWithSeven {

	private static int count = 0;
	private static Set<Integer> set;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = in.nextInt();
		in.nextLine();
		for (int test = 1; test <= tests; test++) {
			count = 0;
			set = new HashSet<>();
			String number = in.nextLine();
			permute(number, 0, number.length() - 1);
			for (Integer value : set) {
				if (value % 7 == 0) {
	            	count++;
	            }
			}
			System.out.println(count);
		}
		in.close();
	}
	private static void permute(String str, int l, int r) { 
        if (l == r) {
            int number = Integer.parseInt(str);
            set.add(number);
        }
        else { 
            for (int i = l; i <= r; i++) {
                str = swap(str,l,i); 
                permute(str, l+1, r); 
                str = swap(str,l,i); 
            }
        } 
    } 
 
    /** 
    * Swap Characters at position 
    * @param a string value 
    * @param i position 1 
    * @param j position 2 
    * @return swapped string 
    */
    public static String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    }

}

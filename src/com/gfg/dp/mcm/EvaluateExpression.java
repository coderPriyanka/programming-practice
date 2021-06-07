package com.gfg.dp.mcm;

import java.util.Scanner;

/**
 *  Given a boolean expression S of length N with following symbols.
	Symbols
	    'T' ---> true
	    'F' ---> false
	and following operators filled between symbols
	Operators
	    &   ---> boolean AND
	    |   ---> boolean OR
	    ^   ---> boolean XOR
	Count the number of ways we can parenthesise the expression so that the value of expression evaluates to true.
	
	 
	
	Example 1:
	
	Input: N = 7
	S = T|T&F^T
	Output: 4
	Explanation: The expression evaluates 
	to true in 4 ways ((T|T)&(F^T)), 
	(T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).
	 
	
	Example 2:
	
	Input: N = 5
	S = T^F|F
	Output: 2
	Explanation: ((T^F)|F) and (T^(F|F)) are the 
	only ways.
	 
	
	Your Task:
	You do not need to read input or print anything. Your task is to complete the function countWays() which takes N and S as input parameters and returns number of possible ways modulo 1003.


 * @author priyasar
 *
 */

public class EvaluateExpression {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		System.out.println(countWays(input.length(), input));
		in.close();
	}
	private static int countWays(int N, String S){
        if (S.length() == 0) {
            return 0;
        }
        int[][][] dp = new int[N][N][2];
        initialise(dp);
        return countWays(S, 0, N - 1, true, dp);
    }
    private static void initialise(int[][][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k < dp[i][j].length; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
    }
    private static int countWays(String expression, int start, int end, boolean isTrue, int[][][] dp) {
        if (start > end) {
            return 0;
        }
        int k = 0;
        if (start == end) {
            if (isTrue) {
                k = 1;
                return expression.charAt(start) == 'T' ? 1 : 0;
            }
            return expression.charAt(start) == 'F' ? 1 : 0;
        }
        if (dp[start][end][k] != -1) {
            return dp[start][end][k];
        }
        int count = 0;
        for (int mid = start + 1; mid < end; mid += 2) {
            int leftTrue = countWays(expression, start, mid - 1, true, dp);
            int leftFalse = countWays(expression, start, mid - 1, false, dp);
            int rightTrue = countWays(expression, mid + 1, end, true, dp);
            int rightFalse = countWays(expression, mid + 1, end, false, dp);
            if (expression.charAt(mid) == '&') {
                if (isTrue) {
                    count += leftTrue * rightTrue;
                } else {
                    count += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
                }
            }
            if (expression.charAt(mid) == '|') {
                if (isTrue) {
                    count += leftTrue * rightFalse + leftFalse * rightTrue + leftTrue * rightTrue;
                } else {
                    count += leftFalse * rightFalse;
                }
            }
            if (expression.charAt(mid) == '^') {
                if (isTrue) {
                    count += leftTrue * rightFalse + leftFalse * rightTrue;
                } else {
                    count += leftFalse * rightFalse + leftTrue * rightTrue;
                }
            }
            count = count % 1003;
        }
        dp[start][end][k] = count;
        return count;
    }
}

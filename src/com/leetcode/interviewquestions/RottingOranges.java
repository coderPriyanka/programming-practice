package com.leetcode.interviewquestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RottingOranges {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] grid = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] = in.nextInt();
			}
		}
		System.out.println(orangesRotting(grid));
		in.close();
	}
	
	public static int orangesRotting(int[][] grid) {
        int freshOranges = 0, rottenOranges = 0;
        Queue<Integer> rottenOrangesRow = new LinkedList<>();
        Queue<Integer> rottenOrangesCol = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            visited[i] = new boolean[grid[i].length];
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                }
                if (grid[i][j] == 2) {
                    System.out.println("Rotten orange present at : (" + i + ", " + j + ")");
                    rottenOrangesRow.add(i);
                    rottenOrangesCol.add(j);
                    rottenOranges++;
                }
            }
        }
        if (freshOranges == 0) {
        	return 0;
        }
        System.out.println("Total fresh oranges : " + freshOranges);
        int timeRequired = 0;
        int newRottenOranges = 0;
        System.out.println("Rotten oranges present : " + rottenOranges);
        System.out.println();
        while (!rottenOrangesRow.isEmpty()) {
            int rottenRowIndex = rottenOrangesRow.remove();
            int rottenColIndex = rottenOrangesCol.remove();
            rottenOranges--;

            int nextRottenOranges = addAdjacentFreshOranges(grid, visited, rottenOrangesRow, rottenOrangesCol, rottenRowIndex, rottenColIndex);
            newRottenOranges += nextRottenOranges;
            System.out.println("Oranges got rot : " + newRottenOranges);
            freshOranges -= nextRottenOranges;
            if (freshOranges <= 0) {
            	timeRequired++;
                break;
            }
            System.out.println("Fresh oranges remaining : " + freshOranges);
            if (rottenOranges == 0 && newRottenOranges != 0) {
                rottenOranges = newRottenOranges;
                newRottenOranges = 0;
                timeRequired++;
            }
        }
        if (freshOranges > 0) {
            timeRequired = -1;
        }
        return timeRequired;
    }
    
    private static int addAdjacentFreshOranges(int[][] grid, boolean[][] visited, Queue<Integer> rottenOrangesRow, Queue<Integer> rottenOrangesCol, int rottenRowIndex, int rottenColIndex) {
        int rottedOranges = 0;
        if (rottenRowIndex + 1 < grid.length && grid[rottenRowIndex + 1][rottenColIndex] == 1 && !visited[rottenRowIndex + 1][rottenColIndex]){
            grid[rottenRowIndex + 1][rottenColIndex] = 2;
            rottenOrangesRow.add(rottenRowIndex + 1);
            rottenOrangesCol.add(rottenColIndex);
            rottedOranges++;
        }
        if (rottenRowIndex - 1 >= 0 && grid[rottenRowIndex - 1][rottenColIndex] == 1 && !visited[rottenRowIndex - 1][rottenColIndex]){
            grid[rottenRowIndex - 1][rottenColIndex] = 2;
            rottenOrangesRow.add(rottenRowIndex - 1);
            rottenOrangesCol.add(rottenColIndex);
            rottedOranges++;
        }
        if (rottenColIndex + 1 < grid[rottenRowIndex].length && grid[rottenRowIndex][rottenColIndex + 1] == 1 && !visited[rottenRowIndex][rottenColIndex + 1]){
            grid[rottenRowIndex][rottenColIndex + 1] = 2;
            rottenOrangesRow.add(rottenRowIndex);
            rottenOrangesCol.add(rottenColIndex + 1);
            rottedOranges++;
        }
        if (rottenColIndex - 1 >= 0 && grid[rottenRowIndex][rottenColIndex - 1] == 1 && !visited[rottenRowIndex][rottenColIndex - 1]){
            grid[rottenRowIndex][rottenColIndex - 1] = 2;
            rottenOrangesRow.add(rottenRowIndex);
            rottenOrangesCol.add(rottenColIndex - 1);
            rottedOranges++;
        }
        return rottedOranges;
    }

}

package com.mulththreading;

import java.util.*;

public class ProducerConsumer {
	
	private static Map<Character, Character> parents;
    private static Map<Character, Integer> size;
    
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        in.nextLine();
        for (int test = 1; test <= tests; test++) {
            String input = in.nextLine();
            parents = new HashMap<>();
            size = new HashMap<>();
            for (int i = 0; i < input.length(); i++) {
                parents.put(input.charAt(i), input.charAt(i));
                size.put(input.charAt(i), 1);
            }
            int m = in.nextInt();
            in.nextLine();
            for (int i = 0; i < m; i++) {
                char ch1 = in.next().charAt(0);
                char ch2 = in.next().charAt(0);
                System.out.println(ch1 + ", " + ch2);
                char p1 = getParent(ch1);
                char p2 = getParent(ch2);
                int s1 = size.get(ch1);
                int s2 = size.get(ch2);
                if (s1 >= s2) {
                    addParent(p1, p2);
                    size.remove(p2);
                    size.put(p1, s1 + s2);
                } else {
                    parents.put(p1, p2);
                    size.remove(p1);
                    size.put(p2, s1 + s2);
                }
            }
            if (size.size() == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        in.close();
    }

	private static char getParent(char node) {
		if (parents.get(node) == node) {
			return node;
		}
		char parent = getParent(parents.get(node));
		parents.put(node, parent);
		return parent;
	}

	private static void addParent(char parent, char child) {
		char currParent = parents.get(child);
		if (currParent == parent) {
			
		}
	}

}

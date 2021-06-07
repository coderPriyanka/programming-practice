package com.hardcoder.content;

import java.util.Scanner;

public class ConcatList {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		Node<Integer> temp = new Node<Integer>(in.nextInt());
		Node<Integer> head1 = temp;
		for (int i = 1; i < m; i++) {
			int value = in.nextInt();
			Node<Integer> node = new Node<Integer>(value);
			node.previous = temp;
			temp.next = node;
			temp = node;
		}
		temp.next = head1;
		head1.previous = temp;
		temp = head1.next;
		System.out.print(head1.data + " ");
		while (temp != head1) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
		
		int n = in.nextInt();
		temp = new Node<Integer>(in.nextInt());
		Node<Integer> head2 = temp;
		for (int i = 1; i < n; i++) {
			int value = in.nextInt();
			Node<Integer> node = new Node<Integer>(value);
			node.previous = temp;
			temp.next = node;
			temp = node;
		}
		temp.next = head2;
		head2.previous = temp;
		temp = head2.next;
		System.out.print(head2.data + " ");
		while (temp != head2) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
		
//		Node<Integer> result = concatenateLists(head1, head2);
		Node<Integer> result = concatenateLists2(head1, head2);
		System.out.print(result.data + " ");
		result = result.next;
		while (result != head1) {
			System.out.print(result.data + " ");
			result = result.next;
		}
		System.out.println();
		in.close();
	}
	
	public static Node<Integer> concatenateLists (Node<Integer> head1, Node<Integer> head2) {
		// Base condition when both the lists are empty
		if (head1 == null && head2 == null) {
			return null;
		}
		// Base condition when one of the lists are empty. If head1 is null, return head2 and vice versa
		if (head1 == null || head2 == null) {
			return head1 == null ? head2 : head1;
		}
		Node<Integer> head = head1;
		while (head1.next != null) {
			head1 = head1.next;
		}
		head1.next = head2;
		return head;
	}
	
	public static Node<Integer> concatenateLists2 (Node<Integer> head1, Node<Integer> head2) {
		// Base condition when both the lists are empty
		if (head1 == null && head2 == null) {
			return null;
		}
		// Base condition when one of the lists are empty. If head1 is null, return head2 and vice versa
		if (head1 == null || head2 == null) {
			return head1 == null ? head2 : head1;
		}
		Node<Integer> next = head1.next;				// LINE 1
		Node<Integer> previous = head2.previous;		// LINE 2
		next.previous = previous;						// LINE 3
		previous.next = next;							// LINE 4
		head1.next = head2;								// LINE 5
		head2.previous = head1;							// LINE 6
		next = null;									// LINE 7
		previous = null;								// LINE 8
		return head1;
	}
}
class Node<T> {
    T data;
    Node<T> next;
    Node<T> previous;
    public Node(T data) {
    	this.data = data;
    	this.next = null;
    	this.previous = null;
    }
}


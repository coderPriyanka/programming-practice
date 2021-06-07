package com.problems.amazon;

public class WordSuggestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Trie {
	private TrieNode root;
	
}

class TrieNode {
	
	private static final int SIZE = 26;
	
	char letter;
	String word;
	boolean isWord;
	TrieNode[] children;
	
	public TrieNode() {
		this.word = "";
		this.isWord = false;
		this.children = new TrieNode[SIZE];
	}
	
	public TrieNode(char letter, String word) {
		this();
		this.letter = letter;
		this.word = word + letter;
	}
	
}

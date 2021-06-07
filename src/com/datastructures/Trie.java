package com.datastructures;

public class Trie {
	
	private static TrieNode root;
	
	public void insert(String word) {
		if (root == null) {
			root = new TrieNode();
		}
		TrieNode currNode = root;
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			if (currNode.getChildren().containsKey(letter)) {
				currNode = currNode.getChildren().get(letter);
			} else {
				TrieNode newNode = new TrieNode();
				String data = currNode.getData() + letter;
				newNode.setData(data);
				currNode.getChildren().put(letter, newNode);
				currNode = newNode;
			}
		}
		currNode.setWord(true);
	}
	
	public boolean prefixSearch(String word) {
		TrieNode currNode = search(word);
		return currNode != null && !currNode.isWord();
	}
	
	public boolean wordSearch(String word) {
		TrieNode currNode = search(word);
		return currNode != null && currNode.isWord();
	}
	
	private TrieNode search(String word) {
		TrieNode currNode = root;
		int index = 0;
		while (currNode != null && index < word.length()) {
			char letter = word.charAt(index++);
			currNode = currNode.getChildren().get(letter);
		}
		return currNode;
	}
	
	public void delete(String word) {
		TrieNode currNode = search(word);
		if (currNode == null || !currNode.isWord()) {
			return;
		}
		currNode.setWord(false);
		delete(root, word, 0);
	}

	private void delete(TrieNode root, String word, int index) {
		if (root == null || index == word.length()) {
			return;
		}
		char letter = word.charAt(index);
		delete(root.getChildren().get(letter), word, index + 1);
		TrieNode nextNode = root.getChildren().get(letter);
		if (nextNode.getChildren().isEmpty()) {
			root.getChildren().remove(letter);
		}
	}

}

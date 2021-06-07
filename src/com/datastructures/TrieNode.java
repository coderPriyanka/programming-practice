package com.datastructures;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	
	private String data;
	private boolean isWord;
	private Map<Character, TrieNode> children;
	
	public TrieNode() {
		this.data = "";
		this.isWord = false;
		this.children = new HashMap<>();
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public boolean isWord() {
		return isWord;
	}

	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}

	public Map<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(Map<Character, TrieNode> children) {
		this.children = children;
	}

}

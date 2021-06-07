package com.datastructures.unionfind;

public class UnionFind {
	
	private int length;
	private int[] root;
	private int[] size;
	private int numComponents;
	
	public UnionFind(int length) {
		if (length <= 0) {
			throw new IllegalArgumentException("Size cannot be less than 1");
		}
		this.length = length;
		this.root = new int[length];
		this.size = new int[length];
		for (int i = 0; i < length; i++) {
			root[i] = i;
			size[i] = 1;
		}
		this.numComponents = length;
	}

	public int getLength() {
		return length;
	}
	
	public int getNumComponents() {
		return numComponents;
	}
	
	public void union(int num1, int num2) {
		int root1 = find(num1);
		int root2 = find(num2);
		if (root1 == root2) {
			return;
		}
		if (size[root1] >= size[root2]) {
			root[root2] = root1;
			size[root1] += size[root2];
		} else {
			root[root1] = root2;
			size[root2] += size[root1];
		}
		numComponents--;
	}
	
	public int find(int num) {
		if (root[num] == num) {
			return num;
		}
		root[num] = find(root[num]);
		return root[num];
	}
	
	public int componentSize(int num) {
		return size[find(num)];
	}
	
	public boolean isConnected(int num1, int num2) {
		return find(num1) == find(num2);
	}
	
}


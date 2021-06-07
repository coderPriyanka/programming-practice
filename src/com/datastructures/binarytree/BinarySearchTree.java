package com.datastructures.binarytree;

public class BinarySearchTree implements Tree {
	
	private Node root;
	
	public BinarySearchTree(Node root) {
		this.root = root;
	}
	
	public Node getRoot() {
		return root;
	}

	@Override
	public Node insert(int data) {
		root = insert(root, data);
		return root;
	}
	
	private Node insert(Node root, int data) {
		if (root == null) {
			root = new Node(data);
		}
		if (data < root.getData()) {
			root.setLeft(insert(root.getLeft(), data));
		}
		if (data > root.getData()) {
			root.setRight(insert(root.getRight(), data));
		}
		return root;
	}

	@Override
	public boolean get(int data) {
		return get(root, data);
	}
	
	private boolean get(Node root, int data) {
		if (root == null) {
			return false;
		}
		if (root.getData() == data) {
			return true;
		}
		if (data < root.getData()) {
			return get(root.getLeft(), data);
		}
		return get(root.getRight(), data);
	}

	@Override
	public Node delete(int data) {
		return delete(root, data);
	}
	
	private Node delete(Node root, int data) {
		if (root == null) {
			return root;
		}
		if (data == root.getData()) {
			if (isLeaf(root)) {
				return null;
			}
			if (root.getLeft() != null && root.getRight() != null) {
				root.setRight(getSmallestFromRight(root));
			}
			else {
				if (root.getLeft() == null) {
					return root.getRight();
				}
				return root.getLeft();
			}
		}
		if (data < root.getData()) {
			root.setLeft(delete(root.getLeft(), data));
		}
		else {
			root.setRight(delete(root.getRight(), data));
		}
		return root;
	}
	
	private Node getSmallestFromRight(Node node) {
		Node temp = node.getRight();
		while (temp.getLeft() != null) {
			temp = temp.getLeft();
		}
		node.setData(temp.getData());
		return temp.getRight();
	}
	
	private boolean isLeaf(Node node) {
		return node.getLeft() == null && node.getRight() == null;
	}

	@Override
	public void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.getLeft());
		System.out.println(root.getData());
		inorder(root.getRight());
	}

	@Override
	public void preorder(Node root) {
		if (root == null) {
			return;
		}
		System.out.println(root.getData());
		preorder(root.getLeft());
		preorder(root.getRight());
	}

	@Override
	public void postorder(Node root) {
		if (root == null) {
			return;
		}
		postorder(root.getLeft());
		postorder(root.getRight());
		System.out.println(root.getData());
	}

	@Override
	public void iterativeInorder(Node root) {
		
	}

	@Override
	public void iterativePreorder(Node root) {
		
	}

	@Override
	public void iterativePostorder(Node root) {
		
	}

}

package com.datastructures.binarytree;

public interface Tree {
	
	public Node insert(int data);
	public boolean get(int data);
	public Node delete(int data);
	
	public void inorder(Node root);
	public void preorder(Node root);
	public void postorder(Node root);
	
	public void iterativeInorder(Node root);
	public void iterativePreorder(Node root);
	public void iterativePostorder(Node root);

}

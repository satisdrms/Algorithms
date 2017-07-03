package com.github.satisdrms;

//Print the bottom view of the  Binary Tree 
public class Topic_GFG_EX8 {

	public static void main(String[] args) {
		BST_GFG bst = new BST_GFG();

//		bst.root = new BSTN(1);
//		bst.root.left = new BSTN(2);
//		bst.root.left.right = new BSTN(4);
//		bst.root.left.right.right = new BSTN(5);
//		bst.root.left.right.right.right = new BSTN(6);
//		bst.root.left.right.right.right.left = new BSTN(7);
//		bst.root.left.right.right.right.left.left = new BSTN(8);
//		bst.root.left.right.right.right.left.left.left = new BSTN(9);
//		bst.root.left.right.right.right.left.left.left.left = new BSTN(10);
//		bst.root.left.right.right.right.left.left.left.left.left = new BSTN(11);
//
//		bst.root.right = new BSTN(3);
		
//		bst.root = new BSTN(20);
//		bst.root.left = new BSTN(8);
//		bst.root.left.left = new BSTN(5);
//		
//		bst.root.left.right= new BSTN(3);
//		bst.root.left.right.left= new BSTN(10);
//		bst.root.left.right.right= new BSTN(14);
//		
//		bst.root.right = new BSTN(22);
//		bst.root.right.right= new BSTN(25);
		
		bst.root = new BSTN(20);
		bst.root.left = new BSTN(8);
		bst.root.left.left = new BSTN(5);
		
		bst.root.left.right= new BSTN(3);
		bst.root.left.right.left= new BSTN(10);
		bst.root.left.right.right= new BSTN(14);
		
		bst.root.right = new BSTN(22);
		bst.root.right.left= new BSTN(4);
		bst.root.right.right= new BSTN(25);
		
		bst.printbottomview();

	}

}

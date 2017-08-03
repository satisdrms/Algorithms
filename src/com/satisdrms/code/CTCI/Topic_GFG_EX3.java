package com.satisdrms.code.CTCI;

//Find the largest BST subtree in a given Binary Tree 
public class Topic_GFG_EX3 {

	public static void main(String[] args) {
		BST_GFG bst = new BST_GFG();
		bst.root = new BSTN(50);
		bst.root.left = new BSTN(10);
		bst.root.left.left = new BSTN(5);
		bst.root.left.left.left = new BSTN(2);

		bst.root.left.right = new BSTN(20);
		bst.root.left.right.left = new BSTN(18);
		bst.root.left.right.right = new BSTN(45);

		bst.root.right = new BSTN(60);
		bst.root.right.left = new BSTN(5);
		bst.root.right.right = new BSTN(70);
		/*
		 * 500 / \ 10 60 / \ / \ 5 20 55 70 / /\ 2 18 45
		 */
		bst.inOrderTraversal();
		bst.findMaxSubBST();
	}

}

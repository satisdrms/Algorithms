package com.satisdrms.treesAndGraphs;

import com.satisdrms.treesAndGraphs.BinarySearchTree;

//Implement a function to check if a tree is balanced. 
//For the purposes of this question, a balanced tree is defined 
//to be a tree such that no two leaf nodes differ in distance from the root by more than one.

public class BalancedTree1 {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(2);
		bst.insert(1);
		bst.insert(11);
		bst.insert(9);
		bst.insert(4);
		bst.insert(0);
		bst.inOrderTraversal();
		bst.isBalanced();

	}

}

package com.github.satisdrms.treesAndGraphs;

import com.github.satisdrms.treesAndGraphs.BinarySearchTree;

//write an algorithm to create a binary tree with minimal height.

public class MinimalHeightTree3 {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 7, 89, 100, 1231, 141514, 193123 };
		int mid = a.length / 2;
		BinarySearchTree bst = new BinarySearchTree();
		insertBalanced(a, 0, a.length - 1, bst);

		// bst.insert(10);
		// bst.insert(2);
		// bst.insert(1);
		// bst.insert(11);
		// bst.insert(9);
		// bst.insert(4);
		// bst.insert(0);
		bst.printBST();
		bst.inOrderTraversal();
		bst.isBalanced();

	}

	private static void insertBalanced(int[] a, int start, int end, BinarySearchTree bst) {
		int mid = ((end - start) / 2) + start;
		if (end >= start) {
			bst.insert(a[mid]);
			insertBalanced(a, start, mid - 1, bst);
			insertBalanced(a, mid + 1, end, bst);
		}
	}
}
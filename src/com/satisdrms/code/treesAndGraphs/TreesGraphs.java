package com.satisdrms.code.treesAndGraphs;

import com.satisdrms.code.treesAndGraphs.BinarySearchTree;

public class TreesGraphs {

	public static void main(String[] args) {
		BinarySearchTree bst=new BinarySearchTree();
		bst.insert(10);
		bst.insert(2);
		bst.insert(1);
		bst.insert(11);
		bst.insert(9);
		bst.insert(4);
		bst.insert(19);
		bst.inOrderTraversal();
		bst.delete(9);

	}

}

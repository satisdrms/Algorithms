package com.satisdrms.code.treesAndGraphs;

import com.satisdrms.code.treesAndGraphs.BinarySearchTree;

//Given a binary search tree, design an algorithm which creates a 
//linked list of all the nodes at each depth 
//(i.e., if you have a tree with depth D, you’ll have D linked lists).

public class ListofNodebyDepth4 {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(2);
		bst.insert(1);
		bst.insert(11);
		bst.insert(9);
		bst.insert(4);
		bst.insert(0);
		bst.insert(12);bst.insert(13);bst.insert(14);bst.insert(15);
		bst.printBST();
		//bst.createLinkedListOfAllDepth();//Wrong Solution But Works
		bst.createLinkedListOfBreadth(); //i.e. at each depth


	}


}

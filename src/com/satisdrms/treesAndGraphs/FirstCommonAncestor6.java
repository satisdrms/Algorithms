package com.satisdrms.treesAndGraphs;

import com.satisdrms.treesAndGraphs.BSTV2;
import com.satisdrms.treesAndGraphs.BinarySearchTreeV2;

//Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. 
//Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.

//BOOK SOLUTION TO BE READ LATER

public class FirstCommonAncestor6 {

	public static void main(String[] args) {
		BinarySearchTreeV2 bst = new BinarySearchTreeV2();
		bst.insert(10);
		bst.insert(2);
		bst.insert(1);
		bst.insert(11);
		bst.insert(9);
		bst.insert(4);
		bst.insert(0);
		bst.insert(12);
		bst.insert(14);
		bst.insert(13);
		bst.insert(15);

		bst.printBSTV2();
		BSTV2 node1 = bst.getNode(4);
		BSTV2 node2 = bst.getNode(1);
		System.out.println("Searching Nodes are " + node1.d + " " + node2.d);
		bst.findCommonAncenstor(node1,node2);
		BSTV2 cmn=bst.findCommonAncenstorSol2(bst.root,node1,node2);
		System.out.println("Common Ancestor is "+cmn.d);
	}

}

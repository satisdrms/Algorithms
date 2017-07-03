package pack1;

//You are given a binary tree in which each node contains a value. 
//Design an algorithm to print all paths which sum up to that value. 
//Note that it can be any path in the tree - it does not have to start at the root.

public class Topic_19_TreesGraphs_EX8 {

	public static void main(String[] args) {
		BinarySearchTreeV2 bst = new BinarySearchTreeV2();
		bst.insert(10);
		bst.insert(3);
		bst.insert(2);
		bst.insert(1);
		bst.insert(11);
		bst.insert(9);
		bst.insert(4);
		//bst.insert(0);
		bst.insert(12);
		bst.insert(14);
		bst.insert(13);
		bst.insert(15);
		bst.printBSTV2();
		//bst.findSum(bst.root);
		bst.findSumBookSol(bst.root);

	}

}

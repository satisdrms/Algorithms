package pack1;

//Write an algorithm to find the ‘next’ node (i.e., in-order successor) of a 
//given node in a binary search tree where each node has a link to its parent.

public class Topic_19_TreesGraphs_EX5 {

	public static void main(String[] args) {
		BinarySearchTreeV2 bst = new BinarySearchTreeV2();
		bst.insert(10);
		bst.insert(2);
		bst.insert(1);
		bst.insert(11);
		bst.insert(9);
		bst.insert(4);
		bst.insert(0);
		bst.insert(12);bst.insert(14);
		bst.insert(13);
		
		bst.insert(15);
		bst.printBSTV2();
		BSTV2 node=bst.getNode(15);
		System.out.println("Searching Node is "+node.d);
		bst.findInOrderSuccessor(node);
		

	}

}

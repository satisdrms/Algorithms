package pack1;

//You have two very large binary trees: 
//T1, with millions of nodes, and T2, with hundreds of nodes. 
//Create an algorithm to decide if T2 is a subtree of T1.

public class Topic_19_TreesGraphs_EX7 {

	public static void main(String[] args) {
		// Normal Solution- check whether Tree1 is subtree of Tree2
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

		BinarySearchTreeV2 bst2 = new BinarySearchTreeV2();
		bst2.insert(10);
		//bst2.insert(2);
		bst2.insert(2);
		bst2.insert(1);
		bst2.insert(11);
		bst2.insert(9);
		bst2.insert(4);
		bst2.insert(0);
		bst2.insert(12);
		bst2.insert(14);
		bst2.insert(13);
		bst2.insert(15);
		bst2.printBSTV2();

		BSTV2 node1 = bst.getNode(10);
		BSTV2 node2 = bst2.getNode(2);

		System.out.println("Searching Nodes are " + node1.d + " " + node2.d);
		String str1 = bst.convertToInOrderString(node1);
		String str2 = bst.convertToInOrderString(node2);
		if (str2.contains(str1)) {
			System.out.println(str1 + " is a sub tree");
		}

		if (bst.matchTree(node1, node2)) {
			System.out.println(node2.d + " is a subtree from Match tree logic");
		}else {
			System.out.println(node2.d + " NOT a subtree from Match tree logic");
		}

	}

}

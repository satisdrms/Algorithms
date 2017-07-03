package pack1;

public class Topic_19_TreesGraphs {

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

package com.github.satisdrms;

import java.util.ArrayList;
import java.util.LinkedList;

class BST {
	BST left, right;
	int d;

	BST(int d) {
		this.d = d;
	}
}

public class BinarySearchTree {
	BST root;

	public BinarySearchTree() {
		root = null;
	}

	public void insert(int d) {
		root = insert(root, d);
	}

	private BST insert(BST node, int d) {
		if (node == null) {
			node = new BST(d);
			return node;
		} else if (node.d <= d) {
			node.right = insert(node.right, d);
		} else if (node.d > d) {
			node.left = insert(node.left, d);
		}
		return node;
	}

	public void inOrderTraversal() {
		inOrderTraversal(root);
	}

	private void inOrderTraversal(BST node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.println(node.d);
			inOrderTraversal(node.right);
		}
	}

	public void delete(int i) {
		// TODO Auto-generated method stub

	}

	public int isBalanced() {
		// return (maxDepth(root) - minDepth(root));
		System.out.println("Max Depth is " + maxDepth(root));
		System.out.println("Min Depth is " + minDepth(root));

		return 0;
	}

	private int minDepth(BST node) {
		if (node == null)
			return 0;
		return 1 + Math.min(minDepth(node.left), minDepth(node.right));
	}

	private int maxDepth(BST node) {
		if (node == null)
			return 0;
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
	}

	public void printBST() {
		if (root != null) {
			String str = root.d + " is root";
			System.out.println(str);
			printBST(root, str);
		}
	}

	private void printBST(BST node, String str) {
		if (node.left != null) {
			String str1 = node.left.d + " is to left of " + str;
			System.out.println(str1);
			printBST(node.left, str1);
		}
		if (node.right != null) {
			String str1 = node.right.d + " is to right of " + str;
			System.out.println(str1);
			printBST(node.right, str1);
		}

	}

	public void createLinkedListOfAllDepth() {
		LinkedList<BST> depth = new LinkedList<BST>();
		LinkedList<LinkedList<BST>> allDepth = new LinkedList<LinkedList<BST>>();
		createLinkedList(root, depth, allDepth);
		printLinkdLst(allDepth);

	}

	private void printLinkdLst(LinkedList<LinkedList<BST>> allDepth) {
		for (LinkedList<BST> dpt : allDepth) {
			System.out.println("Linked List starts");
			for (BST bst : dpt) {
				System.out.println(bst.d);
			}
		}

	}

	private void printLinkdLstArray(ArrayList<LinkedList<BST>> allDepth) {
		for (LinkedList<BST> dpt : allDepth) {
			System.out.println("Linked List starts");
			for (BST bst : dpt) {
				System.out.println(bst.d);
			}
		}

	}

	private void createLinkedList(BST node, LinkedList<BST> depth, LinkedList<LinkedList<BST>> allDepth) {
		depth.add(node);
		if (node.left != null) {
			createLinkedList(node.left, depth, allDepth);
		}
		if (node.right != null) {
			createLinkedList(node.right, depth, allDepth);
		}
		if (node.left == null && node.right == null) {
			LinkedList<BST> temp1 = new LinkedList<BST>(depth);
			allDepth.add(temp1);
		}
		depth.removeLast();

	}

	public void createLinkedListOfBreadth() {
		// LinkedList<BST> queue = new LinkedList<BST>();
		ArrayList<LinkedList<BST>> allDepth = new ArrayList<LinkedList<BST>>();
		if (root != null) {
			LinkedList<BST> nextLevel = new LinkedList<BST>();
			nextLevel.add(root);
			int level = 0;
			allDepth.add(level, nextLevel);
			while (true) {
				nextLevel = new LinkedList<BST>();
				for (BST bst : allDepth.get(level)) {
					if (bst.left != null)
						nextLevel.addLast(bst.left);
					if (bst.right != null)
						nextLevel.addLast(bst.right);
				}
				if (nextLevel.size() == 0) {
					break;
				}
				level++;
				allDepth.add(level, nextLevel);
			}
		}
		printLinkdLstArray(allDepth);
	}

	public void findInOrderSuccessor() {
		
		
	}
}

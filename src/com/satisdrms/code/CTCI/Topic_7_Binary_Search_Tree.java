package com.satisdrms.code.CTCI;

import java.util.Scanner;

@SuppressWarnings("unused")
class bnode {
	int data;
	bnode left, right;

	public bnode() {
		data = 0;
		left = null;
		right = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public bnode getLeft() {
		return left;
	}

	public void setLeft(bnode left) {
		this.left = left;
	}

	public bnode getRight() {
		return right;
	}

	public void setRight(bnode right) {
		this.right = right;
	}

}

class bnodeprocess {
	bnode root;

	public bnodeprocess() {
		root = null;
	}

	public void addnode(int d) {
		root = addnode(root, d);
	}

	public bnode addnode(bnode node, int d) {
		if (node == null) {
			node = new bnode();
			node.setData(d);
			return node;
		} else if (d <= node.getData()) {
			node.left = addnode(node.getLeft(), d);
			return node;
		} else if (d > node.getData()) {
			node.right = addnode(node.getRight(), d);
			return node;
		}
		return node;
	}

	public void display() {
		display(root);
		System.out.println();
	}

	public void display(bnode node) {
		System.out.print(node.getData() + " ");
		if (node.left != null)
			display(node.left);
		if (node.right != null)
			display(node.right);
	}

	public void display_flag() {
		display_flag(root, "root");
		System.out.println();
	}

	public void display_flag(bnode node, String flg) {
		System.out.println(node.getData() + " in " + flg + " ");
		if (node.left != null)
			display_flag(node.left, "left in " + flg);
		if (node.right != null)
			display_flag(node.right, "right in " + flg);
	}

	public boolean search(int d) {
		return search(root, d);
	}

	public boolean search(bnode node, int d) {
		// System.out.println(node.getData() + " " + "searching for " + d);
		if (node == null) {
			return false;
		} else if (node.getData() == d) {
			return true;
		} else if (d <= node.getData()) {
			return search(node.getLeft(), d);
		} else if (d > node.getData()) {
			return search(node.getRight(), d);
		}
		return false;
	}

	public int countNodes() {
		if (root == null) {
			return 0;
		} else
			return countNodes(root, 0);
	}

	public int countNodes(bnode node, int count) {
		// System.out.print(node.getData());
		if (node.left != null)
			count = countNodes(node.left, count);
		if (node.right != null)
			count = countNodes(node.right, count);
		return count + 1;
	}

	public void deletenode(int d) {
		if (root == null) {
			System.out.println("Root is empty");
			return;
		}
		if (search(root, d) == true) {
			root = deletenode(root, d);
		} else
			System.out.println("Node is not found");
	}

	public bnode deletenode(bnode node, int d) {
		// System.out.println("Checking "+node.getData() );
		if (node.getData() != d) {
			// System.out.println("inside if");
			if (search(node.left, d) == true) {
				// System.out.println("searching left");
				node.left = deletenode(node.left, d);
			}
			if (search(node.right, d) == true) {
				// System.out.println("searching right");
				node.right = deletenode(node.right, d);
			}
		} else if (node.getData() == d) {
			// System.out.println("in elsif of delete "+node.getRight()+" "+node.getLeft());
			if (node.left == null && node.right == null) {
				node = null;
				// System.out.println("in if");

			} else if (node.right == null) {
				node = node.left;
				// System.out.println("in elseif 1");

			} else if (node.left == null) {
				node = node.right;
				// System.out.println("in elsif 2");

			} else {
				node.right = addlefttoright(node.left, node.right);
				node = node.right;
				// System.out.println("in else??");

			}
		}

		return node;
	}

	public bnode addlefttoright(bnode left, bnode right) {
		bnode i;
		i = right;
		while (i.getLeft() != null)
			i = i.getLeft();
		i.setLeft(left);
		return right;
	}

	public void findmin() {
		if (root == null) {
			System.out.println("Root is empty");
		} else {
			findmin(root);
		}
	}

	private void findmin(bnode node) {
		bnode minnode, i;
		i = node;
		minnode = node;
		while (i.getLeft() != null) {
			i = i.getLeft();
			if (minnode.getData() > i.getData()) {
				minnode = i;
			}
		}
		System.out.println("minimum value is "+minnode.getData());
	}

	public void findmax() {
		if (root == null) {
			System.out.println("Root is empty");
		} else {
			findmax(root);
		}
		
	}
	private void findmax(bnode node) {
		bnode maxnode, i;
		i = node;
		maxnode = node;
		while (i.getRight() != null) {
			i = i.getRight();
			if (maxnode.getData() < i.getData()) {
				maxnode = i;
			}
		}
		System.out.println("minimum value is "+maxnode.getData());
	}

}

public class Topic_7_Binary_Search_Tree {

	public static void main(String[] args) {
		bnodeprocess bst = new bnodeprocess();
		addAndDisplay(bst, 99);
		addAndDisplay(bst, 945);
		addAndDisplay(bst, 999);
		addAndDisplay(bst, 99);
		addAndDisplay(bst, 1);
		addAndDisplay(bst, 23);
		addAndDisplay(bst, 99);
		addAndDisplay(bst, 945);
		addAndDisplay(bst, 999);
		addAndDisplay(bst, 99);
		addAndDisplay(bst, 1);
		addAndDisplay(bst, 23);

		// System.out.println("Result for searching 1 is :- " + bst.search(1));

		deleteAndDisplay(bst, 99);
		deleteAndDisplay(bst, 99);
		deleteAndDisplay(bst, 945);
		deleteAndDisplay(bst, 1);
		deleteAndDisplay(bst, 1);

		addAndDisplay(bst, 123);
		addAndDisplay(bst, 22);
		System.out.println("Result for searching 123 is :- " + bst.search(123));
		addAndDisplay(bst, 1123);

		deleteAndDisplay(bst, 123);
		deleteAndDisplay(bst, 999);
		deleteAndDisplay(bst, 999);
		
		addAndDisplay(bst, 11239);

		bst.findmin();
		bst.findmax();

	}

	public static void deleteAndDisplay(bnodeprocess bst, int d) {
		System.out.println("deleting " + d);
		bst.deletenode(d);
		System.out.println("There are total of " + bst.countNodes() + " nodes");
		bst.display_flag();
	}

	public static void addAndDisplay(bnodeprocess bst, int d) {
		bst.addnode(d);
		bst.display_flag();
	}

}

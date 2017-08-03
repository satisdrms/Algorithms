package com.satisdrms.code.CTCI;

import java.util.HashMap;
import java.util.Set;

import javax.sound.midi.Receiver;

class m_bnode {
	int data;
	m_bnode left, right;

	public m_bnode() {
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

	public m_bnode getLeft() {
		return left;
	}

	public void setLeft(m_bnode left) {
		this.left = left;
	}

	public m_bnode getRight() {
		return right;
	}

	public void setRight(m_bnode right) {
		this.right = right;
	}

}

class m_bnodeprocess {
	m_bnode root;
	public static HashMap<String, Integer> rec = new HashMap<String, Integer>();

	public m_bnodeprocess() {
		root = null;
	}

	public void addnode(int d) {
		if (search(d) == true) {
			System.out
					.println("Already Found and Hence not inserting this element");
		} else {
			root = addnode(root, d);
		}
	}

	public m_bnode addnode(m_bnode node, int d) {
		if (node == null) {
			node = new m_bnode();
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

	public void display(m_bnode node) {
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

	public void display_flag(m_bnode node, String flg) {
		System.out.println(node.getData() + " in " + flg + " ");
		if (node.left != null)
			display_flag(node.left, "left (" + node.getData() + ") in " + flg);
		if (node.right != null)
			display_flag(node.right, "right (" + node.getData() + ") in " + flg);
	}

	public boolean search(int d) {
		return search(root, d);
	}

	public boolean search(m_bnode node, int d) {
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

	public int countNodes(m_bnode node, int count) {
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

	public m_bnode deletenode(m_bnode node, int d) {
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

	public m_bnode addlefttoright(m_bnode left, m_bnode right) {
		m_bnode i;
		i = right;
		while (i.getLeft() != null)
			i = i.getLeft();
		i.setLeft(left);
		return right;
	}

	public void deleteNodeAvl(int d) {
		root = deleteNodeAvl(root, d);

	}

	public m_bnode deleteNodeAvl(m_bnode node, int d) {
		m_bnode max, min, left, right;
		if (node.getData() != d) {
			if (search(node.getLeft(), d) == true) {
				node.setLeft(deleteNodeAvl(node.getLeft(), d));
			}
			if (search(node.getRight(), d) == true) {
				node.setRight(deleteNodeAvl(node.getRight(), d));
			}
		} else if (node.getData() == d) {
			if (node.getLeft() == null && node.getRight() == null) {
				node = null;
			} else if (node.getRight() == null) {
				node = node.getLeft();
			} else if (node.getLeft() == null) {
				node = node.getRight();
			} else {
				if (countheight(node.getLeft(), 1) >= countheight(
						node.getRight(), 1)) {
					System.out.println("Deleting from left "
							+ countheight(node.getLeft(), 1) + " "
							+ countheight(node.getRight(), 1));
					max = findmax_ret(node.getLeft());
					deleteNodeAvl(max.getData());
					left = node.getLeft();
					right = node.getRight();
					max.setRight(right);
					max.setLeft(left);
					node = max;
				} else if (countheight(node.getLeft(), 1) < countheight(
						node.getRight(), 1)) {
					System.out.println("Deleting from Right "
							+ countheight(node.getLeft(), 1) + " "
							+ countheight(node.getRight(), 1));
					min = findmin_ret(node.getRight());
					deleteNodeAvl(min.getData());
					left = node.getLeft();
					right = node.getRight();
					min.setRight(right);
					min.setLeft(left);
					node = min;
				}
			}
		}
		return node;
	}

	private m_bnode findmin_ret(m_bnode node) {
		m_bnode minnode, i;
		i = node;
		minnode = node;
		while (i.getLeft() != null) {
			i = i.getLeft();
			if (minnode.getData() > i.getData()) {
				minnode = i;
			}
		}
		System.out.println("minimum value is " + minnode.getData());
		return minnode;
	}

	private m_bnode findmax_ret(m_bnode node) {
		m_bnode maxnode, i;
		i = node;
		maxnode = node;
		while (i.getRight() != null) {
			i = i.getRight();
			if (maxnode.getData() < i.getData()) {
				maxnode = i;
			}
		}
		System.out.println("maximum value is " + maxnode.getData());
		return maxnode;
	}

	public void findmin() {
		if (root == null) {
			System.out.println("Root is empty");
		} else {
			findmin(root);
		}
	}

	private void findmin(m_bnode node) {
		m_bnode minnode, i;
		i = node;
		minnode = node;
		while (i.getLeft() != null) {
			i = i.getLeft();
			if (minnode.getData() > i.getData()) {
				minnode = i;
			}
		}
		System.out.println("minimum value is " + minnode.getData());
	}

	public void findmax() {
		if (root == null) {
			System.out.println("Root is empty");
		} else {
			findmax(root);
		}

	}

	private void findmax(m_bnode node) {
		m_bnode maxnode, i;
		i = node;
		maxnode = node;
		while (i.getRight() != null) {
			i = i.getRight();
			if (maxnode.getData() < i.getData()) {
				maxnode = i;
			}
		}
		System.out.println("minimum value is " + maxnode.getData());
	}

	public int countLeft() {
		if (root.getLeft() == null) {
			return 0;
		} else {
			return count(root.getLeft(), 1);
		}

	}

	private int count(m_bnode node, int c) {

		if (node.getLeft() != null) {
			c = c + 1;
			c = count(node.getLeft(), c);
		}
		if (node.getRight() != null) {
			c = c + 1;
			c = count(node.getRight(), c);
		}
		return c;

	}

	public int countRight() {
		if (root.getRight() == null) {
			return 0;
		} else {
			return count(root.getRight(), 1);
		}
	}

	public void rebalancetree() {
		root = rebalancetree(root);

	}

	private m_bnode rebalancetree(m_bnode node) {
		// System.out.println("Currently rebalancing node " + node.getData());
		int left_count = 0, right_count = 0;
		if (node.left != null) {
			node.left = rebalancetree(node.left);
			left_count = countheight(node.left, 1);
			// display_flag(node.left, "Left");
			// System.out.println("left child of " + node.getData() + " has "+
			// left_count + " nodes in height");
		}
		if (node.right != null) {
			node.right = rebalancetree(node.right);
			right_count = countheight(node.right, 1);
			// display_flag(node.right, "Right");
			// System.out.println("right child of " + node.getData() + " has "+
			// right_count + "  nodes in height");
		}
		/*
		 * if (Math.abs(left_count - right_count) <= 1) {
		 * System.out.println("node " + node.getData() +
		 * " is balanced and left height is " + left_count +
		 * " and right height is " + right_count); } else {
		 * System.out.println("node " + node.getData() +
		 * " needs to be rebalanced");
		 * 
		 * node = rebalance_engine(node, left_count - right_count);
		 * 
		 * }
		 */

		while (Math.abs(left_count - right_count) > 1) {
			// System.out.println("CALLING REBALANCING");
			if (rec.containsKey(Integer.toString(node.getData())) == true) {
				rec.put(Integer.toString(node.getData()),
						rec.get(Integer.toString(node.getData())) + 1);
			} else {
				rec.put(Integer.toString(node.getData()), 1);
			}

			node = rebalance_engine(node, left_count - right_count);
			if (node.left != null) {
				node.left = rebalancetree(node.left);
				left_count = countheight(node.left, 1);
				// display_flag(node.left, "Left");
				// System.out.println("left child of " + node.getData() +
				// " has "+ left_count + " nodes in height");
			}
			if (node.right != null) {
				node.right = rebalancetree(node.right);
				right_count = countheight(node.right, 1);
				// display_flag(node.right, "Right");
				// System.out.println("right child of " + node.getData() +
				// " has "+ right_count + "  nodes in height");
			}
		}
		return node;

	}

	public void rebalance_engine(int rot) {
		root = rebalance_engine(root, rot);

	}

	public m_bnode rebalance_engine(m_bnode node, int bal) {
		// System.out.println("Rebalancing " + node.getData());
		// System.out.println("Rebalancing " + node.getData() + " "+
		// node.getLeft().getLeft().getData()+ " and balance is " + bal);
		// System.out.println(node.getRight().getRight().getRight());
		m_bnode pivot, newroot, temp;
		// CASE OF LEFT ROTATION, RIGHT ROTATION
		if (bal > 0
				&& (countheight(node.getLeft().getLeft(), 1) <= countheight(
						node.getLeft().getRight(), 1))) {
			// System.out.println("IN LEFT & RIGHT ROTATION");
			// LEFT ROTATION
			pivot = node.getLeft().getRight();
			newroot = node.getLeft();
			temp = pivot.getLeft();

			newroot.setRight(temp);
			pivot.setLeft(newroot);
			node.setLeft(pivot);
			// RIGHT ROTATION

			pivot = node.getLeft();
			temp = pivot.getRight();
			node.setLeft(temp);
			pivot.setRight(node);
			node = pivot;

		}// CASE OF RIGHT ROATATION, LEFT ROATATION
		else if (bal < 0
				&& (countheight(node.getRight().getRight(), 1) <= countheight(
						node.getRight().getLeft(), 1))) {
			// System.out.println("IN RIGHT & LEFT ROTATION");
			// RIGHT ROTATION
			pivot = node.getRight().getLeft();
			newroot = node.getRight();
			temp = pivot.getRight();

			newroot.setLeft(temp);
			pivot.setRight(newroot);
			node.setRight(pivot);
			// LEFT ROTATION

			pivot = node.getRight();
			temp = pivot.getLeft();
			node.setRight(temp);
			pivot.setLeft(node);
			node = pivot;

		}// CASE OF RIGHT ROTATION
		else if (bal > 0
				&& (countheight(node.getLeft().getLeft(), 1) > countheight(node
						.getLeft().getRight(), 1))) {
			// System.out.println("IN RIGHT ROTATION");
			pivot = node.getLeft();
			temp = pivot.getRight();
			node.setLeft(temp);
			pivot.setRight(node);
			node = pivot;

		}// CASE OF LEFT ROTATION
		else if (bal < 0
				&& (countheight(node.getRight().getRight(), 1) > countheight(
						node.getRight().getLeft(), 1))) {
			// System.out.println("IN LEFT ROTATION");
			pivot = node.getRight();
			temp = pivot.getLeft();
			node.setRight(temp);
			pivot.setLeft(node);
			node = pivot;
		}
		return node;
	}

	public int countLeftHeight() {
		if (root.getLeft() == null) {
			return 0;
		} else {
			return countheight(root.getLeft(), 1);
		}
	}

	public int countRightHeight() {
		if (root.getLeft() == null) {
			return 0;
		} else {
			return countheight(root.getRight(), 1);
		}
	}

	public int countheight() {
		return countheight(root, 1);

	}

	// ///////////////////////////////////
	//
	// ////////////
	public int countheight(m_bnode node, int c) {
		int depth = c, temp = 0;
		// System.out.println("Node is " + node.getData() + " for the count " +
		// c);
		if (node != null) {
			if (node.getLeft() != null) {
				temp = countheight(node.left, c + 1);
				depth = temp > depth ? temp : depth;
			}
			if (node.right != null) {
				temp = countheight(node.right, c + 1);
				depth = temp > depth ? temp : depth;
			}
		} else {
			return 0;
		}
		return depth;
	}

	public void inOrderTraversal() {
		inOrderTraversal(root);

	}

	private void inOrderTraversal(m_bnode node) {
		if (node.left != null) {
			inOrderTraversal(node.left);
		}
		System.out.println(node.getData());
		if (node.right != null) {
			inOrderTraversal(node.right);
		}

	}

	public void preOrderTraversal() {
		preOrderTraversal(root);

	}

	private void preOrderTraversal(m_bnode node) {
		System.out.println(node.getData());

		if (node.left != null) {
			inOrderTraversal(node.left);
		}
		if (node.right != null) {
			inOrderTraversal(node.right);
		}

	}

	public void postOrderTraversal() {
		postOrderTraversal(root);

	}

	private void postOrderTraversal(m_bnode node) {
		if (node.left != null) {
			inOrderTraversal(node.left);
		}
		System.out.println(node.getData());
		if (node.right != null) {
			inOrderTraversal(node.right);
		}
		System.out.println(node.getData());

	}

}

public class Topic_13_Median_Binary_Search_Tree {
	public static void main(String[] args) {
		m_bnodeprocess bst = new m_bnodeprocess();

		addAndDisplay(bst, 99);
		addAndDisplay(bst, 945);
		addAndDisplay(bst, 999);
		addAndDisplay(bst, 97);
		addAndDisplay(bst, 1);
		addAndDisplay(bst, 23);
		addAndDisplay(bst, 96);
		addAndDisplay(bst, 946);
		addAndDisplay(bst, 43);
		addAndDisplay(bst, 93);
		addAndDisplay(bst, 56);
		addAndDisplay(bst, 23);
		addAndDisplay(bst, 123);
		addAndDisplay(bst, 77);
		// System.out.println("Result for searching 123 is :- " +
		// bst.search(123));
		addAndDisplay(bst, 1123);
		addAndDisplay(bst, 57);
		addAndDisplay(bst, 2);
		addAndDisplay(bst, 54);
		addAndDisplay(bst, 94);
		addAndDisplay(bst, 53);
		addAndDisplay(bst, 52);
		addAndDisplay(bst, 51);
		addAndDisplay(bst, 50);
		addAndDisplay(bst, 49);

		/*
		 * addAndDisplay(bst, 97); addAndDisplay(bst, 1); addAndDisplay(bst,
		 * 23); addAndDisplay(bst, 22); addAndDisplay(bst, 21);
		 * addAndDisplay(bst, 96); addAndDisplay(bst, 946); addAndDisplay(bst,
		 * 43); bst.display_flag(); System.out
		 * .println("Number of nodes in the left are " + bst.countLeft());
		 * System.out.println("Number of nodes in the right are " +
		 * bst.countRight());
		 */
		// System.out.println("InOrder Traversal of the trees are:-");bst.inOrderTraversal();
		// System.out.println("PreOrder Traversal of the trees are:-");bst.preOrderTraversal();
		// System.out.println("PostOrder Traversal of the trees are:-");bst.postOrderTraversal();
		// System.out.println("Height of the node is " + bst.countheight());
		/*
		 * bst.display_flag();
		 * System.out.println("Number of nodes in the left are " +
		 * bst.countLeft());
		 * System.out.println("Number of nodes in the right are "+
		 * bst.countRight()); System.out.println("Height of the left node is "+
		 * bst.countLeftHeight());
		 * System.out.println("Height of the right node is "+
		 * bst.countRightHeight());
		 * 
		 * bst.rebalancetree();
		 * 
		 * System.out.println("Number of nodes in the left are " +
		 * bst.countLeft());
		 * System.out.println("Number of nodes in the right are "+
		 * bst.countRight()); System.out.println("Height of the left node is "+
		 * bst.countLeftHeight());
		 * System.out.println("Height of the right node is "+
		 * bst.countRightHeight());
		 */
		/*
		 * Set<String> res = bst.rec.keySet(); for (String s : res) {
		 * System.out.println("Node " + s + " is rebalanced " + bst.rec.get(s) +
		 * " times"); }
		 */
		addAndDisplay(bst, 11123);
		addAndDisplay(bst, 1157);
		addAndDisplay(bst, 112);
		addAndDisplay(bst, 1154);
		addAndDisplay(bst, 1194);
		addAndDisplay(bst, 1153);
		addAndDisplay(bst, 1152);
		addAndDisplay(bst, 1151);
		addAndDisplay(bst, 1150);
		addAndDisplay(bst, 1111);
		/*
		 * bst.display_flag();
		 * System.out.println("Number of nodes in the left are " +
		 * bst.countLeft());
		 * System.out.println("Number of nodes in the right are "+
		 * bst.countRight()); System.out.println("Height of the left node is "+
		 * bst.countLeftHeight());
		 * System.out.println("Height of the right node is "+
		 * bst.countRightHeight());
		 */
		bst.rebalancetree();
		bst.display_flag();
		bst.deleteNodeAvl(1111);
		bst.display_flag();

		bst.deleteNodeAvl(1123);

		bst.display_flag();
		bst.deleteNodeAvl(1150);

		bst.display_flag();

		bst.deleteNodeAvl(1151);

		bst.display_flag();

		bst.deleteNodeAvl(1152);

		bst.display_flag();

		bst.deleteNodeAvl(1154);

		bst.display_flag();

		bst.deleteNodeAvl(1153);

		bst.display_flag();
		bst.deleteNodeAvl(1157);

		bst.display_flag();

		bst.rebalancetree();
		bst.display_flag();
		/*
		 * System.out.println("Number of nodes in the left are " +
		 * bst.countLeft());
		 * System.out.println("Number of nodes in the right are "+
		 * bst.countRight()); System.out.println("Height of the left node is "+
		 * bst.countLeftHeight());
		 * System.out.println("Height of the right node is "+
		 * bst.countRightHeight());
		 */

		// FOR RIGHT ROTATION
		// addAndDisplay(bst, 100);
		// addAndDisplay(bst, 98);
		// addAndDisplay(bst, 81);
		// addAndDisplay(bst, 78);
		// addAndDisplay(bst, 103);
		// addAndDisplay(bst, 99);
		// addAndDisplay(bst, 82);
		// bst.display_flag();
		// bst.rebalance_engine(1);
		// bst.display_flag();

		// FOR LEFT ROTATION AND RIGHT ROTATION
		// addAndDisplay(bst, 100);
		// addAndDisplay(bst, 89);
		// addAndDisplay(bst, 103);
		// addAndDisplay(bst, 80);
		// addAndDisplay(bst, 98);
		// addAndDisplay(bst, 99);
		// addAndDisplay(bst, 91);
		// bst.display_flag();
		// bst.rebalance_engine(1);
		// bst.display_flag();

		// FOR LEFT ROTATION
		// addAndDisplay(bst, 100);
		// addAndDisplay(bst, 99);
		// addAndDisplay(bst, 103);
		// addAndDisplay(bst, 101);
		// addAndDisplay(bst, 110);
		// addAndDisplay(bst, 108);
		// addAndDisplay(bst, 119);
		// bst.display_flag();
		// bst.rebalance_engine(-2);
		// bst.display_flag();

		// FOR RIGHT AND LEFT ROTATION
		// addAndDisplay(bst, 100);
		// addAndDisplay(bst, 99);
		// addAndDisplay(bst, 201);
		// addAndDisplay(bst, 150);
		// addAndDisplay(bst, 209);
		// addAndDisplay(bst, 149);
		// addAndDisplay(bst, 159);
		// bst.display_flag();
		// bst.rebalance_engine(-2);
		// bst.display_flag();

		// FOR LEFT ROTATION -- ABNORMALS
		// addAndDisplay(bst, 100);
		// addAndDisplay(bst, 99);
		// addAndDisplay(bst, 201);
		// addAndDisplay(bst, 150);
		// addAndDisplay(bst, 209);
		// addAndDisplay(bst, 210);
		// addAndDisplay(bst, 211);
		// bst.display_flag();
		// bst.rebalance_engine(-2);
		// bst.display_flag();

		// FOR RIGHT ROTATION -- ABNORMALS
		// addAndDisplay(bst, 100);
		// addAndDisplay(bst, 98);
		// addAndDisplay(bst, 81);
		// addAndDisplay(bst, 78);
		// addAndDisplay(bst, 76);
		// addAndDisplay(bst, 65);
		// addAndDisplay(bst, 51);
		// bst.display_flag();
		// bst.rebalance_engine(1);
		// bst.rebalance_engine(1);
		// bst.rebalance_engine(1);
		// bst.display_flag();

	}

	public static void deleteAndDisplay(m_bnodeprocess bst, int d) {
		System.out.println("deleting " + d);
		bst.deletenode(d);
		System.out.println("There are total of " + bst.countNodes() + " nodes");
		bst.display_flag();
	}

	public static void addAndDisplay(m_bnodeprocess bst, int d) {
		bst.addnode(d);
		// bst.display_flag();
	}

}

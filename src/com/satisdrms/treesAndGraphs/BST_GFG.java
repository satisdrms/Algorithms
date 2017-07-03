package com.satisdrms.treesAndGraphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;


class bstval {
	int dist;
	BSTN node;

	bstval(int dist, BSTN node) {
		this.dist = dist;
		this.node = node;
	}
}

class bstvaldepth {
	int dist;
	BSTN node;
	int depth;

	bstvaldepth(int dist, BSTN node, int depth) {
		this.dist = dist;
		this.node = node;
		this.depth = depth;
	}
}

class binfound {
	boolean found, found2;
	int dist, n1, n2;

	binfound(boolean found, int dist, int n1, int n2) {
		this.found2 = false;
		this.found = found;
		this.dist = dist;
		this.n1 = n1;
		this.n2 = n2;
	}
}

class dat {
	int max, min, size;
	boolean isBST;
	BSTN node;
	static int max_size = 0;
	static BSTN rt = null;
	static dat dum = new dat(0, 0, 0, false, null);

	dat(int max, int min, int size, boolean isBST, BSTN node) {
		this.max = max;
		this.min = min;
		this.size = size;
		this.isBST = isBST;
		this.node = node;
	}
}

class BSTN {
	BSTN left, right;
	int d;

	BSTN(int d) {
		this.d = d;
	}
}

public class BST_GFG {
	BSTN root;

	public BST_GFG() {
		root = null;
	}

	public void insert(int d) {
		root = insert(root, d);
	}

	private BSTN insert(BSTN node, int d) {
		if (node == null) {
			node = new BSTN(d);
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

	private void inOrderTraversal(BSTN node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.println(node.d);
			inOrderTraversal(node.right);
		}
	}

	public void findMaxSubBST() {
		dat val = new dat(0, 0, 0, false, null);
		isBST(root, val);
		System.out.println("Max sub bst is " + dat.rt.d);
	}

	private void isBST(BSTN node, dat val) {
		if (node.right == null && node.left == null) {
			val.size++;
			if (val.size > dat.max_size) {
				dat.max_size = val.size;
				dat.rt = node;
			}
			val.isBST = true;
			val.max = node.d;
			val.min = node.d;
			return;
		}
		boolean isleftbst = false;
		int minfromleftincaseitisright = 0;
		int nodeSize = 0;
		if (node.left != null) {
			isBST(node.left, val);
			if (val.isBST && val.max < node.d) {
				isleftbst = true;
				nodeSize = val.size;
				minfromleftincaseitisright = val.min;
			}
		} else {
			isleftbst = true;
		}
		if (node.right == null) {
			if (isleftbst) {
				val.size++;
				if (val.size > dat.max_size) {
					dat.max_size = val.size;
					dat.rt = node;
					// System.out.println("max is " + dat.max_size + " " +
					// node.d);
				}
				val.max = node.d;
			} else {
				val.isBST = false;
				val.size = 0;
			}
			// return;
		} else {
			// reseting val size to count the nodes in right side,
			// we dont need any other values as well as the min is left is
			// already buffered and other values will be populated again from
			// the right side

			val.size = 0;

			isBST(node.right, val);
			// checking wheter right side is bst as well
			if (val.isBST && val.min > node.d) {
				if (isleftbst) {
					val.min = minfromleftincaseitisright;
					val.size = val.size + nodeSize + 1;
					if (val.size > dat.max_size) {
						dat.max_size = val.size;
						dat.rt = node;
						// System.out.println("max is " + dat.max_size + " " +
						// node.d);
					}
				} else {
					val.isBST = false;
					val.size = 0;
				}
				// resetting values irrespective of whether left is bst or not
				// as once right ivalids to be a bst then that node cant be a
				// subtree

			} else /* if (isleftbst) */{
				val.isBST = false;
				val.size = 0;
			}
		}
	}

	public void levelOrderTraversalSpiralForm() {
		// System.out.println(root.d + " ");
		boolean lefttoright = false;
		LinkedList<BSTN> level = new LinkedList<BSTN>();
		LinkedList<BSTN> nextlevel = new LinkedList<BSTN>();
		level.add(root);
		// int i = 0;
		while (true) {

			while (!level.isEmpty()) {
				BSTN n = null;
				if (lefttoright) {
					n = level.removeLast();
					if (n.left != null)
						nextlevel.add(n.left);
					if (n.right != null)
						nextlevel.add(n.right);
				} else {
					n = level.removeLast();
					if (n.right != null)
						nextlevel.add(n.right);
					if (n.left != null)
						nextlevel.add(n.left);

				}
				System.out.println(n.d);
			}
			for (BSTN n : level) {
				if (lefttoright) {
				} else {
				}
			}
			// System.out.println("level " + level.size() + " next " +
			// nextlevel.size()+" "+lefttoright);

			if (!nextlevel.isEmpty()) {
				level.addAll(nextlevel);
				nextlevel.clear();
				lefttoright = !lefttoright;
			} else
				break;
			// if (i++ > 3)
			// break;
		}

	}

	public void findBSTTopViewMYSOLDOESNTWORKFORLEFTRIGHTLEFT() {

		LinkedList<BSTN> topview = new LinkedList<BSTN>();
		// LinkedList<BSTN> right = new LinkedList<BSTN>();
		BSTN nodeleft = root, noderight = root;
		topview.add(root);
		int width = 1, temp = 0;
		while (nodeleft.left != null) {
			nodeleft = nodeleft.left;
			topview.addFirst(nodeleft);
			width++;
		}
		while (noderight.right != null) {
			noderight = noderight.right;
			topview.addLast(noderight);
			width++;
		}
		temp = width;
		while (noderight.left != null) {
			noderight = noderight.left;
			temp--;
			if (temp <= 0) {
				topview.addFirst(noderight);
			}
		}
		temp = width;
		while (nodeleft.right != null) {
			nodeleft = nodeleft.right;
			temp--;
			if (temp <= 0) {
				topview.addLast(nodeleft);
			}
		}
		for (BSTN n : topview) {
			System.out.println(n.d);
		}
	}

	public void findBSTTopViewBookSol() {
		Set<Integer> hori = new TreeSet<Integer>();
		LinkedList<bstval> topview = new LinkedList<bstval>();
		topview.add(new bstval(0, root));
		while (!topview.isEmpty()) {
			bstval item = topview.remove();
			if (!hori.contains(item.dist)) {
				hori.add(item.dist);
				System.out.println(item.node.d);
			}
			if (item.node.left != null) {
				topview.add(new bstval(item.dist - 1, item.node.left));
			}
			if (item.node.right != null) {
				topview.add(new bstval(item.dist + 1, item.node.right));
			}
		}

	}

	public void printbottomview() {
		HashMap<Integer, LinkedList<bstvaldepth>> maxdistbywidth = new HashMap<Integer, LinkedList<bstvaldepth>>();
		// <horizantalDepth,HeightofthatNode>
		LinkedList<bstvaldepth> bottomview = new LinkedList<bstvaldepth>();
		bottomview.add(new bstvaldepth(0, root, 0));
		LinkedList<bstvaldepth> nodes = null;
		while (!bottomview.isEmpty()) {
			bstvaldepth item = bottomview.remove();
			if (maxdistbywidth.containsKey(item.dist)) {
				nodes = maxdistbywidth.get(item.dist);
				int existingdepth = nodes.peek().depth;
				if (existingdepth == item.depth) {
					nodes.add(item);
				} else if (existingdepth < item.depth) {
					nodes.clear();
					nodes.add(item);
				}
			} else {
				LinkedList<bstvaldepth> temp = new LinkedList<bstvaldepth>();
				temp.add(item);
				maxdistbywidth.put(item.depth, temp);
			}
			if (item.node.left != null) {
				bottomview.add(new bstvaldepth(item.dist - 1, item.node.left,
						item.depth + 1));
			}
			if (item.node.right != null) {
				bottomview.add(new bstvaldepth(item.dist + 1, item.node.right,
						item.depth + 1));
			}
		}

		for (LinkedList<bstvaldepth> col : maxdistbywidth.values()) {
			for (bstvaldepth b : col) {
				System.out.println(b.node.d);
			}
		}

	}

	public void printverticalorder() {
		HashMap<Integer, LinkedList<bstval>> vertical = new HashMap<Integer, LinkedList<bstval>>();
		LinkedList<bstval> queue = new LinkedList<bstval>();
		queue.add(new bstval(0, root));
		while (!queue.isEmpty()) {
			bstval item = queue.remove();
			if (vertical.containsKey(item.dist)) {
				vertical.get(item.dist).add(item);
			} else {
				LinkedList<bstval> temp = new LinkedList<bstval>();
				temp.add(item);
				vertical.put(item.dist, temp);
			}
			if (item.node.left != null) {
				queue.add(new bstval(item.dist - 1, item.node.left));
			}
			if (item.node.right != null) {
				queue.add(new bstval(item.dist + 1, item.node.right));
			}
		}

		for (Integer i : vertical.keySet()) {
			System.out.println("The nodes in the vertical " + i + " are ");
			for (bstval b : vertical.get(i)) {
				System.out.println(b.node.d);
			}

		}

	}

	public void findDistanceBetTwoNodes(int n1, int n2) {
		binfound val = new binfound(false, 0, n1, n2);
		findDistanceBetTwoNodes(root, val, 0);
		if (val.found2) {
			System.out.println("Dist is " + Math.abs(val.dist));
		} else {
			System.out.println("node/s not found");
		}
	}

	private void findDistanceBetTwoNodes(BSTN node, binfound val, int dist) {
		if (node.d == val.n1 || node.d == val.n2) {
			// System.out.println("found " + node.d + " " + dist);

			if (!val.found) {
				val.found = true;
				val.dist = dist;

			} else {
				val.dist = dist - val.dist;
				val.found2 = true;
				return;
			}
		}
		if (node.left != null)
			findDistanceBetTwoNodes(node.left, val, dist + 1);
		if (dist == 0)
			val.dist = val.dist * -1;
		if (node.right != null)
			findDistanceBetTwoNodes(node.right, val, dist + 1);

	}
}

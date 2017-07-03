package pack1;

import java.util.ArrayList;
import java.util.LinkedList;

class BSTV2 {
	BSTV2 left, right, parent;
	int d;

	BSTV2(int d) {
		this.d = d;
		left = right = parent = null;
	}
}

public class BinarySearchTreeV2 {
	BSTV2 root;

	public BinarySearchTreeV2() {
		root = null;
	}

	public void insert(int d) {
		root = insert(root, d);
	}

	private BSTV2 insert(BSTV2 node, int d) {
		if (node == null) {
			node = new BSTV2(d);
			return node;
		} else if (node.d <= d) {
			node.right = insert(node.right, d);
			node.right.parent = node;
		} else if (node.d > d) {
			node.left = insert(node.left, d);
			node.left.parent = node;
		}
		return node;
	}

	public void inOrderTraversal() {
		inOrderTraversal(root);
	}

	private void inOrderTraversal(BSTV2 node) {
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

	private int minDepth(BSTV2 node) {
		if (node == null)
			return 0;
		return 1 + Math.min(minDepth(node.left), minDepth(node.right));
	}

	private int maxDepth(BSTV2 node) {
		if (node == null)
			return 0;
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
	}

	public void printBSTV2() {
		if (root != null) {
			String str = root.d + " is root";
			System.out.println(str);
			printBSTV2(root, str);
		}
	}

	private void printBSTV2(BSTV2 node, String str) {
		if (node.left != null) {
			String str1 = node.left.d + " is to left(parent is "
					+ node.left.parent.d + " ) of " + str;
			System.out.println(str1);
			printBSTV2(node.left, str1);
		}
		if (node.right != null) {
			String str1 = node.right.d + " is to right(parent is "
					+ node.right.parent.d + " ) of " + str;
			System.out.println(str1);
			printBSTV2(node.right, str1);
		}

	}

	public BSTV2 getNode(int data) {
		LinkedList<BSTV2> queue = new LinkedList<BSTV2>();
		BSTV2 node = null;
		queue.add(root);
		while (!queue.isEmpty()) {
			node = queue.removeFirst();
			// System.out.println("Checking " + node.d + " size of queue is " +
			// queue.size());
			if (node.d == data) {
				return node;
			}
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
		return null;
	}

	public void findInOrderSuccessor(BSTV2 node) {
		BSTV2 temp = node, prev = null;

		if (temp.right == null) {
			while (temp.parent != null && temp.d <= node.d) {
				temp = temp.parent;
			}
			if (temp.d < node.d) {
				temp = node;
			}
		} else {
			temp = temp.right;
			while (temp.left != null)
				temp = temp.left;
		}

		System.out.println("Successor is " + temp.d);

	}

	public void findCommonAncenstor(BSTV2 node1, BSTV2 node2) {
		BSTV2 t1 = node1, t2 = node2;
		int len1 = findDepthToRootNode(node1);
		int len2 = findDepthToRootNode(node2);
		while (len1 != len2) {
			if (len1 > len2) {
				t1 = t1.parent;
				len1--;
			} else {
				t2 = t2.parent;
				len2--;
			}
		}
		while (len1 != 0) {
			if (t1.d == t2.d) {
				System.out.println("Common Ancestor is " + t1.d);
				break;

			} else {
				t1 = t1.parent;
				t2 = t2.parent;
			}
		}
	}

	private int findDepthToRootNode(BSTV2 node) {
		int len = 1;
		while (node != root) {
			node = node.parent;
			len++;
		}
		return len;
	}

	public BSTV2 findCommonAncenstorSol2(BSTV2 root, BSTV2 node1, BSTV2 node2) {
		if (nodeSide(root.left, node1) && nodeSide(root.left, node2)) {
			return findCommonAncenstorSol2(root.left, node1, node2);
		} else if (nodeSide(root.right, node1) && nodeSide(root.right, node2)) {
			return findCommonAncenstorSol2(root.right, node1, node2);
		} else
			return root;

	}

	private boolean nodeSide(BSTV2 root, BSTV2 node) {
		if (root == null)
			return false;
		if (root == node)
			return true;
		return nodeSide(root.left, node) || nodeSide(root.right, node);
	}

	public String convertToInOrderString(BSTV2 node) {
		String str = "";
		if (node != null) {
			str = str + convertToInOrderString(node.left);
			str = str + node.d;
			str = str + convertToInOrderString(node.right);
			return str;
		}
		return str;
	}

	public boolean matchTree(BSTV2 main, BSTV2 sub) {
		if (sub == null)
			return true;
		else
			return checkSubInMain(main, sub);

	}

	private boolean checkSubInMain(BSTV2 main, BSTV2 sub) {
		boolean flag = false;
		if (main == null)
			return false;
		if (main.d == sub.d) {
			flag = checkSubTreeInNode(main.left, sub.left)
					&& checkSubTreeInNode(main.right, sub.right);
		}
		if (flag)
			return true;
		else
			return checkSubInMain(main.left, sub)
					|| checkSubInMain(main.right, sub);

	}

	private boolean checkSubTreeInNode(BSTV2 node1, BSTV2 node2) {
		if (node2 == null)
			return true;
		if (node1.d == node2.d) {
			return checkSubTreeInNode(node1.left, node2.left)
					&& checkSubTreeInNode(node1.right, node2.right);
		} else
			return false;
	}

	public void findSum(BSTV2 node) {
		LinkedList<BSTV2> queue = new LinkedList<BSTV2>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BSTV2 cur = queue.removeFirst();
			findSumNode(root, cur);
			//System.out.println(cur.d);
			if (cur.left != null)
				queue.add(cur.left);
			if (cur.right != null)
				queue.add(cur.right);
		}
	}

	private void findSumNode(BSTV2 trace, BSTV2 node) {
		if (trace != null) {
			//System.out.println("searching " + node.d + " in " + trace.d);
			isItAPath(trace, node, 0, new LinkedList<BSTV2>());
			// System.out.println("going below "+trace.d);
			findSumNode(trace.left, node);
			findSumNode(trace.right, node);
		}

	}

	private void isItAPath(BSTV2 tracer, BSTV2 node, int sum,
			LinkedList<BSTV2> path) {
		if (tracer != null) {

			int newSum = sum + tracer.d;
			//System.out.println(tracer.d + " sum is " + sum + " node.d is "+ node.d + " for newsum " + newSum);
			if (node.d > newSum) {
				// System.out.println((sum+tracer.d)+ " less than "+ node.d);
				path.add(tracer);
				isItAPath(tracer.left, node, newSum, path);
				isItAPath(tracer.right, node, newSum, path);
				path.removeLast();
			} else if (node.d == newSum) {
				path.add(tracer);
				System.out.println("path found for " + node.d);
				printColl(path);
				path.removeLast();
			}
			//} else if (node.d < newSum) {
				//path.removeLast();
			
			//System.out.println(path.size() + " " + path.getLast().d);
		}

	}

	private void printColl(LinkedList<BSTV2> path) {
		//System.out.println("list start");
		for (BSTV2 p : path) {
			System.out.println(p.d);
		}
		//System.out.println("list end");

	}
	private void printColl(ArrayList<Integer> path,int start,int end) {
		System.out.println("list start");
		for(int i=start;i<=end;i++)
			System.out.println(path.get(i));
		System.out.println("list end");

	}

	public void findSumBookSol(BSTV2 head) {
		int level=0;
		int sum=13;
		System.out.println("Path for the sum "+sum);
		ArrayList<Integer> path=new ArrayList<Integer>();
		findSumBookSolNode(head,sum,level,path);
		
	}

	@SuppressWarnings("unchecked")
	private void findSumBookSolNode(BSTV2 head, int sum, int level, ArrayList<Integer> path) {
		if(head==null) return;
		path.add(head.d);
		int tmp=sum;
		
		for(int i=level;i>-1;i--){
		//	System.out.println(path.get(i));
			tmp=tmp-path.get(i);
		//	System.out.println(tmp);
			if(tmp==0) printColl(path,i,level);
		}
		ArrayList<Integer> c1=(ArrayList<Integer>) path.clone();
		ArrayList<Integer> c2=(ArrayList<Integer>) path.clone();
		findSumBookSolNode(head.right,sum,level+1,c1);
		findSumBookSolNode(head.left,sum,level+1,c2);
	}
}

// if (temp.left != null && node.d < temp.left.d) {
// temp = temp.left;
// } else if (temp.right != null && node.d < temp.right.d && !(node.d < temp.d
// && node.d < temp.right.d)) {
// temp = temp.right;
// } else if (temp.parent != null && (temp.d > temp.parent.d || node.d >
// temp.d)) {
// temp = temp.parent;
// } else {
// System.out.println("successor is " + temp.d);
// return;
// }

package pack1;

class Point {
	double x, y;

	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

class KDNode {

	Point p;
	KDNode right, left;

	KDNode(Point p) {
		this.p = p;
		right = null;
		left = null;
	}
}

class Nearestpoint {
	Point p;
	int distance;

	public Nearestpoint(Point p, int distance) {
		this.p = p;
		this.distance = distance;

	}
}

class kdTree {
	KDNode root;
	int dim = 2;

	public kdTree() {
		root = null;
	}

	public void insert(KDNode ins) {
		// System.out.println("-------------------------------------");
		KDNode node = root;
		if (root == null) {
			root = ins;
			print2D();
		} else {
			int depth = -1;
			KDNode par = node;
			while (node != null) {
				depth++;
				par = node;
				if (depth % dim == 0) {
					if (ins.p.x >= node.p.x) {
						node = node.right;
					} else
						node = node.left;
				} else {
					if (ins.p.y >= node.p.y) {
						node = node.right;
					} else
						node = node.left;
				}

				// System.out.println(root.left.p.x + " x ");
			}
			if (node == null) {
				if (depth % dim == 0) {
					if (ins.p.x >= par.p.x)
						par.right = ins;
					else
						par.left = ins;
				} else {
					if (ins.p.y >= par.p.y)
						par.right = ins;
					else
						par.left = ins;
				}

			}
		}
		// print2D();

	}

	public void print2D() {
		print2D(root, " is root");
	}

	private void print2D(KDNode node, String str) {
		str = "(" + node.p.x + "," + node.p.y + "," + ")" + str;
		System.out.println(str);
		if (node.left != null) {
			print2D(node.left, " is left of " + str);
		}
		if (node.right != null) {
			print2D(node.right, " is right of " + str);
		}

	}

	public void findclosest(Point search) {
		int depth = -1;
		Point nearestNeighbour = findclosest(root, search, depth);
		System.out.println("Nearest Neighbour is (" + nearestNeighbour.x + ","
				+ nearestNeighbour.y + ")");
	}

	private Point findclosest(KDNode node, Point search, int depth) {
		// x=9 y=32

		if (node == null) {
			return null;
		}
		depth++;
		KDNode CurrentPath, OtherPath;
		if (depth % dim == 0) {
			if (search.x < node.p.x) {
				CurrentPath = node.left;
				OtherPath = node.right;
			} else {
				CurrentPath = node.right;
				OtherPath = node.left;
			}
		} else {// Dimension is Y
			if (search.y < node.p.y) {
				CurrentPath = node.left;
				OtherPath = node.right;
			} else {
				CurrentPath = node.right;
				OtherPath = node.left;
			}
		}
		Point p = findclosest(CurrentPath, search, depth);
		Point p1;
		if (p == null) {
			p = node.p;
			// System.out.println("First is (" + p.x + "," + p.y
			// + ") and distance is " + (int) getDistance(p, search));
		} else {
			p = getClosestPointToSearch(search, node.p, p);
		}

		if (OtherPath != null) {
			double distToOtherPlane;
			if (depth % dim == 0) {
				distToOtherPlane = Math.abs(node.p.y - search.y);
			} else {
				distToOtherPlane = Math.abs(node.p.x - search.x);
			}
			if (distToOtherPlane < getDistance(p, search)) {
				// System.out
				// .println("("
				// + node.p.x
				// + ","
				// + node.p.y
				// + ")"
				// +
				// "Checking the adjacent hyper plane as the distance to current best is greater that the planes coordinates");
				p1 = findclosest(OtherPath, search, depth);
				return getClosestPointToSearch(search, p, p1);
			}
		}
		// System.out.println("Checking " + "(" + node.p.x + "," + node.p.y
		// + ") and current best is " + "(" + p.x + "," + p.y + ")");

		return p;
	}

	public double getDistance(Point p1, Point p2) {
		// System.out.println(Math.sqrt(((p1.x - p2.x) * (p1.x - p2.x))
		// + ((p1.y - p2.y) * (p1.y - p2.y))));
		return Math.sqrt(((p1.x - p2.x) * (p1.x - p2.x))
				+ ((p1.y - p2.y) * (p1.y - p2.y)));
	}

	private Point getClosestPointToSearch(Point search, Point p1, Point p2) {
		double distance1 = Math.sqrt(((search.x - p1.x) * (search.x - p1.x))
				+ ((search.y - p1.y) * (search.y - p1.y)));
		double distance2 = Math.sqrt(((search.x - p2.x) * (search.x - p2.x))
				+ ((search.y - p2.y) * (search.y - p2.y)));

		if (distance1 <= distance2) {
			return p1;
		} else
			return p2;
	}
}

public class Topic_GFG_KD_Tree {
	// https://itools.subhashbose.com/grapher/index.php
	// to plot the graph from my below given points

	public static void main(String[] args) {
		kdTree tree = new kdTree();
		tree.insert(new KDNode(new Point(10, 10)));
		tree.insert(new KDNode(new Point(1, 3)));
		tree.insert(new KDNode(new Point(11, 23)));
		tree.insert(new KDNode(new Point(4, 5)));
		tree.insert(new KDNode(new Point(15, 33)));
		tree.insert(new KDNode(new Point(7, 7)));
		tree.insert(new KDNode(new Point(36, 25)));
		tree.insert(new KDNode(new Point(6, 78)));
		tree.insert(new KDNode(new Point(34, 73)));
		tree.insert(new KDNode(new Point(2, 1)));

		// tree.print2D();

		tree.findclosest(new Point(9, 32));// closest is 15,33

		// tree.findclosest(new Point(16, 34));// closest is 15,33

		// tree.findclosest(new Point(1, 1));// closest is 15,33

		// System.out.println(tree.getDistance(new Point(15,33), new
		// Point(9,32)));
		// System.out.println(tree.getDistance(new Point(11,23), new
		// Point(9,32)));
	}
}

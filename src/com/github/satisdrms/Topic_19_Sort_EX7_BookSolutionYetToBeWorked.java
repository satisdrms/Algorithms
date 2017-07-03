package com.github.satisdrms;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

//A circus is designing a tower routine consisting of people standing atop one another’s shoulders. 
//For practical and aesthetic reasons, each person must be both shorter and lighter than the person below him or her. 
//Given the heights and weights of each person in the circus, write a method to compute the largest possible number of people in such a tower.
//EXAMPLE:
//Input (ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
//Output: The longest tower is length 6 and includes from top to bottom: (56, 90) (60,95) (65,100) (68,110) (70,150) (75,190)

public class Topic_19_Sort_EX7_BookSolutionYetToBeWorked {

	public static void main(String[] args) {
		System.out.println("Start is " + Calendar.getInstance().getTime());
		int[][] p = { { 65, 98 }, { 70, 150 }, { 56, 90 }, { 75, 190 },
				{ 60, 95 }, { 68, 110 }, { 56, 92 }, { 60, 97 }, { 53, 63 },
				{ 93, 96 }, { 100, 134 }, { 95, 100 }, { 96, 123 },
				{ 97, 134 }, { 98, 144 }, { 99, 170 }, { 101, 163 },
				{ 101, 190 }, { 101, 200 }, { 92, 95 }, { 91, 96 }, { 1, 1 },
				{ 66, 109 }, { 65, 98 }, { 70, 150 }, { 56, 90 }, { 75, 190 },
				{ 60, 95 }, { 68, 110 }, { 56, 92 }, { 60, 97 }, { 53, 63 },
				{ 93, 96 }, { 100, 134 }, { 95, 100 }, { 96, 123 },
				{ 97, 134 }, { 98, 144 }, { 99, 170 }, { 101, 163 },
				{ 101, 190 }, { 101, 200 }, { 92, 95 }, { 91, 96 }, { 1, 1 },
				{ 66, 109 }

		};
		// OUTPUT EXPECTED
		// 101 200
		// 99 170
		// 98 144
		// 97 134
		// 96 123
		// 68 110
		// 66 109
		// 65 98
		// 60 97
		// 56 92
		// 53 63
		// 1 1
		// findTower_NotWorkingForAllCases(p);
		// findTower_Works_BruteForce_TakesTooMuchTime(p);//10 secs for 44 items
		findTower(p);
		System.out.println("End is " + Calendar.getInstance().getTime());

	}

	private static void findTower(int[][] p) {
		for (int i = 0; i < p.length; i++) {
			for (int j = i + 1; j < p.length; j++) {
				if (p[i][0] > p[j][0]) {
					swap(i, j, p);
				}
			}
		}
		for (int i = 0; i < p.length; i++) {
			for (int j = i + 1; j < p.length; j++) {
				if (p[i][0] == p[j][0] && p[i][1] > p[j][1]) {
					swap(i, j, p);
				}
			}
		}
		print(p);
		int prevL1 = 0, prev = 0, firstFit = p.length, nextUnfit = 0, firstUnfit = 0, slider = p.length;
		int current = 0;
		LinkedHashSet<Integer> unFitItems = new LinkedHashSet<Integer>();
		LinkedList<Integer[][]> next = new LinkedList<Integer[][]>();
		LinkedList<Integer> path = new LinkedList<Integer>();
		LinkedList<Integer[][]> nextseq = new LinkedList<Integer[][]>();
		LinkedList<Integer[][]> maxSeq = new LinkedList<Integer[][]>();

		while (current < p.length) {
			next = new LinkedList<Integer[][]>();
			path = new LinkedList<Integer>();
			boolean isFirstUnFit = true;
			for (int i = current; i < p.length; i++) {
				// System.out.println("i is " + i);
				if (i == 0
						|| (p[prevL1][0] < p[i][0] && p[prevL1][1] < p[i][1] && !unFitItems
								.contains(i))) {
					Integer[][] temp = { { p[i][0], p[i][1] } };
					next.add(temp);
					if (isFirstUnFit)
						path.addFirst(i);
					prevL1 = i;
				} else if (isFirstUnFit && !unFitItems.contains(i)) {
					firstFit = prevL1;
					firstUnfit = i;
					isFirstUnFit = false;
				}
				// unFitItems.add(firstUnfit);
			}
			System.out.println("f " + firstUnfit + " prevL1 " + prevL1
					+ " first fit " + firstFit);
			if (maxSeq.size() == 0)
				maxSeq = next;
			if (current != firstUnfit) {
				LinkedHashSet<Integer> unFitItemsChecker = new LinkedHashSet<Integer>();

				// for (Integer in : path) {
				for (int in = firstFit; in >= 0; in--) {
					System.out.println(in);
					nextseq = new LinkedList<Integer[][]>();
					unFitItemsChecker.add(in);
					for (int i = 0; i < p.length; i++) {
						if (i == 0
								|| (p[prev][0] < p[i][0]
										&& p[prev][1] < p[i][1]
										&& !unFitItems.contains(i) && !unFitItemsChecker
											.contains(i))) {
							Integer[][] temp = { { p[i][0], p[i][1] } };
							nextseq.add(temp);
							prev = i;
						}

					}
					if (maxSeq.size() < nextseq.size()) {
						maxSeq = nextseq;
						unFitItems.addAll(unFitItemsChecker);
						firstFit = getLastFitBelowCurrentUnFit(unFitItems,
								unFitItemsChecker, in);
					}
					//printArray(nextseq);

				}
				current = path.getFirst() + 1;

			} else {
				unFitItems.add(firstUnfit);
				current = firstUnfit + 1;
			}
			prevL1 = firstFit;
			System.out.println("Current is " + current + " and prev is "
					+ prevL1);
			printArray(maxSeq);
			printLLSet(unFitItems);
			// break;// breaking out of first loop for testing
			slp(1000);
		}

		System.out.println("Final Seq is");
		printArray(maxSeq);
		// if (ma)

		// }
		//
		// for (int o = 0; o < 6; o++) {
		// next = new ArrayList<Integer[][]>();
		// nextseq = new ArrayList<Integer[][]>();
		// nextUnfit = 0;
		// for (int i = 0; i < p.length; i++) {
		// if (i == 0
		// || (p[prev][0] < p[i][0] && p[prev][1] < p[i][1] && !unFitItems
		// .contains(i))) {
		// Integer[][] temp = { { p[i][0], p[i][1] } };
		// next.add(temp);
		// prev = i;
		// if (lastUnfit > i)
		// nextUnfit = i;
		// }
		// }
		// System.out.println("next unfit is " + nextUnfit);
		// lastUnfit = nextUnfit;
		// // unFitItems.add(prev);
		// for (int i = 0; i < p.length; i++) {
		// if (i == 0
		// || (p[prev][0] < p[i][0] && p[prev][1] < p[i][1]
		// && !unFitItems.contains(i) && lastUnfit != i)) {
		// Integer[][] temp = { { p[i][0], p[i][1] } };
		// nextseq.add(temp);
		// prev = i;
		// }
		// }
		// printArray(nextseq);
		//
		// if (next.size() < nextseq.size()) {
		// next = nextseq;
		// unFitItems.add(lastUnfit);
		// }
		// if (next.size() > maxSeq.size()) {
		// maxSeq = next;
		// }
		// printArray(maxSeq);
		// printLLSet(unFitItems);

	}

	private static int getLastFitBelowCurrentUnFit(
			LinkedHashSet<Integer> unFitItems,
			LinkedHashSet<Integer> unFitItemsChecker, Integer in) {
		int lastFit = 0;
		for (int i = 0; i < in; i++) {
			if (!unFitItems.contains(i) || !unFitItemsChecker.contains(i)) {
				lastFit = i;
			}
		}
		return lastFit;
	}

	private static void findTower_Works_BruteForce_TakesTooMuchTime(int[][] p) {
		for (int i = 0; i < p.length; i++) {
			for (int j = i + 1; j < p.length; j++) {
				if (p[i][0] > p[j][0]) {
					swap(i, j, p);
				}
			}
		}
		for (int i = 0; i < p.length; i++) {
			for (int j = i + 1; j < p.length; j++) {
				if (p[i][0] == p[j][0] && p[i][1] > p[j][1]) {
					swap(i, j, p);
				}
			}
		}
		// print(p);

		createTower_BruteForce_TakesTooMuchTime(p);

		// while (true) {
		// System.out.println("Next Loop prev "+lastUnfit);
		// for (int i = 0; i < p.length; i++) {
		// if (i == 0
		// || (p[prev][0] < p[i][0] && p[prev][1] < p[i][1] && !unFitItems
		// .contains(i))) {
		// Integer[][] temp = { { p[i][0], p[i][1] } };
		// next.add(temp);
		// prev = i;
		// if(slider>lastUnfit)
		// lastUnfit=i;
		//
		// }
		// }
		// /*
		// * if (largest.size() == 0) { largest = next;
		// * unFitItems.remove(lastUnfit);
		// *
		// * } else
		// */if (largest.size() < next.size())
		// largest = next;
		// /*else if (largest.size() == next.size()) {
		// largest = next;
		// unFitItems.remove(lastUnfit);
		//
		// }*/ else{
		// unFitItems.remove(lastUnfit);
		// slider=lastUnfit;
		// }
		// next = new ArrayList<Integer[][]>();
		// lastUnfit = prev;
		// unFitItems.add(prev);
		// printLLSet(unFitItems);
		//
		// printArray(largest);
		// slp(2000);
		// }
	}

	/**
	 * @param p
	 */
	private static void createTower_BruteForce_TakesTooMuchTime(int[][] p) {
		LinkedList<LinkedList<Integer[][]>> largest = new LinkedList<LinkedList<Integer[][]>>();
		LinkedList<LinkedList<Integer[][]>> picker = new LinkedList<LinkedList<Integer[][]>>();
		LinkedList<Integer[][]> next = new LinkedList<Integer[][]>();
		LinkedList<Integer[][]> updated = new LinkedList<Integer[][]>();

		LinkedList<Integer[][]> maxSeq = new LinkedList<Integer[][]>();

		for (int i = p.length - 1; i >= 0; i--) {
			next = new LinkedList<Integer[][]>();
			picker = new LinkedList<LinkedList<Integer[][]>>();
			Integer[][] temp = { { p[i][0], p[i][1] } };
			if (i == p.length - 1) {
				next.add(temp);
				picker.add(next);
			} else {
				boolean isLast = true;
				for (LinkedList<Integer[][]> exist : largest) {
					Integer[][] last = exist.peekLast();
					if (temp[0][0] < last[0][0] && temp[0][1] < last[0][1]) {
						updated = new LinkedList<Integer[][]>();
						updated.addAll(exist);
						updated.add(temp);
						picker.add(updated);
						isLast = false;
					}
					if (updated.size() > maxSeq.size()) {
						maxSeq = updated;
					}
				}
				if (isLast) {
					next.add(temp);
					picker.add(next);
				}
			}
			largest.addAll(picker);
		}
		System.out.println("Maxseq is ");
		for (Integer[][] i : maxSeq) {
			System.out.println(i[0][0] + " " + i[0][1]);
		}
	}

	private static void print(LinkedList<LinkedList<Integer[][]>> largest) {
		for (LinkedList<Integer[][]> l : largest) {
			System.out.println("A sequence");
			for (Integer[][] i : l) {
				System.out.println(i[0][0] + " " + i[0][1]);
			}

		}

	}

	/**
	 * @param unFitItems
	 */
	private static void printLLSet(LinkedHashSet<Integer> unFitItems) {
		System.out.println("Unfit items are  ");
		for (Integer i : unFitItems)
			System.out.println(i);
	}

	/**
	 * @param time
	 */
	private static void slp(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param next
	 */
	private static void printArray(ArrayList<Integer[][]> next) {
		System.out.println();
		System.out.println("Array is ");
		for (Integer[][] i : next) {
			System.out.println(i[0][0] + " " + i[0][1]);
		}
	}

	private static void printArray(LinkedList<Integer[][]> next) {
		System.out.println();
		System.out.println("Array is ");
		for (Integer[][] i : next) {
			System.out.println(i[0][0] + " " + i[0][1]);
		}
	}

	private static void print(int[][] p) {
		for (int i = 0; i < p.length; i++)
			System.out.println(p[i][0] + " " + p[i][1] + "---" + i);
	}

	/**
	 * @param p
	 */
	private static void findTower_NotWorkingForAllCases(int[][] p) {

		for (int i = 0; i < p.length; i++) {
			for (int j = i + 1; j < p.length; j++) {
				if (p[i][0] < p[j][0]) {
					swap(i, j, p);
				}
			}
		}
		for (int i = 0; i < p.length; i++) {
			for (int j = i + 1; j < p.length; j++) {
				if (p[i][0] == p[j][0] && p[i][1] < p[j][1]) {
					swap(i, j, p);
				}
			}
		}

		int[] weights = calculateWeight(p);

		print(p, weights);

		int tLen = -1;
		int[][] tower = p.clone();

		for (int i = 0; i < p.length;) {
			tLen++;
			tower[tLen][0] = p[i][0];
			tower[tLen][1] = p[i][1];
			int w = -1, pos = 0;
			for (int j = i; j < p.length; j++) {
				if (w < weights[j] && p[i][0] > p[j][0] && p[i][1] > p[j][1]) {
					w = weights[j];
					pos = j;
				}
			}
			if (w != -1) {
				i = pos;
			} else {
				i++;
			}
		}
		System.out.println("length is " + (tLen + 1) + " and final output is ");

		print(tower, tLen + 1);

	}

	private static int[] calculateWeight(int[][] p) {
		int[] weights = new int[p.length];
		for (int i = 0; i < p.length; i++) {
			int w = 0, cur = i + 1;
			for (int j = i + 1; j < p.length; j++) {

				if (p[i][1] > p[j][1] && p[i][0] > p[j][0])
					w++;
			}
			weights[i] = w;
		}
		return weights;
	}

	private static void print(int[][] p, int tLen) {

		for (int i = 0; i < tLen; i++)
			System.out.println(p[i][0] + " " + p[i][1]);

	}

	private static void print(int[][] p, int[] weights) {

		for (int i = 0; i < p.length; i++)
			System.out.println(p[i][0] + " " + p[i][1] + "--" + weights[i]);

	}

	private static void swap(int i, int j, int[][] p) {
		int a, b;
		a = p[i][0];
		b = p[i][1];
		p[i][0] = p[j][0];
		p[i][1] = p[j][1];
		p[j][0] = a;
		p[j][1] = b;

	}

	private static int[][] getMax(int[][] p) {
		int[][] max = { { p[0][0], p[0][1] } };
		for (int i = 0; i < p.length; i++) {
			if (max[0][0] < p[i][0] || max[0][1] < p[i][1]) {
				max[0][0] = p[i][0];
				max[0][1] = p[i][1];
			}
		}
		return max;
	}

}

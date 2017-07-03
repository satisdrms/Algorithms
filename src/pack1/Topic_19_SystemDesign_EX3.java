package pack1;
//12.3 Given an input file with four billion integers, provide an algorithm to generate an integer which is not contained in the file. Assume you have 1 GB of memory.

//FOLLOW UP
//What if you have only 10 MB of memory?

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Topic_19_SystemDesign_EX3 {

	public static void main(String[] args) throws FileNotFoundException {
		// bookSol_With2GMem();
		boolSol10MBMEM();
	}

	private static void boolSol10MBMEM() throws FileNotFoundException {
		int blocks = 4096;
		int bitSize = 1048576;
		byte[] bv = new byte[1048576 / 8];
		int[] b = new int[blocks];
		Scanner in = new Scanner(new FileReader(new File("")));
		while (in.hasNextInt()) {
			int i = in.nextInt();
			b[i / bitSize]++;
		}
		int m = 0;
		for (int i = 0; i < blocks; i++)
			if (b[i] < bitSize) {
				m = i * bitSize;
				break;
			}
		in = new Scanner(new FileReader(new File("")));

		while (in.hasNextInt()) {
			int i = in.nextInt();
			if (i < (m + bitSize) && i > m)
				bv[(i - m) / 8] |= (1 << bv[(i - m) % 8]);
		}

		for (int i = 0; i < bitSize / 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((bv[i] & (1 << j)) == 0) {
					System.out.println((i) * 8 + j + m);
				}
			}
		}

	}

	private static void bookSol_With2GMem() throws FileNotFoundException {
		// BitVector<Integer> a;
		// BufferedReader in=new BufferedReader(new FileReader(new File("")));
		// Scanner S_in=new Scanner(new FileReader(new File("")));
		// Scanner S_in2=new Scanner(in);
		byte[] bitfield = new byte[0xFFFFFFF / 8];
		byte s = 127;
		System.out.println(s);
		int o = 0xFFFFFFF;
		// int j = 88;
		System.out.println(Integer.toBinaryString(o) + " " + o);
		byte[] a = new byte[o / 8];
		Scanner in = new Scanner(new FileReader(new File("")));
		while (in.hasNextInt()) {
			int i = in.nextInt();
			a[i / 8] |= (1 << a[i % 8]);
		}
		for (int i = 0; i < o / 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((a[i] & (1 << j)) == 0) {
					System.out.println(i * 8 + j);
				}
			}
		}
	}

}

package com.satisdrms.CCTI;

//Implement the “paint fill” function that one might see on many image editing programs. 
//That is, given a screen (represented by a 2 dimensional array of Colors), a point, and a new color, fill in the 
//surrounding area until you hit a border of that color.’

public class Topic_19_Recur_EX6 {

	public static void main(String[] args) {
		int x = 2, y = 2;
		int dim = 9;
		int[][] img = new int[dim][dim];
		fillImg(img, dim - 1);
		System.out.println("Before image ");
		printImg(img, dim);
		
		System.out.println();
		paint(x, y, dim, img, img[x][y]);
		System.out.println("after image ");
		printImg(img, dim);

	}

	private static void paint(int x, int y, int dim, int[][] img, int oldColor) {
		System.out.println("---- OUT "+x+" "+y);
		if(x>0 && y>0 && x<dim && y<dim && img[x][y]==oldColor){
			System.out.println(""+x+" "+y);
			img[x][y]=1;
			paint(x-1, y, dim, img, oldColor);
			paint(x, y-1, dim, img, oldColor);
			paint(x+1, y, dim, img, oldColor);
			paint(x, y+1, dim, img, oldColor);
		}

	}

	private static void printImg(int[][] img, int dim) {
		for (int i = 0; i < dim; i++) {
			System.out.println();
			for (int j = 0; j < dim; j++) {
				System.out.print(img[i][j]);

			}
		}
	}

	private static void fillImg(int[][] img, int dim) {
		// for (int i = 0; i < img.length; i++) {
		// for (int j = 0; j < img[i].length; j++) {
		// img[i][j] = 1;
		// }
		// }

		int x = 0, y = 0;
		// img[x][y]=1;
		while (x < dim || y < dim) {
			System.out.println(x + " " + y + " " + dim);
			if (y < dim) {
				y++;
				img[x][y] = 1;
				img[y][x] = 1;

			} else {

				x++;
				img[x][y] = 1;
				img[y][x] = 1;

			}
		}

	}

}

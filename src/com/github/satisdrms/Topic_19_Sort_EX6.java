package com.github.satisdrms;

//Given a matrix in which each row and each column is sorted, 
//write a method to find an element in it.

public class Topic_19_Sort_EX6 {

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3, 4, 5 }, 
						{ 6, 7, 8, 9, 10 },
						{ 11, 12, 13, 14, 15 }, 
						{ 16, 17, 18, 19, 20 } };
		int find=20;
		findInMatrix(mat,find,0,0);
		

	}

	private static void findInMatrix(int[][] mat, int find, int x, int y) {
		System.out.println("Checking ("+(x)+","+(y)+")");
		if(mat[x][y]==find){
			System.out.println(find+" is found in ("+(x+1)+","+(y+1)+") ");
			return;
		}else if( y==mat[x].length-1)
		{
			System.out.println("not found");
			return;
		}
		if(x+1<mat.length && mat[x+1][y]<find){
			findInMatrix(mat,find,x+1,y);
		}else 
		findInMatrix(mat,find,x,y+1);
		
		
	}

}

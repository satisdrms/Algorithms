package com.github.satisdrms.CCTI;
//Find sum of all elements in a matrix except the elements in row and/or column of given cell?

public class Topic_GFG_EX6 {

	public static void main(String[] args) {
		int[][] mat = { { 1, 1, 2, 1, 2 }, 
						{ 2, 2, 1, 2, 2 }, 
						{ 1, 2, 2, 1, 1 }, 
						{ 0, 0, 1, 1, 1 }, 
						{ 1, 1, 1, 2, 0 } };
		int x=3,y=4;
		int sum=0;
		for(int i=0;i<mat.length;i++)
			for(int j=0;j<mat[0].length;j++){
				if(i==x || j==y)
					continue;
				else sum=sum+mat[i][j];
			}
		System.out.println(sum);
	}

}

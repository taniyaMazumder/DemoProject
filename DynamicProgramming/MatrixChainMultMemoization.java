package DynamicProgramming;

import java.util.Arrays;

public class MatrixChainMultMemoization {

	 //GLOBAL ARRAY
    static int t[][] =new int[501][501];
    
	public static void main(String[] args) {
		int[] ar = {40,20,30,10,30};
		System.out.println(matrixChainMemoization(ar));

	}

	static int matrixMult(int[] arr, int i, int j) {
		// Base condition
		if(i >=j) {
			return t[i][j] = 0;
		}
		// check if the value is already evaluated or not
		if(t[i][j] != -1) {
			return t[i][j] ;
		}
		int min = Integer.MAX_VALUE;
		for(int k =i; k <j;k++) {
			int temp = matrixMult(arr,i, k) + matrixMult(arr, k+1, j) + (arr[i-1] * arr[k] * arr[j]);

			min = Math.min(temp, min);
		}
		return t[i][j] = min;
	}
	 
	static int matrixChainMemoization(int[] ar) {
		// initialize the matrix with -1
		for(int[] matrix : t) {
			Arrays.fill(matrix, -1);
		}
		return matrixMult(ar, 1, ar.length -1);
	}
}

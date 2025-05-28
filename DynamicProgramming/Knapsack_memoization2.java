package DynamicProgramming;

import java.util.Arrays;

public class Knapsack_memoization2 {

	public static void main(String[] args) {
//		int[] wt = {1,3,4,5};
		int[] wt = {4, 5, 1};
		int n= wt.length;
//		int[] val = {1,4,5,7};
		int[] val = {1, 2, 3};
		int w = 4;
		int[][] t = new int[n+1][w+1];
		// Initialize the DP array with -1 to indicate that subproblems are not solved
//        for (int row[] : t) {
//            Arrays.fill(row, -1);
//        }
		for(int i=0;i<t.length;i++){
            for(int j=0;j<t[i].length;j++){
                t[i][j] =-1;
            }
        }
		System.out.println(knapsackMem(wt, val,w,n,t));

	}

	private static int knapsackMem(int[] wt, int[] val, int w, int n, int[][] t) {
		if( n==0 || w==0) {
			return 0;
		}
		if(t[n][w] !=-1) {
			return t[n][w];
		}
		if(wt[n-1] <= w) {
			return t[n][w] = Math.max(val[n-1] + knapsackMem(wt,val,w-wt[n-1],n-1,t), knapsackMem(wt,val,w,n-1,t));
		} 
		else {
			return t[n][w] =knapsackMem(wt,val,w,n-1,t);
		}
	}

	
}

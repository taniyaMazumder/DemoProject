package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class MinSubSetSumDifferenceRec {

	public static void main(String[] args) {
		int[] arr = {1,1,2,3};
		System.out.println(minDifferenceRec(arr, arr.length));

	}
	// using recursion
	public static int minDifferenceRec(int arr[], int n) 
	{ 
	  int sum =0;
	  int min = Integer.MAX_VALUE;
	  for(int i=0;i<arr.length;i++) {
		  sum = sum + arr[i];
	  }
	  int[][] t = new int[n+1][sum+1];
	  for(int[] matrix : t) {
		  Arrays.fill(matrix, -1);
	  }
	  helper(arr,n,sum,t);
	  
	  ArrayList<Integer> list = new ArrayList<>();

		  for (int i = 0; i < sum/2; i++) {
			if(t[n][i] == 1) {
				list.add(i);
			}
		}
		//STEP 3: CALCULATE THE MIN BY (SUM - 2*(LIST.GET(I))
		    
		    for(int i =0; i<list.size(); i++)
		    {
		        min = Math.min(min, sum - (2*list.get(i)));
		    }

	   return min;
	}
	private static int helper(int[] arr, int n, int sum,int[][] t) {
		// base condition
		if(sum>=0 && n==0) {
			return 0;
		}
		else if(n>=0 && sum ==0) {
			return 1;
		}
		if(t[n][sum] != -1) {
			return t[n][sum];
		}
		else if(arr[n-1] <=sum) {
			return t[n][sum] = Math.max(helper(arr,n-1,sum-arr[n-1],t) , helper(arr,n-1,sum,t));
		}
		else {
			return t[n][sum] = helper(arr,n-1,sum,t);
		}
	}
     
}

package DynamicProgramming;

import java.util.Arrays;

public class CountNoOfSubsetWithDiffRec {

	public static void main(String[] args) {
		int[] arr = {1,1,2,3};
		int diff =1;
		
		System.out.println(countOfSubsetDiff(arr, diff, arr.length));

	}
// using memoization
	static int countOfSubsetDiff(int[] arr, int diff, int n) {
		// find sum of the array
		int sum =0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		int actualSum = (sum + diff) /2;
		int[][] t = new int[arr.length +1][actualSum +1];
		
		for(int[] matrix: t) {
			Arrays.fill(matrix, -1);
		}
		return helper(arr,actualSum,n,t);
	}

	private static int helper(int[] ar, int sum, int n, int[][] t) {
		// Base condition
				if(n >=0 && sum ==0) {
					return 1;
				}
				else if(n==0 && sum >0) {
					return 0;
				}
				else if(t[n][sum] != -1) {
					return t[n][sum];
				}
				else if(ar[n-1] <= sum) {
					t[n][sum] = helper(ar,sum - ar[n-1],n-1,t) + helper(ar, sum, n-1,t);
				}
				else {
					t[n][sum] = helper(ar, sum, n-1,t);
				}
				return t[n][sum] ;
	}
}

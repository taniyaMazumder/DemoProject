//Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k. If such a subset cannot be made, then return null.

//Integers can appear more than once in the list. You may assume all numbers in the list are positive.

//For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.

package DynamicProgramming;

public class SubsetSumDP {
   
	public static void main(String[] args) {
		int[] arr= {2,3,4};
		int sum = 11;
//		System.out.println(findTargetSubsetTopDown(arr,sum));
//		System.out.println(findSubsetRec(arr,sum));
		System.out.println(findSubsetMemoization(arr,sum));
}
	static boolean findTargetSubsetTopDown(int[] arr, int sum) {
		
		return helper(arr, sum, arr.length);
	}
	public static boolean helper(int[] arr, int sum, int n) {
		boolean[][] t = new boolean[arr.length +1][sum +1];
		
		//initialization true and false
        for(int i = 0; i<sum+1; i++)
        {
        	t[0][i] = false;
        }
        
        for(int i = 0; i<n+1; i++)
        {
        	t[i][0] = true;
        }
        
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < sum+1; j++) {
				if(arr[i-1] <=j) {
					t[i][j] = t[i-1] [j - arr[i-1]] ||  t[i-1][j];
				}else  {
					t[i][j] = t[i-1][j];
				} 
			}
		}
		return t[n][sum];
	} 
	// using recursion
	static boolean findSubsetRec(int[] ar, int target) {
		return helper2(ar,target, ar.length);
	}
	private static boolean helper2(int[] ar, int target, int n) {
		// Base condition
		if(n >=0 && target ==0) {
			return true;
		}
		else if(n==0 && target >0) {
			return false;
		}
		else if(ar[n-1] <= target) {
			return helper2(ar,target - ar[n-1],n-1) || helper2(ar, target, n-1);
		}
		else {
			return helper2(ar, target, n-1);
		}
	}
	// using memoization
	
	static boolean findSubsetMemoization(int[] ar, int target) {
		int n = ar.length;
		boolean[][] t = new boolean[n+1][target +1];
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t.length; j++) {
				t[i][j] = false;
			}
		}
		//  Arrays.fill(t, false);
		  return helper3(ar,target, ar.length,t);
	}
	private static boolean helper3(int[] ar, int target, int n, boolean[][] t) {
		// Base condition
		if(n >=0 && target ==0) {
			return true;
		}
		else if(n==0 && target >0) {
			return false;
		}
		else if(t[n][target] != false) {
			return t[n][target];
		}
		else if(ar[n-1] <= target) {
			t[n][target] = helper3(ar,target - ar[n-1],n-1,t) || helper3(ar, target, n-1,t);
		}
		else {
			t[n][target] = helper3(ar, target, n-1,t);
		}
		return t[n][target] ;
	}
}

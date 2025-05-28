package DynamicProgramming;

public class FindCountSubsetTartgetGFG {

	public static void main(String[] args) {
		int[] ar= {5, 2, 3, 10, 6, 8};
		int target=10;
		System.out.println(perfectSum(ar, target));

	}

	private static int perfectSum(int[] ar, int target) {
		return helper(ar, target,ar.length);
	}

	private static int helper(int[] ar, int target, int n) {
		// Base condition
				if(n >=0 && target ==0) {
					return 1;
				}
				else if(n==0 && target >0) {
					return 0;
				}
				else if(ar[n-1] <= target) {
			return helper(ar,target-ar[n-1],n-1) + helper(ar, target,n-1);
		} else {
			return helper(ar, target,n-1);
		}
	}

}

package DynamicProgramming;

public class UnboundedKnapsackRecursion {

	public static void main(String[] args) {
		int[] wt = {1,3,4,5};
		int[] val = {1,4,5,7};
		int w = 7;
		
		
		System.out.println(unboundedKnapsack(wt,val,w,wt.length -1));

	}
	public static int unboundedKnapsack(int[] wt, int[] val, int w, int n) {
		if( n==0 || w==0) {
			return 0;
		}
		if(wt[n-1] <=w) {
			return Math.max(val[n-1] + unboundedKnapsack(wt, val, w - wt[n-1],n), unboundedKnapsack(wt, val, w ,n-1));
		} else {
			return unboundedKnapsack(wt, val, w ,n-1);
		}
		
	}

}

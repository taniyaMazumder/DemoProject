// Given an array , find the sub-array with the largest sum, and return its sum.
package SlidingWindow;

public class MaxSubArrayVariableSLW {

	public static void main(String[] args) {
		int[] ar = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArraySLW(ar));
	}
	// Brute force solution
	public static int maxSubArrayBF(int[] nums) {
		
		int maxSum = Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++) {
			int sum =0;
			for(int j=i;j<nums.length;j++) {
				sum = sum + nums[j];
				maxSum = Math.max(maxSum, sum);
			}
			
		}
		return maxSum;
	}
	// using sliding window
	public static int maxSubArraySLW(int[] nums) {
		
		int maxSum = Integer.MIN_VALUE;
		int i=0,j=0, sum =0;
		while(j<  nums.length) {
			if(sum <0 ) {
				sum =0;
				i=j;
			}
			sum = sum + nums[j];
			maxSum = Math.max(maxSum, sum);
			j++;
		}
		return maxSum;
	}
	
}

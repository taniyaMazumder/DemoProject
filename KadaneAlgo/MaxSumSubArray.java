// Given an array , find the sub-array with the largest sum, and return its sum.
package KadaneAlgo;

public class MaxSumSubArray {

	public static void main(String[] args) {
		int[] ar = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArrayKadane(ar));

	}
 
	public static int maxSubArrayKadane(int[] nums) {
		
		int maxSum = Integer.MIN_VALUE;
		int currsum =0;
		for(int i=0;i<nums.length;i++) {
			currsum = currsum + nums[i];
			maxSum = Math.max(maxSum, currsum);
			if(currsum <0) {
				currsum =0;
			}
			
		}
		return maxSum;
	}
	
}

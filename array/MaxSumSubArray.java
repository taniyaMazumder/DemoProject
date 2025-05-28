// Leetcode: https://leetcode.com/problems/maximum-subarray
// Intuition:
/*
 * 1. We start by initializing two variables: maxSum and currentSum.
 * 	maxSum represents the maximum sum encountered so far and is initially set to the minimum possible integer value to ensure that any valid subarray sum will be greater than it.
 *  currentSum represents the current sum of the subarray being considered and is initially set to 0.
2. We iterate through the nums array using a for loop, starting from the first element and going up to the last element.
3. For each element in the array, we add it to the current sum currentSum. This calculates the sum of the subarray ending at the current element.
4. Next, we check if the current sum currentSum is greater than the current maximum sum maxSum.
	If it is, we update maxSum with the new value of currentSum. This means we have found a new maximum subarray sum.
5. If the current sum currentSum becomes negative, it indicates that including the current element in the subarray would reduce the overall sum. In such cases, we reset currentSum to 0. This effectively discards the current subarray and allows us to start a fresh subarray from the next element.
6. We repeat steps 3 to 5 for each element in the array.
7. After iterating through the entire array, the variable maxSum will contain the maximum subarray sum encountered.
8. Finally, we return the value of maxSum as the result, representing the maximum sum of a contiguous subarray within the given array nums.
 */

package array;

import java.util.ArrayList;
import java.util.List;

public class MaxSumSubArray {

	public static void main(String[] args) {
		int[] ar = {-2,1,-3,4,-1,2,1,-5,4};
	//	System.out.println(maxSubArray(ar));
		maxSubArrayPrint(ar);
	}

	public static int maxSubArray(int[] nums) {
		int maxSum =nums[0]; 
		int currentSum =0;
		
		for (int i = 0; i < nums.length; i++) {
			currentSum += nums[i];
			
			maxSum = Math.max(currentSum, maxSum);
			
			if(currentSum < 0) {
				currentSum =0;
			}
		}
		return maxSum;
    }
	// Now print the sub-arrays whose having maxsum

	public static void maxSubArrayPrint(int[] nums) {
		int currentMax = nums[0];
		int globalMax = nums[0];
		int endIndex = 0;
		int startIndex =0;
		int globalMaxStartIndex = 0;
		
		for(int i=1;i< nums.length;i++) {
			if(nums[i] > nums[i] + currentMax) {
				currentMax = nums[i];
				startIndex =i;
			}
			else if(nums[i] < nums[i] + currentMax) {
				currentMax = nums[i] + currentMax;
			}
			if(currentMax > globalMax) {
				globalMax = currentMax;
				endIndex =i;
				globalMaxStartIndex = startIndex;
			}
		}
		// Now print from globalMaxStartIndex to endIndex of the sub array
		for(int j= globalMaxStartIndex; j<=endIndex; j++) {
			System.out.print(nums[j] +" ");
		}
	}
}

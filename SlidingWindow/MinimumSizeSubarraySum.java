package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		int nums[] = {2,3,1,2,4,3};
		int target =7;
//		int nums[] = {1,1,1,1,1,1,1,1};
//		int target =11;
		System.out.println(minSubArrayLenRetSubArray(target,nums));

	}

	static int minSubArrayLen(int target, int[] nums) {
		int i=0,j=0;
		int sum =0;
		int min = Integer.MAX_VALUE;
		
		while(j < nums.length) {
			sum = sum + nums[j];
			
			if(sum < target) {
				j++;
			}
			else if(sum >= target){
				while(sum >= target) {
					min = Math.min((j -i +1), min);
					sum = sum - nums[i];
					i++;
				}
				j++;
			}
		}
		return min == Integer.MAX_VALUE ? 0: min;
	}
	// Return the minimum window of subset whose sum is >= target 
	static List<Integer> minSubArrayLenRetSubArray(int target, int[] nums) {
		List<Integer> list = new ArrayList<>();
		int i=0,j=0;
		int sum =0;
		int start =0,end =0;
		int min = Integer.MAX_VALUE;
		
		while(j < nums.length) {
			sum = sum + nums[j];
			
			if(sum < target) {
				j++;
			}
			else if(sum >= target){
				while(sum >= target) {
					min = Math.min((j -i +1), min);
					sum = sum - nums[i];
					start =i;
					end =j;
					i++;
				}
				j++;
				
			}
			
		}
		for(int k = start; k <= end; k++) {
			list.add(nums[k]);
		}
		return list;
	}
}

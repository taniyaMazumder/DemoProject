// Intuition - use recursion
package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TwoSum {

	public static void main(String[] args) {
//		int[] nums = {2,7,11,15};
//		int target = 9;
		int[] nums = {3,2,4};
		int target = 6;
		System.out.println(Arrays.toString(twoSumHashMap(nums,target)));}
/*
	public static int[] twoSum(int[] nums, int target) {
		List<Integer> ans = new ArrayList<>();
		twoSumRec(nums, target ,0,ans);
		
	//	nums = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++) {
			nums[i] = ans.get(i);
		}
		return nums;
		
    }
	public static void twoSumRec(int[] nums, int target, int index, List<Integer> answer) {
		
		// Base Condition
		if(index == nums.length) {
			if(target ==0) {
				answer.add(index);
			}
			return ;
		}
		if(nums[index] <= target) {
			answer.add(index);
			twoSumRec(nums, target - nums[index], index, answer);
			answer.remove(answer.size() -1);
		}
			twoSumRec(nums, target, index +1, answer);
	}
*/	
	// Two Sum using HashMap
		public static int[] twoSumHashMap(int[] nums, int target) {
			int[] ar= new int[2];
			HashMap<Integer,Integer> map = new HashMap<>();
			
			
			for(int i =0; i< nums.length;i++) {
				if(map.containsKey(nums[i])) {
					ar[0]= map.get(nums[i]);
					ar[1] =i;
					return ar;
				} else {
					map.put(target - nums[i], i);
				}
			}
			return ar;
		}
}

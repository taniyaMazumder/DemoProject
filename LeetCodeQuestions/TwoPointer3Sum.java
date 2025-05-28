// Given an array where  arr[i] + arr[j] + arr[k] == 0 and i != j , j!= k , i !=k means all the subset will be unique
package LeetCodeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointer3Sum {

	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(nums));

	}
// using three pointer approach
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if(i>0 && nums[i] == nums[i-1]) {
				continue;
			}
			int j = i +1;
			int k = nums.length -1;
			while( j<k) {
				int sum = nums[i] +nums[j] +nums[k];
				if(sum <0) {
					j++;
				}
				else if(sum >0) {
					k--;
				}
				else {
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[i]);
					temp.add(nums[j]);
					temp.add(nums[k]);
					ans.add(temp);
					j++;
					k--;
					// now we need unique subset
					while( j<k && nums[j] == nums[j-1]) {
						j++;
					}
					while( j<k && nums[k] == nums[k+1]) {
						k--;
					}
				}
			}
		}
		return ans;
    }
}

package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSmallerNoThanCurrent {

	public static void main(String[] args) {
		int[] nums = {8,1,2,2,3};
		System.out.println(Arrays.toString(smallerNumbersThanCurrent2(nums)));
	}
	
/*	public static int[] smallerNumbersThanCurrent(int[] nums) {
		int[] ans = new int[nums.length];
		HashMap<Integer,Integer> map = new HashMap<>();
		int[] copyOriginalArray = Arrays.copyOf(nums, nums.length);
		Arrays.sort(copyOriginalArray);
		
		/*
		 * 1st way 
		 
		ans[0] = 0;
		for (int i = 1; i < copyOriginalArray.length; i++) {
		
			if(copyOriginalArray[i] == copyOriginalArray[i -1]) {
				ans[i] = i-1;
			}
			else {
				ans[i] = i ;
			}
		}
		for (int j = 0; j < nums.length; j++) {
			ans[j] = nums[j];
		}
		*/
	/*	for (int i = 0; i < nums.length; i++) {
			map.putIfAbsent(copyOriginalArray[i], i);
		}
		
		for (int j = 0; j < nums.length; j++) {
			ans[j] = map.get(nums[j]);
		}
		return ans;
    } */
	//2nd way
	public static int[] smallerNumbersThanCurrent2(int[] nums) {
		int[] ans = new int[nums.length];
		int[] newArray= Arrays.copyOf(nums, nums.length);
		Arrays.sort(newArray);//1 2 2 3 8
		
		
		
		// Now we need to map the elements with index in the original position
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for (int j = 0; j < nums.length; j++) {
			map.putIfAbsent(newArray[j], j);
		}
		
		
		for (int i = 0; i < nums.length; i++) {
			ans[i] = map.get(nums[i]);
		}
		
		return ans;
		
	}

}

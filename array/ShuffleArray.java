package array;

import java.util.Arrays;

public class ShuffleArray {

	public static void main(String[] args) {
		int[] nums = {2,5,1,3,4,7};
		int n= 3;
		System.out.println(Arrays.toString(shuffle(nums,n)));
	}
	public static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        
        for (int i = 0; i < n; i++) {
			ans[2 * i] = nums[i];
			ans[(2 * i) +1] = nums[i + n];
		}
        return ans;
    }
	

}

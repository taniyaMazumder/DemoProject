// Since it's sorted array apply Binary search
package array;

import java.util.Arrays;

public class FindFirstLastPositionSortedArray {

	public static void main(String[] args) {
		int[] ar = {5,7,8,8,8,10};
		int target = 8;
		System.out.println(Arrays.toString(searchRange(ar,target)));
	}

	public static int[] searchRange(int[] nums, int target) {
		int[] ans = {-1,-1};
		int start = binarySearch(nums, target, 0, nums.length -1, true);
		int end = binarySearch(nums, target, 0, nums.length -1, false);
		
		ans[0] = start;
		ans[1] = end;
		
		return ans;
		
    }
	
	public static int binarySearch(int[] nums, int target, int start, int end, boolean findStartIndex) {
		int ans =-1;
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(target < nums[mid]) {
				end = mid -1;
			}
			else if(target > nums[mid]) {
				start = mid+1;
			} else {
				ans = mid;
				if(findStartIndex) {
					end = mid -1;
				}
				else {
					start = mid+1;
				}
			}
			
		}
		return ans;
	}
}

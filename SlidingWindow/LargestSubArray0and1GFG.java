// Given an array with the elements of 0's and 1's only. Find the max length of the sub array 
package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArray0and1GFG {

	public static void main(String[] args) {
		int[] ar = {0,1,0,1};
		int n =4;
//		int[] ar = {0, 0, 1, 1, 0};
//		int n =5;
		System.out.println(maxLen(ar,n));

	}

	static int maxLen(int[] arr, int n) {
        // Your code here
		Map<Integer, Integer> map = new HashMap<>();
		int count0 =0;
		int count1 =0;
		int maxLen =0, start =0, end=0;
		for (int i = 0; i < arr.length; i++) {
			if(map.containsKey(arr[i])) {
				if(arr[i] == 0) {
					count0 = map.get(arr[i]);
					map.put(arr[i], count0 +1);
				} else if(arr[i] ==1) {
					count1 = map.get(arr[i]);
					map.put(arr[i], count1 +1);
				}
				if(count0 == count1) {
					start = 0;
					end = i;
					maxLen = Math.max(maxLen, end - start +1);
				}
				
			} else {
				map.put(arr[i], 1);
			}
		}
		return maxLen;
    }
}

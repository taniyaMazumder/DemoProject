// Given an array and target is 0. Find the Largest sub-array whose sum is = 0
// Array contains combinations of positive , negative and zero.
package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithZeroSumGFG {

	public static void main(String[] args) {
		int[] ar= {15, -2, 2,-8,1, 7, 10};
		System.out.println(findLengthMaxWindow(ar));

	}
   static int findLengthMaxWindow(int[] ar) {
	 Map<Integer,Integer> map = new HashMap<>(); // In map data stores at current sum & index
	 int sum =0, maxLen =0;
	 
	 for (int i = 0; i < ar.length; i++) {
		sum = sum + ar[i];
		
		// If the sum is 0, update max_len
		if(sum ==0) {
			maxLen = i+1;
		}
		// Check if this sum is seen before
		if(map.containsKey(sum)) {
			// If this sum is seen before, update
            // max_len
			maxLen = Math.max(maxLen, i - map.get(sum));
		} else {
			// If this sum is not seen before, add it to
            // the map
			map.put(sum, i); 
		}
	}
	return maxLen;
   }
}

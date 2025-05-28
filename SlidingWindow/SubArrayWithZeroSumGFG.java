package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithZeroSumGFG {

	public static void main(String[] args) {
	//	int[] ar= {-3, 2, 3, 1, 6};
		int[] ar= {4, 2, -3, 1, 6};
		
		System.out.println(findsum(ar));

	}
// TC- O(N) , SC- O(N) since set has been used
	static boolean findsum(int arr[]) {
		
		// Creates an empty hashset hs
        Set<Integer> set = new HashSet<>();
     // Initialize sum of elements
        int sum =0;
        // now iterate the array
        for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			
			// Return true in following cases
            // a) Current element is 0
            // b) sum of elements from 0 to i is 0
            // c) sum is already present in hash set
			
			if(arr[i]==0 || sum ==0 || set.contains(sum)) {
				return true;
			}
			// Add sum to hash set
			set.add(sum);
		}
        // We reach here only when there is
        // no subarray with 0 sum
		return false;
        
    }
}

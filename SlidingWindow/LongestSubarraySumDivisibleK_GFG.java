package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LongestSubarraySumDivisibleK_GFG {

	public static void main(String[] args) {
	//	int[] ar = {2, 7, 6, 1, 4, 5};
		
		int[] ar = {-4, 5, -1, 0, 1, 0, 1, -2, 9};
		int k=7;
		System.out.println(longSubarrWthSumDivByKSlidingWindow(ar,k));

	}
// brute force TC-O(n^2), SC- O(1)
	static int longSubarrWthSumDivByKBruteForce(int[] a, int k) {

        int sum =0;
        int max = Integer.MIN_VALUE;
  
        for (int i = 0; i < a.length; i++) {
			sum=0;
			for (int j = i; j < a.length; j++) {
				sum = sum + a[j];
				if(sum % k ==0) {
					max = Math.max(max, j-i+1);
				}
			}
			
		}
		return max;
    }
	// using sliding window - TC- O(n) - SC- O(n)
     static int longSubarrWthSumDivByKSlidingWindow(int[] a, int k) {
		
		Map<Integer,Integer> map = new HashMap<>();
		int ans =0, sum=0;
		map.put(0, -1);
		for (int i = 0; i < a.length; i++) {
			sum = sum +a[i];
			
			int rem = sum % k;
			
			if(rem <0) {
				rem = rem +k;
			}
			if(map.containsKey(rem)) {
				ans = Math.max(ans, i- map.get(rem));
			} else {
				map.put(rem, i);
			}
		}
		return ans;
	}
     
}

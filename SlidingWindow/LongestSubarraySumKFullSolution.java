// Given an array and k - both for positive  and negative and zeros elements in the array
// Find Longest subarray with sum K
package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubarraySumKFullSolution {

	public static void main(String[] args) {
//		int[] ar = {46,56,66,34,89,66};
//		int k=66;
		int[] ar = {4,1,1,-2,1,5};
//		int[] ar = {4,1,1,1,2,3,5};
		int k=5;
		System.out.println(maxLengthSubArrayBFPrint(ar,k));

	}
	
	// Brute Force Solution - with TC- O(n^2) & SC-O(1)
	
	static int maxLengthSubArrayBF(int[] arr, int k) {
		int maxLen =0;
		
		for(int i=0; i<arr.length;i++) {
			int sum =0;
			for(int j=i; j<arr.length;j++) {
				sum = sum + arr[j];
				if(sum == k) {
					maxLen = Math.max(maxLen, j -i+1);
				}
			}
		}
		return maxLen;
	}
	// Print the subarray elements as a list Brute Force Solution - with TC- O(n^2) & SC-O(1)
	
		static List<Integer> maxLengthSubArrayBFPrint(int[] arr, int k) {
			int prevMax =0 , max =0; // taking prev max to track the prev max value to check that max has been updated or not
			// if max value has been updated that means we will get the latest window index and then store it into the list 
			// else it max not updated that means that is not the proper sub-array 
			List<Integer> list = new ArrayList<>();
			int i=0,j=0;
			int start =0, end =0;
			
			for( i=0; i<arr.length;i++) {
				int sum =0;
				for( j=i; j<arr.length;j++) {
					sum = sum + arr[j];
					if(sum == k) {
						max = Math.max(prevMax, j -i+1);
						if(max > prevMax) {
							start = i;
							 end = j;
						}
						prevMax = max;
						
					}
				}
			}
			for(int s=start;s<=end;s++) {
				list.add(arr[s]);
			}
			return list;
		}
	
/*
 * For positive and zeros elements in the array we will use 2-pointer approach
 * TC-O(2n) , SC-O(1)
 */
		public static int getLongestSubarray(int []a, int k) {
	        int n = a.length; // size of the array.

	        int i = 0, j = 0; // 2 pointers
	        long sum = a[0];
	        int maxLen = 0;
	        while (j < n) {
	            // if sum > k, reduce the sub-array from left
	            // until sum becomes less or equal to k:
	            while (i <= j && sum > k) {
	                sum = sum- a[i];
	                i++;
	            }

	            // if sum = k, update the maxLen i.e. answer:
	            if (sum == k) {
	                maxLen = Math.max(maxLen, j - i + 1);
	            }

	            // Move forward the right pointer:
	            j++;
	            if (j < n) sum += a[j];
	        }

	        return maxLen;
	    }
		
/*
 * For Negative numbers into the array , we will use hashMap
 * TC- O(n), SC- O(n)
 */
		public static int getLongestSubarrayMap(int []a, long k) {
	        int n = a.length; // size of the array.

	        Map<Long, Integer> preSumMap = new HashMap<>();
	        long sum = 0;
	        int maxLen = 0;
	     // Traverse through the given array
	        for (int i = 0; i < n; i++) {
	            //calculate the prefix sum till index i:
	        	//  Add current element to sum
	            sum += a[i];

	            // if the sum = k, update the maxLen:
	            if (sum == k) {
	                maxLen = Math.max(maxLen, i + 1);
	            }

	            // calculate the sum of remaining part i.e. x-k:
	            long rem = sum - k;

	            //Calculate the length and update maxLen:
	            if (preSumMap.containsKey(rem)) {
	                int len = i - preSumMap.get(rem);
	                maxLen = Math.max(maxLen, len);
	            }

	            //Finally, update the map checking the conditions:
	            if (!preSumMap.containsKey(sum)) {
	                preSumMap.put(sum, i);
	            }
	        }
			return maxLen;
		}
		
}

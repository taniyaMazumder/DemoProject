// Given sum =k and array. Find length of max sub array whose sum of the element = k
// variable sliding window where window size is not fixed

package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class LargestSubArraySumKVariableSLW {

	public static void main(String[] args) {
		int[] ar = {4,1,1,1,2,3,5};
		//System.out.println(findMax(ar,5));
		System.out.println(findMax(ar,5));
	}

	static int findMax(int[] ar, int k) {
		int max =0;
		int sum =0;
		
		int i= 0;
		int j=0;
		
		while(j < ar.length) {
			sum = sum + ar[j];
			
			if(sum < k) {
				j++;
			}
			else if(sum ==k) {
				if((j - i +1) > max) {
					max = j - i +1;
				}
				j++;
			}
			else if(sum > k) {
				while(sum >k) {
					sum = sum - ar[i];
					i++;
				}
				j++;
			}
			
		}
		return (max==0)?(j-i+1)-1:max;
	}
	// print as list max sub - arrays we received
	static List<Integer> printSubArrays(int[] ar, int k){
		List<Integer> ans = new ArrayList<>();
		
		int max =0;
		int sum =0;
		int i= 0;
		int j=0;
		
		while(j < ar.length) {
			sum = sum + ar[j];
			
			
			if(sum < k) {
				j++;
			}
			else if(sum ==k) {
				
				if((j - i +1) > max) {
					
					max = j - i +1;
					
				}
				ans.add(ar[j]);
				j++;
				
			}
			else if(sum > k) {
				while(sum >k) {
					sum = sum - ar[i];
					i++;
				}
				j++;
			}
			
		}
		return ans;
	}
}

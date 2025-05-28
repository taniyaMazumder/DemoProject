// Given an array. sub-array window size 3. Find max value from each sub array and print as a list

package SlidingWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxOfAllSubArrayFixedSizeK {

	public static void main(String[] args) {
		int[] ar = {1,3,-1,-3,5,3,6,7};
		System.out.println(findMaxBruteForce(ar,3));
}
// Time Complexity- O(n^2)
	static List<Integer> findMaxBruteForce(int[] ar, int k) {
		int max = Integer.MIN_VALUE;
		List<Integer> ans = new ArrayList<>();
		int i=0,j=0;
		for(i=0;i<ar.length;i++) {
			for(j=i;j< i+k;j++) {
				max = Math.max(max, ar[j]);
				if(j-i+1 ==k) {
					ans.add(max);
				}
			}
			if(j== ar.length) {
				break;
			}
		}
		return ans;
	}
	static List<Integer> findMax(int[] ar, int k) {
		int i =0, j =0;
		Deque<Integer> deq = new LinkedList<>();
		
		List<Integer> ans = new ArrayList<>();
		while(j < ar.length) {
			// Calculation
			if(deq.size() == 0) {
				deq.add(ar[j]);
			}
			else {
				while( deq.size() > 0 && deq.peekLast() < ar[j]) {
					deq.removeLast();
				}
				deq.add(ar[j]);
			}
			// now move j pointer
			if(j-i +1 <k) {
				j++;
			}
			// while window hits window size
			else if(j -i +1 == k) {
				// ans - calculation
				ans.add(deq.peekFirst());
				
				// slide the window
				if(deq.peekFirst() == ar[i]) {
					deq.removeFirst();
				}
				i++;
				j++;
			}
		}
		return ans;
	}
}

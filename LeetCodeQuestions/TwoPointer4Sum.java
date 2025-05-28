package LeetCodeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointer4Sum {

	public static void main(String[] args) {
		int[] nums = {1,0,-1,0,-2,2};
		int target = 0;
		System.out.println(find4Sum(nums,target));

	}

	// time complexity- O(n^2) for i and j loop 
	// for k and l it will be o(n) then finally O(n^2) * n = O(n^3)
	// sc- O(1)
	static List<List<Integer>> find4Sum(int[] ar, int target) {
		Arrays.sort(ar);
		
		List<List<Integer>> result = new ArrayList<>();
		
		for (int i = 0; i < ar.length; i++) {
			// now i will proceed only if the next element is not duplicate
			if(i >0 && ar[i] == ar[i-1]) {
				continue;
			}
			for (int j = i+1; j < ar.length; j++) {
				// now j will proceed only if the next element is not duplicate
				if(j != (i+1) && ar[j] == ar[j-1]) {
					continue;
				}
				int k = j+1;
				int l = ar.length -1;
				
				while(k<l) {
					long sum = ar[i];
					sum += ar[j];
					sum += ar[k];
					sum += ar[l];
					if(sum < target) {
						k++;
					}
					else if(sum > target) {
						l--;
					}
					else {
						List<Integer> temp = new ArrayList<>();
						temp.add(ar[i]);
						temp.add(ar[j]);
						temp.add(ar[k]);
						temp.add(ar[l]);
						result.add(temp);
						k++;
						l--;
					// now k will proceed only if the next element is not duplicate
						while(k<l && ar[k] == ar[k-1]) {
							k++;
						}
					// now l will proceed only if the next element is not duplicate
						while(k<l && ar[l] == ar[l+1]) {
							l--;
						}
					}
				}
			}
		}
		return result;
	}
}

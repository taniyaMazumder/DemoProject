// Given an array and target - both for positive  zeros elements in the array
// Find the first Longest sub-array with sum K
package SlidingWindow;

import java.util.ArrayList;

public class IndexOfSubArraySumGFG {

	public static void main(String[] args) {
//		int[] ar = {1,2,3,7,5};
//		int target = 12;
		int[] ar = {11, 29, 44, 35, 6, 41, 12, 5, 36, 7, 23, 1, 24, 36, 7, 17, 27, 8, 27};
		int target = 108;
		
		System.out.println(subarraySum(ar, target));
	}
   
	static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        int i=0, sum =arr[0], j=0;
        int start =0, end =0;
        int max = 0, prevMax =0;
        boolean flag = false;
        while(j<arr.length) {
        	
        	while( i <=j && sum> target) {
        		sum = sum - arr[i];
        		i++;
        	}
        	if(sum == target) {
        		max = Math.max(prevMax, j -i+1);
				if(max > prevMax) {
					 start = i;
					 end = j;
					 ans.add(start+1);
		        	 ans.add(end+1);
		        	 flag = true;
		        	 break; // we will break the loop cz we need only first set of sub-array even if we can get the same in later array
		        	 // we don't need it so after getting the first indeces of start and end then just break the loop that
		        	 // it not required to continue to search for the others element in the array whose sum=target
				}
				prevMax = max;
        		
        		
        	}
        	j++;
        	if (j < arr.length) {
        		sum = sum + arr[j];
        	}
        }
        if (!flag)
            ans.add(-1);
        
		return ans;
        
    }
}

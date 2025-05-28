package SlidingWindow;

public class LongestHarmoniusSubsequence {
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int findLHS(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<nums.length; i++) {
        	max = Math.max(max, nums[i]);
        	min = Math.min(min, nums[i]);
        }
        int k = max - min;
         if(k == 1) {
        //	 return helper(nums,k);
         }
         
    }
*/
/*	static int helper(int[] ar, int k) {
		int max =0;
		int min =0;
		
		int i= 0;
		int j=0;
		
		while(j < ar.length) {
			max = Math.max(max, ar[j]);
        	min = Math.min(min, ar[j]);
			
//			if(sum < k) {
//				j++;
//			}
//			else if(sum ==k) {
//				if((j - i +1) > max) {
//					max = j - i +1;
//				}
//				j++;
//			}
//			else if(sum > k) {
//				while(sum >k) {
//					sum = sum - ar[i];
					i++;
				}
				j++;
			}
			
		}
		return max;
		
}
*/
}


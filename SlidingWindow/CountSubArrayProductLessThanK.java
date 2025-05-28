// given an array and int k =100; Find the count of all sub arrays whose product less than k
package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class CountSubArrayProductLessThanK {

	public static void main(String[] args) {
		int[] nums = {10,5,2,6};
		int k = 100;
//		int[] nums = {1,2,3};
//		int k = 1;
		System.out.println(numSubarrayProductLessThanKRetList(nums,k));

	}
	static int bruteForce(int[] nums, int k) {
		
		int count =0;
		for(int i=0; i< nums.length;i++) {
			int prod =1;
			for(int j=i;j<nums.length;j++) {
				prod = prod * nums[j];
				if(prod >=k) 
					break;
					count++;
				}
			}
		return count;
		}
	
	
	 public static int numSubarrayProductLessThanK(int[] nums, int k) {
		// edge cases
			if(k ==0 || k==1) {
	            return 0;
	        }
		 int count =0;
		 int i=0,j=0;
		 int prod =1;

		 while(j < nums.length) {
			 // calculation

			 prod = prod * nums[j];
			 if(prod <k) {
				 count= count + (j-i+1);
				 j++;
			 }
			 if(prod >=k) {
				 // calculation
				 while(i < nums.length && prod >=k) {
					 prod = prod / nums[i];
					 i++;
				 }
				 count= count + (j-i+1);
					j++;
			}
		 }
		return count;
        
    }
	 // return the sub arrays as list
	 public static List<List<Integer>> numSubarrayProductLessThanKRetList(int[] nums, int k) {
		 List<List<Integer>> ans = new ArrayList<>();
		 List<Integer> temp = new ArrayList<>();
		 
		// edge cases
					if(k ==0 || k==1) {
						return ans;
			        }
				 int count =0;
				 int i=0,j=0;
				 int prod =1;
				 int start =-1, end =-1;
				 
				 while(j < nums.length) {
					 // calculation

					 prod = prod * nums[j];
					 if(prod <k) {
						 count= count + (j-i+1);
						 
						 start = i;
						 end =j;
						 
						 for(int a = start ; a <= end; a++) {
							 
							 temp.add(nums[a]);
						 }
						 
						 j++;
					 }
					 if(prod >=k) {
						 // calculation
						 while(i < nums.length && prod >=k) {
							 prod = prod / nums[i];
							 i++;
						 }
						 count= count + (j-i+1);
						 start = i;
						 end =j;
						 for(int b = start ; b <= end; b++) {
							 
							 temp.add(nums[b]);
						 }

							j++;
					}
				 }
		 ans.add(temp);
		 
 		return ans;
        
    }
	 // return all the sub arrays as a list<List> by recursion
/*	 public static List<List<Integer>> numSubarrayProductLessThanKRetListRec(int[] nums,int k) {
		 List<List<Integer>> ans = new ArrayList<>();
		 List<Integer> temp = new ArrayList<>();
		// edge cases
			if(k ==0 || k==1) {
				temp.add(0);
				ans.add(temp);
				return ans;
	        }
		 helper(nums,ans,temp,0,0,k,1);
		 return ans;
	 }
	private static void helper(int[] nums, List<List<Integer>> ans, List<Integer> temp, int i, int j, int k, int prod) {
		// Base Condition
		if(j ==nums.length ) {
			ans.add(new ArrayList<>(temp));
			return;
		}
	
	    prod *= nums[j];
	    if(prod <k) {
			 temp.add(nums[j]);
		}
	    else {
		    while (prod >= k && i <= j) {
		    	 prod /= nums[i++];
		    	 temp.add(nums[j]);
			       
		    }
	    }
	    helper(nums,  ans, temp, i, j + 1,k, prod);
	    temp.remove(temp.size() -1);
	    helper(nums,  ans, temp, i, j + 1,k, prod);
	// temp.add(nums[j]);
//	 helper(nums,ans,temp,i,j+1,k,prod);
//	 temp.remove(temp.size() -1);
//	 helper(nums,ans,temp,i,j+1,k,prod);
	 return;
	}
 */	
	 
}

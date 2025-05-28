package StackQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementPart_I {

	public static void main(String[] args) {
//		int[] ar1= {4,1,2};
//		int[] ar2= {1,3,4,2};
		
		int[] ar1= {1,3,5,2,4};
		int[] ar2= {6,5,4,3,2,1,7};
		
		System.out.println(Arrays.toString(nextGreaterElementStack(ar1,ar2)));

	}

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
		int[] ans = new int[nums1.length];
				
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if(nums1[i] == nums2[j]) {
					if(j < nums2.length -1 && nums2[j] < nums2[j +1]) {
						ans[i] = nums2[j+1];
						break;
					} else {
						ans[i] = -1;
						break;
					}
				}
			}
			
		}
		return ans;
    }
	
	public static int[] nextGreaterElementOtherExmp(int[] nums1, int[] nums2) {
        
		int[] ans = new int[nums1.length];
		int max = Integer.MIN_VALUE;
				
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if(nums1[i] == nums2[j]) {
					if(j < nums2.length -1 && nums2[j] > nums1[i]) {
						max = nums2[j];
						ans[i] = max;
						break;
					} else {
						ans[i] = -1;
						break;
					}
				}
			}
			
		}
		return ans;
    }
	public static int[] nextGreaterElementStack(int[] nums1, int[] nums2) {
		Map<Integer,Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		for (int i = nums2.length -1; i >0; i--) {
			while(!stack.isEmpty() && stack.peek() < nums2[i]) {
				stack.pop();
			}
			int res = stack.isEmpty() ? -1: stack.peek();
			map.put(nums2[i], res);
			stack.push(nums2[i]);
		}
		int[] ans = new int[nums1.length];
		
		for (int j = 0; j < nums1.length; j++) { // Check if each element in nums1 has a next greater element in map
            ans[j] = map.containsKey(nums1[j]) ? map.get(nums1[j]) : -1; // Update element in nums1 with next greater element or -1
        }
		return ans;
	}
	/*
	 * Map<Integer, Integer> map = new HashMap<>(); // map for next greater element
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.empty() && stack.peek() < num) { // Pop elements from stack and update map with next greater element
                map.put(stack.pop(), num);
            }
            stack.push(num); // Push current element onto stack
        }
        for (int i = 0; i < nums1.length; i++) { // Check if each element in nums1 has a next greater element in map
            nums1[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1; // Update element in nums1 with next greater element or -1
        }
        return nums1;
	 */
}

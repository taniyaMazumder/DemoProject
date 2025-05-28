package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MaxRepeatedSubArray {

	public static void main(String[] args) {
//		int[] nums1 = {1,2,3,2,1};
//		int[] nums2 = {3,2,1,4,7};
		int[] nums1 = {0,0,0,0,0};
		int[] nums2 = {0,0,0,0,0};
		System.out.println(findLength(nums1,nums2));

	}

	// BruteForce
	static int findMaxLengthBruteForce(int[] nums1, int[] nums2) {
		
		List<Integer> subArray = new ArrayList<>();
		for(int i=0;i<nums1.length;i++) {
			for (int j = 0; j < nums2.length; j++) {
				if(nums1[i] == nums2[j] && i<nums1.length -1 && j< nums2.length -1 && nums1[i+1] == nums2[j+1]) {
					subArray.add(nums1[i]);
				}
			}
		}
		return subArray.size() +1;
	}
	
	public static int findLength(int[] nums1, int[] nums2) {
//        Map<Integer,Integer> map = new HashMap<>();
//        
//        for (int a = 0; a < nums2.length; a++) {
//			int ele = nums2[a];
//			if(map.containsKey(ele)) {
//				map.put(ele, map.get(ele) +1);
//			}
//			else {
//				map.put(ele, 1);
//			}
//		}
//        int i=0,j =0;
//        int count = map.size();
//        while(j<nums1.length) {
//        	int ele2 = nums1[j];
//        	
//        }
		int j=0;
		List<Integer> subArray = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		for (int a = 0; a < nums2.length; a++) {
			queue.offer(nums2[a]);
		}
		    while(!queue.isEmpty()) {
					while(j < nums1.length) {
					if(queue.peek() == nums1[j]) {
						subArray.add(nums1[j]);
						queue.remove();
						j++;
					} else {
						j++;
					}
					
					}
					break;
		}
			return subArray.size();
    }
    
}

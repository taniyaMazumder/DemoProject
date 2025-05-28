package array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementArray {

	public static void main(String[] args) {
		int[] ar= {3,2,3};
		System.out.println(majorityElement(ar));

	}

	public static List<Integer> majorityElement(int[] nums) {
        
		List<Integer> list = new ArrayList<>();
//		for(int i:nums) {
//			if(i > i* nums.length /3) {
//				list.add(i);
//			}
//		}
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] >  nums.length /3) {
				list.add(nums[i]);
			}
		}
		return list;
    }
}

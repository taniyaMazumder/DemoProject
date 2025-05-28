package array;

import java.util.HashSet;
import java.util.Set;

public class CheckContainsDuplicate {

	public static void main(String[] args) {
		int[] ar= {1,2,3};
		System.out.println(containsDuplicate(ar));

	}
	static boolean containsDuplicate(int[] nums) {
	
		Set<Integer> set = new HashSet<>();
		for(int ar: nums) {
			set.add(ar);
		}
		
        return set.size() != nums.length;
		
    	}
}

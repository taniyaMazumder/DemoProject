
// Intuition- 1. create a set and copy original array into set
//2. take another expected array with set size and copy all elements of set to this array and
//3. return length of new array - this is count of unique elements of array
package array;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] arr = {1,1,2};
		System.out.println(removeDuplicates(arr));
	}

	public static int removeDuplicates(int[] nums) {
		
		Set<Integer> set = new HashSet<>();
		for(int ar: nums) {
			set.add(ar);
		}
		
		// 1st approach-
		int[] expectedArray = new int[set.size()];
		// Now copy all the elements from set to expectedArray
		System.arraycopy(set.stream().mapToInt(Integer::intValue).toArray(), 0, expectedArray, 0, set.size());
		return expectedArray.length;
		
		// 2nd approach -
		/*
		 * //copy unique element back to array without taking extra array
        int i = 0;

        for(int ele:set){
            nums[i++] = ele;
        }
        return set.size();
		
    	}
		 */
		
	}
	/*
	 * convert from Integer to int , there are two ways
	 * 1. Arrays.stream(expectedArray).boxed();
	 * 2. set.stream().mapToInt(Integer::intValue).toArray()
	 */
}

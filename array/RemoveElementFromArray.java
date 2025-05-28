package array;

import java.util.Arrays;

public class RemoveElementFromArray {

	public static void main(String[] args) {
		int[] ar = {0,1,2,2,3,0,4,2};
		int val =2;
		System.out.println(removeElement2(ar,val));
	}

	public static int removeElement(int[] nums, int val) {
		
		// count how many elements are in the array which are equal to val
		int count =0;
		for(int j=0;j<nums.length;j++) {
			if(nums[j] == val) {
				count++;
			}
		}
		// Now remove the elements and store in new array
		int[] newArr = new int[nums.length - count];
        for (int i = 0,k=0; i < nums.length; i++) {
			if(nums[i] != val) {
				  newArr[k] = nums[i];
				  k++;
			}
		}
        return newArr.length -1;
    }
	// Solution-2
	public static int removeElement2(int[] nums, int val) {
		int index =0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != val) {
				nums[index] = nums[i];
				index++;
			}
		}
		return index;
	}
}

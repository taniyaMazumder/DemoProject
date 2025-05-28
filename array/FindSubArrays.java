package array;

import java.util.ArrayList;
import java.util.List;

public class FindSubArrays {

	public static void main(String[] args) {
		int[] ar = {10,5,7,1,2,5,3,-3,2,1};
		int target =15;
	}

	static List<List<Integer>> findTarget(int[] arr, int target) {
		List<List<Integer>> outer = new ArrayList<>();
		int sum =0;
			
		for(int i= 0;i< arr.length -1;i++) {
			int f = 0;
			int s =0;
			if(target > arr[i]) {
				sum = sum + (target - arr[i]);
			}
			f++;
			
		}
		return outer;
	}
}

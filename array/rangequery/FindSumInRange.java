package array.rangequery;

import java.util.HashMap;

public class FindSumInRange {

	public static void main(String[] args) {
		int[] arr= {1,3,5,2,7,6,3,1,4,8};
		System.out.println(findSumRangeUsingloop(arr,3,8));

	}
	// using loop TC-O(n)
	static int findSumRangeUsingloop(int[] arr, int left,int right) {
		int sum =0;
		for (int i = left; i <= right; i++) {
			sum = sum + arr[i];
		}
		return sum;
	}

	// using HashMap - TC-O(n^2)
//	static int findSumRangeUsingHashmap(int[] arr, int left,int right) {
//		HashMap<Integer, Integer> hs = new HashMap<>();
//		
//		for (int i = left; i <= right; i++) {
//			hs.put(i, arr[i]);
//		}
//		int sum=0;
//		
//	}
}

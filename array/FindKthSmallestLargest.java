package array;

import java.util.Arrays;
import java.util.Collections;

public class FindKthSmallestLargest {

	public static void main(String[] args) {
		int[] ar = {6,2,9,5,4,1};
	//	int k = 2;
		int k =6;
	//	System.out.println(findSmallest(ar, k));
		System.out.println(findLargest(ar, k));
	}

	// find kth smallest element from the array
	static int findSmallest(int[] arr, int k) {
		Arrays.sort(arr); //1 2 4 5 6 9
		
		return arr[k -1];
	}
	
	// find kth largest element from the array
		static int findLargest(int[] arr, int k) {
			Arrays.sort(arr); //1 2 4 5 6 9
		
			return arr[arr.length -1];
		}
		//Another way to get kth largest element
		static int findKthLargest(int[] arr, int k) {
		//	to reverse an array 
			Collections.reverse(Arrays.asList(arr)); // 9 6 5 4 2 1
			return arr[k];
		}
}

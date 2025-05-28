package PracticeForInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclicSort {

	public static void main(String[] args) {
//		int[] arr = {3,5,2,1,4};
//		cyclicSort(arr);
//		System.out.println(Arrays.toString(arr));
//		int[] ar = {3,0,1};
//		System.out.println(findMissing(ar));
//		int[] ar = {4,3,2,7,8,2,3,1};
//		List<Integer> result = new ArrayList<>();
//		result = findAllMissing(ar);
//		System.out.println(result);
//		int[] ar = {1,3,4,2,2};
//		System.out.println(findDup(ar));
//		int[] ar = {1, 2, 2, 4};
//		System.out.println(Arrays.toString(setMismatch(ar)));
		int[] ar = {3, 4,-1,1};
		System.out.println(findMissingPos(ar));
	}

	private static void cyclicSort(int[] arr) {
		int i=0;
		
		while(i<arr.length) {
			int correct = arr[i] -1;
			
			if(arr[i] != arr[correct]) {
				// swap
				int temp = arr[i];
				arr[i] = arr[correct];
				arr[correct] = temp;
			} else {
				i++;
			}
		}
		
	}

	/*
	 * Missing number -0-n
	 */
	static int findMissing(int[] arr) {
		int i=0; 
		
		while(i<arr.length) {
			int correct = arr[i] ;
			
			if(arr[i] <arr.length  && arr[i] != arr[correct]) {
				// swap
				int temp = arr[i];
				arr[i] = arr[correct];
				arr[correct] = temp;
			} else {
				i++;
			}
		} // 0,1,3
		
		// find missing
		for (int j = 0; j < arr.length; j++) {
			if(arr[j] != j) {
				return j;
			}
		}
		return arr.length;
	}
	// Find all missing nums those are not in array 1-n
	
	static List<Integer> findAllMissing(int[] arr) { // 4 3 2 7 8 2 3 1
		int i=0; 
		
		while(i<arr.length) {
			int correct = arr[i] -1;
			
			if(arr[i] != arr[correct]) {
				// swap
				int temp = arr[i];
				arr[i] = arr[correct];
				arr[correct] = temp;
			} else {
				i++;
			}
		} // 1 2 3 4 3 4 7 8 
		  // 0 1 2 3 4 5 6 7
		List<Integer> list = new ArrayList<>();
		for (int j = 0; j < arr.length; j++) {
			if(arr[j] != j+1) {
				list.add(j+1);
			}
		}
		return list;
	}
	
	// duplicate number
	static int findDup(int[] arr) {
		int i=0; 
		
		while(i<arr.length) {
			int correct = arr[i] -1;
			
			if(arr[i] != arr[correct]) {
				// swap
				int temp = arr[i];
				arr[i] = arr[correct];
				arr[correct] = temp;
			} else {
				i++;
			}
		} // 1 3 4 2 2
		  // 1 4 3 2 2
		  // 1 2 3 4 2
		  for (int j = 0; j < arr.length; j++) {
			if(arr[j] != j +1) {
				return arr[j];
			}
		}
		return -1;
	}
	// return all duplicate elements
	static List<Integer> findAllDup(int[] arr) {
		int i=0; 
		
		while(i<arr.length) {
			int correct = arr[i] -1;
			
			if(arr[i] != arr[correct]) {
				// swap
				int temp = arr[i];
				arr[i] = arr[correct];
				arr[correct] = temp;
			} else {
				i++;
			}
		} // 1 3 4 2 2
		  // 1 4 3 2 2
		  // 1 2 3 4 2
		List<Integer> list = new ArrayList<>();
		  for (int j = 0; j < arr.length; j++) {
			if(arr[j] != j +1) {
				list.add(arr[j]);
			}
		}
		return list;
	}
	
	/*
	 * set mismatch
	 */ 
	static int[] setMismatch(int[] arr) {
		int i=0; 
		
		while(i<arr.length) {
			int correct = arr[i] -1;
			
			if(arr[i] != arr[correct]) {
				// swap
				int temp = arr[i];
				arr[i] = arr[correct];
				arr[correct] = temp;
			} else {
				i++;
			}
		} // 1 2 2 4
		  // 
		  // Missing no 
		
		  for (int j = 0; j < arr.length; j++) {
			if(arr[j] != j +1) {
				return new int[] {arr[j], j+1};
				
			}
		}
		return new int[] {-1, -1};
	}
	/*
	 * Find first missing positive no
	 */
	static int findMissingPos(int[] arr) {
		int i=0; 
		
		while(i<arr.length) {
			int correct = arr[i]-1 ;
			
			if(arr[i] > 0 && arr[i] <arr.length  && arr[i] != arr[correct]) {
				// swap
				int temp = arr[i];
				arr[i] = arr[correct];
				arr[correct] = temp;
			} else {
				i++;
			}
		} // 0,1,3
		
		// find missing
		for (int j = 0; j < arr.length; j++) {
			if(arr[j] != j+1) {
				return j+1;
			}
		}
		return arr.length+1;
	}
}

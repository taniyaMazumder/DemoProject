package array;

import java.util.Arrays;
import java.util.Collections;

public class SecondLargestElement {

	public static void main(String[] args) {
	//	Integer[] ar = {10, 4, 3, 50, 23, 90};
		int[] ar = {10, 4, 3, 50, 23, 90};
		secondLargestElement(ar);

	}

	// solve -1
 /*	public static void secondLargestElement(Integer[] arr) {
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		int largestElement = arr[0];
		
		for (int i = 0; i < arr.length; i++) {
		
			if(arr[i] != largestElement) {
				System.out.println("Second largest element:" +arr[i]);
				return;
			}
			
		}
	}
 */
	public static void secondLargestElement(int[] arr) {
		
		Arrays.sort(arr);
		int largestElement = arr[0];
		int secLargest = 0;
		for (int i = 1; i < arr.length; i++) {
			if(largestElement < arr[i]) {
				largestElement = arr[i];
			}
			else {
				secLargest = arr[i];
			}
		}
				
				
		
		
	}
}


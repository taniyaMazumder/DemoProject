package array;

import java.util.Arrays;

public class FindThreeLargestElement {

	public static void main(String[] args) {
		int[] ar = {10, 4, 3, 50, 23, 90};
		largestElement(ar);
	}

	public static void largestElement(int[] arr) {
		
		Arrays.sort(arr);
		int count =1 , check =0;
		
		for (int i = 1; i < arr.length; i++) {
			if(count <4) { // since need third largest element
				// to handle duplicate element
				if(check != arr[arr.length -i]) {
					System.out.println("Largest elements are :" +arr[arr.length -i]);
					check = arr[arr.length -i];
					count++;
				}
			}
		}
	}
}

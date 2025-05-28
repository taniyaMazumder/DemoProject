
package PracticeForInterview;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {2,5,7,3,1,4};
		selectionSortMax(arr);
		System.out.println(Arrays.toString(arr));

	}
 // find min and apply selection sort

	private static void selectionSortMin(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int correct = arr.length -i -1 ;
			int min = getMin(arr,i,correct);
			// swap
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
	static int getMin(int[] ar, int start, int end) {
		int min = start;
		for (int i = start; i <= end; i++) {
			if(ar[i] < ar[min]) {
				min = i;
			}
		}
		return min;
	}
	
	// find max and apply selection sort

		private static void selectionSortMax(int[] arr) {
			for (int i = 0; i < arr.length; i++) {
				int correct = arr.length -i -1 ;
				int max = getMax(arr,0,correct);
				// swap
				int temp = arr[max];
				arr[max] = arr[correct];
				arr[correct] = temp;
			}
		}
		static int getMax(int[] ar, int start, int end) {
			int max = start;
			for (int i = start; i <= end; i++) {
				if(ar[i] > ar[max]) {
					max = i;
				}
			}
			return max;
		}
}

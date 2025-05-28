package PracticeForInterview;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] ar = {8,2,5,66,41,9};
		bubbleSortDesc(ar);
		System.out.println(Arrays.toString(ar));
	}

	private static void bubbleSort(int[] ar) {
		boolean isSorted;
		for (int row = 0; row < ar.length; row++) {
			isSorted = false;
			for (int col = 1; col < ar.length - row ; col++) {
				if(ar[col] < ar[col -1]) {
					// swap
					int temp = ar[col];
					ar[col] = ar[col -1];
					ar[col-1] = temp;
					isSorted = true;
				}
			}
			if(isSorted== false) {
				break;
			}
		}
		
	}

	private static void bubbleSortDesc(int[] ar) {
		boolean isSorted;
		for (int row = 0; row < ar.length; row++) {
			isSorted = false;
			for (int col = 1; col < ar.length - row ; col++) {
				if(ar[col] > ar[col -1]) {
					// swap
					int temp = ar[col];
					ar[col] = ar[col -1];
					ar[col-1] = temp;
					isSorted = true;
				}
			}
			if(isSorted== false) {
				break;
			}
		}
		
	}
}

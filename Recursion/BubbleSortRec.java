package Recursion;

import java.util.Arrays;

public class BubbleSortRec {

	public static void main(String[] args) {
	//	pattern(5, 0);
		int[] arr= {12,45,32,60,19,21};
		bubbleSort(arr,arr.length -1, 0);
		System.out.println(Arrays.toString(arr));
	}

	//Pattern *
	public static void pattern(int row, int col) {
		if(row == 0) {
			return;
		}
		if(col < row) {
			pattern(row, col +1);
			System.out.print("*");
			
		} else {
			pattern(row -1, 0);
			System.out.println();
			
		}
		
	}
	
	public static void bubbleSort(int[] arr, int row, int col) {
		if(row == 0) {
			return;
		}
		if(col < row) {
			if(arr[col] > arr[col +1]) {
				// swap
				int temp= arr[col +1];
				arr[col +1] = arr[col];
				arr[col] = temp;
			}
			bubbleSort(arr,row, col +1);
		} else {
			bubbleSort(arr,row -1, 0);
			
		}
	}
}

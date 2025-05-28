package Recursion;

import java.util.Arrays;

public class SelectionSortRecursion {

	public static void main(String[] args) {
		int[] arr= {12,45,32,60,19,21};
		selectionSort(arr,arr.length,0,0);
		System.out.println(Arrays.toString(arr));
	}

	static void selectionSort(int[] ar, int row, int col, int max) {
		if(row == 0) {
			return;
		}
		if(row >col) {
			if(ar[col] > ar[max]) {
				selectionSort(ar, row, col +1, col); // here max indicates index of array
			} else {
				selectionSort(ar, row, col +1, max); // if ar[index] is not greater than max , then max will be as it is
			}
			
		}else {
			int temp = ar[max];
			ar[max] = ar[row -1];
			ar[row -1] = temp;
			
			selectionSort(ar, row-1, 0 , 0);
		}
	}
}

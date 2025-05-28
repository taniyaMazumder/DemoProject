package array;

import java.util.Arrays;

public class ZeroshiftArray {

	public static void main(String[] args) {
		int[] ar = {1, 2, 0, 4, 3, 0, 5, 0};
	//	zeroShift(ar);
		zeroShiftSol2(ar);

	}
	// Solution -1
/*	public static void zeroShift(int[] arr) {
		int count =0;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] !=0) {
				arr[count] = arr[i] ;
				count++;
			}
		}
		while(count < arr.length) {
			arr[count++] = 0;
		}
		System.out.println("Array is:" +Arrays.toString(arr));
	}
*/	
	public static void zeroShiftSol2(int[] arr) {
		int j=0;
		for (int i = 0; i < arr.length; i++) {
			
			if(arr[i] !=0) {
				swap(arr, j, i);
				j++;
			}
		}
		
		System.out.println("Array is:" +Arrays.toString(arr));
	}
	public static void swap(int[] arr, int a, int b) {
		
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		
	}

}

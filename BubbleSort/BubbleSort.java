package BubbleSort;
import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {2,5,7,3,1,9};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void bubbleSort(int[] arr) {
		boolean swapped;
		for (int i = 0; i < arr.length; i++) {
			swapped = false;
			for (int j = 1; j < arr.length -i; j++) {
				if(arr[j] < arr[j-1]) {
					// swap
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
					swapped = true;
				}
			}
			if(!swapped) {
				break;
			}
		}
	}
	// TC- best case = O(n) when array is already sorted , worst case = O(n^2) - when array is already sorted in desc order, SC-O(1)
}

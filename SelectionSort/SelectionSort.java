package SelectionSort;

import java.util.Arrays;
// TC- Best case-O(n^2) , Worst Case = O(n^2)

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {2,5,7,3,1,4};
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));

	}

	static void selectionSort(int[] ar) {
		for (int i = 0; i < ar.length; i++) {
			int last = ar.length -i -1;
			int max = getMax(ar,0,last);
			swap(ar,max,last);
		}
	}

	private static int getMax(int[] ar, int start, int end) {
		int max=start;
		for(int i=start;i<=end;i++) {
			if(ar[max] < ar[i]) {
				max =i;
			}
		}
		return max;
	}
	
	static void swap(int[] ar, int f, int s) {
		int temp = ar[f];
		ar[f] = ar[s];
		ar[s] = temp;
	}
	
	
}

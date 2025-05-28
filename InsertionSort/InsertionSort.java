package InsertionSort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] ar= {4,7,2,5,3};
		insertionSort(ar);
		System.out.println(Arrays.toString(ar));

	}

	static void insertionSort(int[] ar) {
		for (int i = 0; i < ar.length -1; i++) {
			for (int j = i+1; j >0; j--) {
				if(ar[j] <ar[j-1]) {
					//swap
					swap(ar,j,j-1);
				}else {
					break;
				}
			}
		}
	}

	public static void swap(int[] ar, int f, int s) {
		int temp = ar[f];
		ar[f] = ar[s];
		ar[s] = temp;
		
	}
	
	// best case: o(n-1) , worst case- o(n^2)
}

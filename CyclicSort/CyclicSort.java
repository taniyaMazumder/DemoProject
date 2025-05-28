package CyclicSort;

import java.util.Arrays;

public class CyclicSort {

	public static void main(String[] args) {
		int[] arr = {3,5,2,1,4};
		cyclicSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	static void cyclicSort(int[] ar) {
		
		int i=0;
		while(i < ar.length) {
			int correctIndex = ar[i] -1;
			if(ar[i] != ar[correctIndex]) {
				// swap
				swap(ar,i ,correctIndex) ;
			}
			else {
				i++;
			}
		}
	}

	static void swap(int[] ar, int first, int second) {
		
		int temp = ar[first];
		ar[first] = ar[second];
		ar[second] = temp;
	}
	
	
	
}

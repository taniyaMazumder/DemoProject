package PracticeForInterview;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] ar= {5,4,3,2,1};
		System.out.println(Arrays.toString(mergeSort(ar)));

	}

	static int[] mergeSort(int[] ar) {
		if(ar.length ==1) {
			return ar;
		}
		int mid = ar.length/2;
		
		int[] left = mergeSort(Arrays.copyOfRange(ar, 0, mid));
		int[] right = mergeSort(Arrays.copyOfRange(ar, mid,ar.length));
		
		return merge(left,right);
	}

	private static int[] merge(int[] left, int[] right) {
		int[] mix = new int[left.length+right.length];
		int i=0,j=0,k=0;
		
		while(i<left.length && j<right.length) {
			if(left[i] <right[j]) {
				mix[k] = left[i];
				i++;
			} else {
				mix[k] = right[j];
				j++;
			}
			k++;
		}
		while(i<left.length) {
			mix[k] = left[i];
			i++;
			k++;
		}
		while(j<right.length) {
			mix[k] = right[j];
			j++;
			k++;
		}
		return mix;
	}
}

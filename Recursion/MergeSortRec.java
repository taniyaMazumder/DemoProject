/*
 * Merge sort time complexity - O(nlogn), SC- O(n) -  n is how many elements in the array
 */
package Recursion;

import java.util.Arrays;

public class MergeSortRec {

	public static void main(String[] args) {
		int[] ar= {5,4,3,2,1};
//		ar = mergeSort(ar);
//		System.out.println(Arrays.toString(ar));
		mergeSortInplace(ar,0,ar.length);
		System.out.println(Arrays.toString(ar));
	}

	// TC- O(N * log N)- SC-O(N)
	static int[] mergeSort(int[] ar) {
		if(ar.length ==1) {
			return ar;
		}
		int mid = ar.length /2;
		
		int[] left = mergeSort(Arrays.copyOfRange(ar, 0, mid));
		int[] right = mergeSort(Arrays.copyOfRange(ar, mid , ar.length));
		
		return merge(left , right);
	}

	static int[] merge(int[] left, int[] right) {
	 int[] mix = new int[left.length + right.length];	
		int i =0, j=0, k=0;
	 
		while(i < left.length && j <right.length) {
			if(left[i] < right[j]) {
				mix[k] = left[i];
				i++;
			}
			else {
				mix[k] = right[j];
				j++;
			}
			k++;
		}
		
		// if the two arrays length not equal then print the long length array accordingly
		while(i< left.length) {
			mix[k] = left[i];
			i++;
			k++;
		}
		
		while(j< right.length) {
			mix[k] = right[j];
			j++;
			k++;
		}
		
		return mix;
	}
	
	static void mergeSortInplace(int[] ar, int start, int end) {
		if(end - start ==1) {
			return ;
		}
		int mid = (start +end)  /2;
		
		mergeSortInplace(ar, start, mid);
		mergeSortInplace(ar, mid , end);
		
		mergeInplace(ar,start,mid, end);
	}

	private static void mergeInplace(int[] arr, int start, int mid, int end) {
		int[] mix = new int[end - start];	
		int i =start, j=mid, k=0;
	 
		while(i < mid && j <end) {
			if(arr[i] < arr[j]) {
				mix[k] = arr[i];
				i++;
			}
			else {
				mix[k] = arr[j];
				j++;
			}
			k++;
		}
		
		// if the two arrays length not equal then print the long length array accordingly
		while(i< mid) {
			mix[k] = arr[i];
			i++;
			k++;
		}
		
		while(j< end) {
			mix[k] = arr[j];
			j++;
			k++;
		}
		
		for (int l = 0; l < mix.length; l++) {
			arr[start + l] = mix[l];
		}
		
	}

}

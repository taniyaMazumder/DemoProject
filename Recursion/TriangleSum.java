
// Given an array- print the sum of two elements of the array as tree format and reduce the elements by 1 from the previous level.
package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleSum {

	public static void main(String[] args) {
		int[] ar = {1,2,3,4,5};
//		printTriangle2(ar);
//		System.out.println(Arrays.toString(ar));
		printTriangle(ar);
	}
// solution -1
	static void printTriangle(int[] ar) {
		if(ar.length < 1) {
			return;
		}
		// create a new array and passes as a parameter in recursive call
		int[] newArray = new int[ar.length -1];
		for (int i = 0; i < ar.length -1; i++) {
			int sum = ar[i] + ar[i +1];
			newArray[i] = sum;
		}
		printTriangle(newArray);
		System.out.println(Arrays.toString(ar));
	}
	// solution -2 - where we want to pass temp new Array as parameter
	static void printTriangle2(int[] ar) {
		if(ar.length == 1) {
			return;
		}
		// create a new array and passes as a parameter in recursive call
		int[] newArray = new int[ar.length -1];
		helper(ar , 0, newArray); // this creates new array of sum of the elements
		printTriangle2(newArray); // this calls the temp array after performing sum 
		System.out.println(Arrays.toString(newArray));
	}
	private static int[] helper(int[] arr, int index, int[] temp) {
		// base condition
		if(index == arr.length -1) {
			return temp;
		}
		
		temp[index] = arr[index] + arr[index +1];
		return helper(arr, index +1, temp);
		
	}
	
}

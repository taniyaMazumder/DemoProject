package Recursion;

public class BinarySearch {

	public static void main(String[] args) {
		int[] ar = {5,8,13,22,35,59,78,91};
		int target =79;
		System.out.println(search(ar, target,0, ar.length-1));
	}

	public static int search(int[] arr, int target, int start, int end) {
		// Base Condition
		
		if(start >end) {
			return -1;
		}
		int mid = start +(end- start)/2;
		
		if(arr[mid] == target) {
			return mid;
		}
		
		if(target < arr[mid]) {
			return search(arr, target,start,mid-1);
		}
		return search(arr, target,mid+1,end);
		
	}
}

// Find Minimum value in a rotated sorted array
package BinarySearch;

public class FindMinInRotatedBS {

	public static void main(String[] args) {
		int[] ar = {5,4,3,1,2};
	   System.out.println(findMin(ar));

	}

	static int findMin(int[] ar) {
		int min = Integer.MAX_VALUE;
		int start =0;
		 int end = ar.length -1;
		 
		 while(start<=end) {
			 int mid = start +(end-start)/2;
			 
			
			 if(ar[start] <= ar[mid]) { // check if left side sorted
				 min = Math.min(min, ar[start]);
				 start = mid+1;
			 }
			 else {
				 end = mid-1;
				 min = Math.min(min, ar[mid]);
			 }
		 }
		return min;
	}
	static int findMinOptimizedCode(int[] ar) {
		int min = Integer.MAX_VALUE;
		int start =0;
		 int end = ar.length -1;
		 
		 while(start<=end) {
			 int mid = start +(end-start)/2;
			 
			 // search space is already sorted then ar[start] is smaller in the search space
			 if(ar[start] <= ar[end]) {
				 min = Math.min(min, ar[start]);
				 break;
			 }
			 if(ar[start] <= ar[mid]) { // check if left side sorted
				 min = Math.min(min, ar[start]);
				 start = mid+1;
			 }
			 else {
				 end = mid-1;
				 min = Math.min(min, ar[mid]);
			 }
		 }
		return min;
	}
	
	/*
	 * count how many times array has been rotated  
	 * Just return index of min value in the array
	 */
	
	static int findCountRotation(int[] ar) {
		int min = Integer.MAX_VALUE;
		int start =0;
		 int end = ar.length -1;
		 int index=-1;
		 
		 while(start<=end) {
			 int mid = start +(end-start)/2;
			 
			 // search space is already sorted then ar[start] is smaller in the search space
			 if(ar[start] <= ar[end]) {
				 if(min > ar[start]) {
					 index = start;
					 min = ar[start];
				 }
				 break;
			 }
			 if(ar[start] <= ar[mid]) {
				 if(min > ar[start]) {
					 index = start;
					 min = ar[start];
				 }
				 start = mid+1;
			 }
			 else {
				 end = mid-1;
				 if(min > ar[mid]) {
					 index = mid;
					 min = ar[mid];
				 }
			 }
		 }
		return index;
	}
}

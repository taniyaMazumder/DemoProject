package BinarySearch;

public class RotatedBSSolution2 {

	public static void main(String[] args) {
		int[] ar = {7,8,1,2,3,3,3,4,5,6};
		int target =3;
		System.out.println(rotatedBSDuplicateIndex(ar,target));
	}
	// Search the target in rotated  array where all elements are unique

	static int rotatedBS(int[] ar, int target) {
		int start = 0;
		int end = ar.length-1;
		
		while(start <=end) {
			int mid = start +(end-start)/2;
			
			if(ar[mid] == target) {
				return mid;
			}
			// check if left side is sorted or not
			if(ar[start] <= ar[mid]) {
				if(ar[start] <= target && target <= ar[mid]) {
					end = mid-1;
				}
				else {
					start = mid+1;
				}
			}
			else { // if right side is sorted
				if(ar[mid]<= target && target <= ar[end]) {
					start = mid+1;
				} else {
					end= mid-1;
				}
			}
		}
		return -1;
	}
	/*
	 * // Search the target in rotated  array where duplicates elements are present
	 */
	static boolean rotatedBSDuplicate(int[] ar, int target) {
		int start = 0;
		int end = ar.length-1;
		
		while(start <=end) {
			int mid = start + (end- start)/2;
			
			if(ar[mid] == target) {
				return true;
			}
			
			// check the start & mid & end are duplicate elements 
			if(ar[start] == ar[mid] && ar[mid] == ar[end]) {
				  start = start+1;
				  end= end-1;
				  continue;
			}
			if(ar[start] <= ar[mid]) { // left side sorted
				if(ar[start] <= target && target <= ar[mid]) {
					end = mid-1;
				}
				else {
					start = mid+1;
				}
			}else {
				if(ar[mid] <= target && target <= ar[end]) {
					start = mid+1;
				} else {
					end = mid-1;
				}
			}
		
		}
		return false;
	}
	
	// Return  index of target which is coming as first duplicate element in the array
	static int rotatedBSDuplicateIndex(int[] ar, int target) {
		int start = 0;
		int end = ar.length-1;
		
		while(start <=end) {
			int mid = start + (end- start)/2;
			
			if(ar[mid] == target) {
				return mid;
			}
			
			// check the start & mid & end are duplicate elements 
			if(ar[start] == ar[mid] && ar[mid] == ar[end]) {
				  start = start+1;
				  end= end-1;
				  continue;
			}
			if(ar[start] <= ar[mid]) { // left side sorted
				if(ar[start] <= target && target <= ar[mid]) {
					end = mid-1;
				}
				else {
					start = mid+1;
				}
			}else {
				if(ar[mid] <= target && target <= ar[end]) {
					start = mid+1;
				} else {
					end = mid-1;
				}
			}
		
		}
		return -1;
	}
	
	
}

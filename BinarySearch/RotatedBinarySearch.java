package BinarySearch;

public class RotatedBinarySearch {

	public static void main(String[] args) {
		int[] ar = {4,5,6,7,0,1,2};
		int target =0;
	//	System.out.println(findMountainArray(ar, target));
		System.out.println(findCountRotation(ar));
	}

	public static int findMountainArray(int[] ar, int target) {
		// 1. Find Pivot
		// 2. BS on left side
		// 3. BS on right side
		int pivot = findPivot(ar);
		
		if(pivot == -1) {
			return binarySearch(ar, target, 0, ar.length -1);
		}
		// if pivot is found then follow 4 cases
		if(target == ar[pivot]) {
			return pivot;
		}
		else if(target > ar[0]) {
			return binarySearch(ar, target, 0, pivot);
		}
		return binarySearch(ar, target, pivot+1 , ar.length -1);
	}
	
	public static int findPivot(int[] ar) {
		int start =0;
		int end = ar.length-1;
		
		while(start <=end) {
			int mid = start + (end-start)/2;
			// 4 cases
			
			if(mid < end && ar[mid] >ar[mid+1]) {
				return mid;
			}
			else if(mid < end && ar[mid] < ar[mid+1]) {
				return mid-1;
			}
			else if(ar[start] >= ar[mid]) {
				end = mid -1;
			}
			else {
				start = mid+1;
			}
			
		}
		return -1;
}
	public static int binarySearch(int[] ar, int target, int start, int end) {
				
		while(start <=end) {
			int mid = start + (end-start)/2;
			
			if(target == ar[mid]) {
				return mid;
			}
			if(target < ar[mid]) {
				end= mid -1;
			}
			
			else {
				start = mid +1;
			}
		  }
		
		return -1;
	
	}

	// rotation count
	public static int findCountRotation(int[] arr) {
		int pivot = findPivot(arr);
		return pivot +1;
	}
	// Find Pivot where array is having duplicates elements
	public static int findPivotWithDuplicate(int[] ar) {
		int start =0;
		int end = ar.length-1;
		
		while(start <=end) {
			int mid = start + (end-start)/2;
			// 4 cases
			
			if(mid < end && ar[mid] >ar[mid+1]) {
				return mid;
			}
			else if(mid < end && ar[mid] < ar[mid+1]) {
				return mid-1;
			}
			// if mid , start, end all r equal then skip the duplicates
			if(ar[start] == ar[mid] && ar[mid] == ar[end]) {
				// now need to check before skipping duplicates whether start and end are pivots or not
				// check if start is pivot or not
				if(ar[start] > ar[start +1]) {
					return start;
				}
				start = start +1;
				// check if end is pivot or not
				if(ar[end] > ar[end -1]) {
					return end;
				}
				end = end -1;
			}
			// left side sorted then we go right side to be sorted
			if(ar[start] < ar[mid] || (ar[start] == ar[mid]) && ar[end] < ar[mid]) {
				start = mid +1;
			}else {
				end = mid -1;
			}
			
		}
		return -1;
}
}
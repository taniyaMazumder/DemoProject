package BinarySearch;

public class PeakMountain {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,3,1};
		int target =3;
		System.out.println(findInMountainArray(target,arr));
	}
	static int findPeak(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length ; i++) {
			if(max < arr[i]) {
				max= arr[i];
			}
		}
		return max;
	}
	// find peak using binary search
	public static int peak(int[] arr) {
		int start =0;
		int end = arr.length -1;
		
		while(start < end) {
			int mid = start + (end - start)/2;
			
			if(arr[mid] > arr[mid+1]) { // desc array
				end = mid;
			}
			else {
				start = mid+1; // asc array
			}
		}
		return end;// or return start both are equal
	}
	// Binary search for an element in mountain array
	public static int binarySearchOrder(int[] ar, int target, int start, int end) {
		
		boolean isAsc = ar[start] < ar[end];
		
		while(start <=end) {
			int mid = start + (end-start)/2;
			
			if(target == ar[mid]) {
				return mid;
			}
			if(isAsc) {
				if(target < ar[mid]) {
					end= mid -1;
				}
				else {
					start = mid +1;
				}
			}
			else {
				if(target > ar[mid]) {
					end= mid -1;
				}
				else {
					start = mid +1;
				}
			}
			
		}
		return -1;
	}
	//Find Mountain in the mountain array
	public static int findInMountainArray(int target, int[] arr) {
        int peak = peak(arr);
        int firstTry = binarySearchOrder(arr,target,0, peak);
        
        if(firstTry != -1) {
        	return firstTry;
        } else {
        	return binarySearchOrder(arr,target, peak+1, arr.length -1);
        }
		
    }
}

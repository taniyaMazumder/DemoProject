package BinarySearch;

public class FindPeakSolution2 {

	public static void main(String[] args) {
		int[] ar= {1,2,3,4,5,6,7,8,5,1};
		System.out.println(findPeak(ar));

	}

	// Find peak with linear search - TC- O(n) , SC-O(1)
	
	static int findPeakBF(int[] ar) {
		for(int i=0; i<ar.length ;i++) {
			if(((i==0) || ar[i-1] < ar[i]) && ((i== ar.length -1) || ar[i] > ar[i+1])) {
				return i;
			}
		}
		return -1;
	}
	
	// Find single peak using binary search
	static int findPeak(int[] ar) {
		if(ar.length ==1) {
			return 0;
		}
		if(ar[0] > ar[1]) {
			return 0;
		}
		
		if(ar[ar.length -1] > ar[ar.length -2]) {
			return ar.length -1;
		}
		
		int start=1, end = ar.length -2;
		
		while(start <= end) {
			int mid = start + (end - start) /2;
			
			if(ar[mid] > ar[mid-1] && ar[mid] > ar[mid+1]) {
				return mid;
			}
			else if(ar[mid] > ar[mid -1]) {
				//we r in increasing order
				start = mid+1;
			}
			else if(ar[mid] < ar[mid -1]) {
				end = mid-1;
			}
		}
		return -1;
	}
}

package BinarySearch;

public class CountRotationBS {

	public static void main(String[] args) {
		int[] ar = {4,5,6,7,0,1,2};
		System.out.println(countRotation(ar));

	}

	public static int countRotation(int[] ar) {
		int count = findPivot(ar);
		
		return count+1;
		
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
}

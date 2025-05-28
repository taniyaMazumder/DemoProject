package BinarySearch;

public class BinarySearchInfiniteArray {

	public static void main(String[] args) {
		int[] ar = {5,8,13,22,59,59,59,78,91,111,121,230,350};
		int target =111;
		System.out.println(findTarget(ar, target));
	}

	public static int findTarget(int[] arr, int target) {
		if(arr.length ==0) {
			return -1;
		}
		int start =0;
		int end = 1;
		
		// now doubling the size of box
		while(target > end) {
			int newStart = end +1;
			
			end = end + (end - start +1) *2;
			
			start = newStart;
		}
		return binarySearch(arr, target, start, end);
	}
	public static int binarySearch(int[] ar, int target, int start, int end) {
		
		 start =0;
		 end = ar.length -1;
		
		while(start <=end) {
			int mid = start + (end-start)/2;
			
			if(target < ar[mid]) {
				end= mid -1;
			}
			else if(target == ar[mid]) {
				return mid;
			}
			else {
				start = mid +1;
			}
		}
		return -1;
	}
}

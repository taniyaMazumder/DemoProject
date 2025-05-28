package BinarySearch;

public class OrderAgnosticBS {

	public static void main(String[] args) {
		int[] ar = {91,78,67,59,48,22,13,5};
		int target =22;
		System.out.println(findBinarySearch(ar, target));

	}

	static int findBinarySearch(int[] ar, int target) {
		int start=0;
		int end = ar.length-1;
		boolean isAsc;
		if(ar[start] < ar[end]) {
			isAsc = true;
		}
		else {
			isAsc = false;
		}
		while(start <=end) {
			int mid = start + (end - start) /2;
			if(ar[mid] == target) {
				return mid;
			}
			if(isAsc) {
				if(target < ar[mid]) {
					end = mid -1;
				}
				else {
					start = mid +1;
				}
			} else {
				if(target > ar[mid]) {
					end = mid -1;
				}
				else {
					start = mid +1;
				}
			}
		}
		return -1;
	}
}

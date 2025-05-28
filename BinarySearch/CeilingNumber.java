package BinarySearch;

public class CeilingNumber {

	public static void main(String[] args) {
		int[] ar = {5,8,13,22,35,59,78,91};
		int target =75;
		System.out.println(findCeiling(ar, target));

	}

	public static int findCeiling(int[] ar, int target) {
		// but what if target >= last element of the array means target >= max element of the array
		if(target > ar[ar.length -1]) {
			return -1;
		}
		int start =0;
		int end = ar.length -1;
				
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
		return start;
}
}

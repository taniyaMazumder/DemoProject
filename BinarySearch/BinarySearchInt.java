package BinarySearch;

public class BinarySearchInt {

	public static void main(String[] args) {
		int[] ar = {5,8,13,22,35,59,78,91};
		int target =78;
		System.out.println(binarySearch(ar, target));
	}
// TC- O(logN)
	public static int binarySearch(int[] ar, int target) {
		
		int start =0;
		int end = ar.length -1;
		
		while(start <=end) {
			int mid = start + (end-start)/2; // for any large number if we can add start + end then it will exceed int range
			
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

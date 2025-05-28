package LinearSearch;

public class LinearSearchInteger {

	public static void main(String[] args) {
		int[] ar = {18,12,9,14,72,21};
		int target =14;
	//	System.out.println(linearSearch(ar,target));
		System.out.println(searchRecursion(ar,0,target));

	}
	// TC- Best case - O(1) , worst case- O(n) , SC- O(1)
	/*	
	public static int linearSearch(int[] ar, int target) {
		
		if(ar.length ==0) {
			return -1;
		}
		for (int index = 0; index < ar.length; index++) {
			int element = ar[index];
			if(element == target) {
				return index;
			}
		}
		return -1; // if target not present in the array
	}
*/	
	// using recursion
		public static int searchRecursion(int[] arr, int target, int index) {
			if(index == arr.length) {
				return -1;
			}
			if(arr[index] == target) {
				return index;
			}
			
			return searchRecursion(arr,target, index +1);
		}
	
}

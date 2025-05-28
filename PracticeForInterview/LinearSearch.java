package PracticeForInterview;

public class LinearSearch {

	public static void main(String[] args) {
//		int[] ar = {12,5,89,56,2,77,65};
//		int target = 2;
	//	System.out.println(search(ar,target));
//		
//		String name= "Taniya";
//		char target = 'i';
//		System.out.println(searchString(name,target));
		
//		int[] ar = {18,12,9,14,72,21,-10,5};
//		
//		System.out.println(findMin(ar));
		
		int[] ar = {12,345,2,6000,7896};
		System.out.println(countDigit(ar));
	}

	

	// TC = Best Case- O(1) , WorstCAse = O(n) , SC- O(1)
	private static boolean search(int[] ar,int target) {
		for (int i = 0; i < ar.length; i++) {
			if(ar[i] == target) {
				return true;
			}
		}
		return false;
	}

	// using recursion
	public static int searchRec(int[] arr, int target, int index) {
		if(index == arr.length) {
			return -1;
		}
		if(arr[index] == target) {
			return index;
		}
		
		return searchRec(arr,target, index +1);
	}
	
	/*
	 * Linear search in string
	 */
	private static boolean searchString(String name, char target) {
		if(name.length() ==0) {
			return false;
		}
		for(int i=0;i<name.length();i++) {
			if(name.charAt(i) == target) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Find Min in array
	 */
	static int findMin(int[] ar) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < ar.length; i++) {
			if(ar[i] <min) {
				min = ar[i];
			}
		}
		return min;
	}
	/*
	 * Find max within range
	 */
	static int findMax(int[] ar, int start, int end, int target) {
		int max = Integer.MIN_VALUE;
		for (int i = start; i <= end; i++) {
			if(ar[i] > max) {
				max = ar[i];
			}
		}
		return max;
	}
	/*
	 * Even digit- count the no of digit in all the array elements and return how many even no of digits of all elements available in the array
	 */
	
	static int countDigit(int[] ar) {
		int count =0;
		for (int i = 0; i < ar.length; i++) {
			int digit = findCountDig(ar[i]);
			if(digit % 2==0) {
				count++;
			}
		}
		return count;
	
	}

	private static int findCountDig(int num) {
		int sum=0;
		if(num ==0) {
			return 1;
		}
		if(num <0) {
			return num * -1;
		}
		while(num >0) {
			sum ++;
			num = num /10;
		}
		return sum;
	}
}

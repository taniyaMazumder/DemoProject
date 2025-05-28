package Recursion;

public class CheckSortedArrayRec {

	public static void main(String[] args) {
		//	int[] arr = {4,12,67,99,108};
		int[] arr = {4,12,67,40,99,50};
		System.out.println(checkSortedRec(arr,0));
	}

	// using recursion
	static boolean checkSortedRec(int[] arr, int index) {
		// base condition
		if(index == arr.length-1) {
			return true;
		}
	/*	
		if(arr[index] < arr[index+1]) {
			return checkSortedRec(arr,index+1);
		}
		return false;
	
	   To concise the above 3 lines of code we can write below code in 1 line
	 * 
	 */
		
		
		return (arr[index] < arr[index+1] && checkSortedRec(arr,index+1));
	}

}

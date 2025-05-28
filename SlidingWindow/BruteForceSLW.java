
// find the max sum of 3 sub arrays within the original array. 
// Make a sub array of size 3 from the original array and find sum of the sub arrays and find max sum of those sub arrays
// Problem- MaxSumSubArraySizeK - Brute Force Solution
package SlidingWindow;

public class BruteForceSLW {

	public static void main(String[] args) {
		int[] ar = {1,2,4,5,3,9,7,6,5,4};
		System.out.println(slidingSum(ar));

	}

	static int slidingSum(int[] ar) {
		int sum =0;
		int temp =0;
	
		for(int i=0; i< ar.length;i++) {
			temp =0;
			for(int j=i ; j< i+3 && j<ar.length; j++) {
				temp += ar[j] ;
			}
			if(temp > sum) {
				sum = temp;
			}
			
		}
		
		return sum;
	}
}

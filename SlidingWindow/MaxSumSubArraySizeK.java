// Given an array and windows size K . Find Max sum of each sub array of size k.
// Ex- if k =3 , then find max sum when window size is 3.

package SlidingWindow;

public class MaxSumSubArraySizeK {

	public static void main(String[] args) {
		int[] ar = {1,2,4,5,3,9,7,6,5,4};
		System.out.println(maxSum(ar,3));

	}

	static int maxSum(int[] arr, int k) {
		int sum =0;
		int maxSum = Integer.MIN_VALUE;
		
		int i= 0;
		int j=0;
		
		while(j < arr.length) {
			sum = sum + arr[j];
			
			if((j - i +1) < k) {
				j++;
			}
			else if((j -i +1) == k) {
				maxSum = Math.max(maxSum, sum);
				sum = sum - arr[i];
				i++;
				j++;
			}
			
		}
		return maxSum;
	}
}

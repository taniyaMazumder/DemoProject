// Find max . min from an array using recursion
package Recursion;

public class FindMaxMinArrayRec {

	public static void main(String[] args) {
		int[] ar = {1, 4, 3, -5, -4, 8, 6};
		System.out.println(printMax(ar,0,0));

	}
// Find min
	static int printMin(int[] ar , int min , int i) {
		if(ar.length == 1) {
			return ar[0];
		}
		if(i == ar.length -1) {
			return min;
		}
		if(ar[i] < ar[i + 1]) {
			min = Math.min(min, ar[i]);
		} 
		return printMin(ar, min, i +1);
	}
	// Find max
	static int printMax(int[] ar , int max , int i) {
		if(ar.length == 1) {
			return ar[0];
		}
		if(i == ar.length -1) {
			return max;
		}
		if(ar[i] > ar[i + 1]) {
			max = Math.max(max, ar[i]);
		} 
		return printMax(ar, max, i +1);
	}
}

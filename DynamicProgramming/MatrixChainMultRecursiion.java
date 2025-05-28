package DynamicProgramming;

public class MatrixChainMultRecursiion {

	public static void main(String[] args) {
		int[] ar = {40,20,30,10,30};
		System.out.println(findMinMultiplication(ar,1,ar.length -1));
	}

	static int findMinMultiplication(int[] arr, int i, int j) {
		// Base condition
		if(i >=j) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for(int k =i; k <j;k++) {
			int temp = findMinMultiplication(arr,i, k) + findMinMultiplication(arr, k+1, j) + (arr[i-1] * arr[k] * arr[j]);
//			if(temp < min) {
//				min = temp;
//			}
			min = Math.min(temp, min);
		}
		return min;
	}
}

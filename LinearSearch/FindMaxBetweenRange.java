package LinearSearch;

public class FindMaxBetweenRange {

	public static void main(String[] args) {
		int[] ar = {12,18,-2,75,21,67,99,44};
		System.out.println(FindMaxRangeRec(ar,1,6,Integer.MIN_VALUE));

	}
	
	public static int FindMaxRange(int[] arr, int start, int end) {
		if(arr.length ==0) {
			return -1;
		}
		int max = Integer.MIN_VALUE;
		for (int index = start; index <= end; index++) {
			if(arr[index] > max) {
				max = arr[index];
			}
		}
		return max;
	}

	// Max between range with recursion
	public static int FindMaxRangeRec(int[] arr, int start, int end, int max) {
		if(start > end) {
			return max;
		}
		
		while(start <= end) {
			if(arr[start] > max) {
				max = arr[start];
			} 
			FindMaxRangeRec(arr, start+1, end,max);
			
		}
		return max;
		
	}
}

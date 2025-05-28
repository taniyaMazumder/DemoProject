package LinearSearch;

public class FindMinInArray {

	public static void main(String[] args) {
		int[] ar = {18,12,9,14,72,21,-10,5};
		
		System.out.println(minSearch2(ar));

	}

	public static int minSearch(int[] ar) {
		
		if(ar.length ==0) {
			return -1;
		}
		int min = ar[0];
		for (int index = 0; index < ar.length; index++) {
			
			if(ar[index] < min) {
				min = ar[index];
			}
		}
		return min;
	}
	// another way to find min
	public static int minSearch2(int[] ar) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < ar.length; i++) {
			min = Math.min(min, ar[i]);
		}
		return min;
	}
}

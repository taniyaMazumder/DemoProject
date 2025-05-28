package CyclicSort;

public class FindFirstPositiveMissingNumber {

	public static void main(String[] args) {
//		int[] ar = {3,4,-1,1};
		int[] ar = {1,2,3,5};
		System.out.println(firstMissing(ar));

	}

	static int firstMissing(int[] ar) {
		int i=0;
		while(i< ar.length) {
			int correct = ar[i] -1;
			if(ar[i] >0 && ar[i] <= ar.length && ar[i] != ar[correct]) {
				// Swap
				swap(ar, i, correct);
			} else {
				i++;
			}
		}
		// Now find missing positive
		for (int index = 0; index < ar.length; index++) {
			if(ar[index] != index+1) {
				return index +1;
			}
		}
		// case 2: while ar={1,2,3,4,5} ans will be size +1
		return ar.length +1;
	}

	public static void swap(int[] ar, int f, int s) {
		int temp = ar[f];
		ar[f] = ar[s];
		ar[s] = temp;
		
	}
}

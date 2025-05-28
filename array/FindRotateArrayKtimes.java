package array;

public class FindRotateArrayKtimes {

	public static void main(String[] args) {
		int[] a = {1, 3, 5, 7, 9};
		int k = 2;
		printrotateArray(a,k);

	}

	static void printrotateArray(int[] ar, int k) {
		int n = ar.length;

		k= k%n;
		
		for(int i=0; i<n;i++) {
			if(i<k) {
				System.out.print(ar[n-k+i] +"  ");
			}
			else {
				System.out.print(ar[i-k] +"  ");
			}
		}
		System.out.println();
	}
}

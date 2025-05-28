package BinarySearch;

public class CeilingChar {

	public static void main(String[] args) {
		char[] letters = {'c','f','j'};
		char target = 'a';
		System.out.println(findCeiling(letters, target));
	}
	public static char findCeiling(char[] ar, char target) {
		
		int start =0;
		int end = ar.length -1;
				
		while(start <=end) {
			int mid = start + (end-start)/2;
			
			if(target < ar[mid]) {
				end= mid -1;
			}
			else {
				start = mid +1;
			}
		}
		return ar[start % ar.length];
}
}

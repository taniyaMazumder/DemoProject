// Find how many elements having even number digits in the array
package LinearSearch;

public class FindEvenDigitsNumbers {

	public static void main(String[] args) {
		int[] ar = {12,345,2,6,7896};
		System.out.println(evenDigitsNumbers(ar));
		
	}

	public static int evenDigitsNumbers(int[] ar) {
		int count =0;
		for(int nums: ar) {
			if(findEvenDigits(nums)) {
				count++;
			}
		}
		return count;
	}
	public static boolean findEvenDigits(int num) {
		int noOfDigits = countDigit2(num);
		if(noOfDigits %2 ==0) {
			return true;
		}
		return false;
}
	
	public static int countDigit(int num) {
		int count =0;
		if(num <0) {
			num= num*-1;
		}
		if(num ==0) {
			return 1;
		}
		while (num >0) {
			count++;
			num = num /10;
		}
		return count;
	}
	// Another way to find number of digits
	public static int countDigit2(int num) {
		return (int) (Math.log10(num) +1);
	}
}

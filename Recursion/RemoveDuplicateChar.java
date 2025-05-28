package Recursion;

public class RemoveDuplicateChar {

	public static void main(String[] args) {
		String s = "aabcca" ;
		System.out.println(removeConsecutiveDuplicates(s));

	}
	static String removeConsecutiveDuplicates(String input) {
		
		if(input.length() <=1) {
			return input;
		}
		char ch1 = input.charAt(0);
		char ch2 = input.charAt(1);
		
		if(ch1 == ch2) {
			return removeConsecutiveDuplicates(input.substring(1));
		} else {
			return ch1 +removeConsecutiveDuplicates(input.substring(1));
		}
		
	}

}

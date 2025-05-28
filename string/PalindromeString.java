package string;

public class PalindromeString {

	public static void main(String[] args) {
		String s = "abcgftba";
	//	System.out.println(isPallidrome(s));
	//	System.out.println(isPallidromeTwoPointer(s));
		System.out.println(isPalindromeRec(s,0,s.length() -1));
	}
// Solution -1 using string builder
	public static boolean isPallidrome(String s) {
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		
		if(sb.toString().equals(s)== true) {
			return true;
		}
		else
			return false;
	}
	
// solution-2 using two pointer
	public static boolean isPallidromeTwoPointer(String s) {
		
		s = s.toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			char start= s.charAt(i);
			char end = s.charAt(s.length() -1 -i);
			
			if(start != end) {
				return false;
			}
		}
		return true;
		
	}
	
	private static boolean isPalindromeRec(String s, int i, int j) {
		
		if(i>=j) {
			return true;
		}
		while(i>j) {
			if(s.charAt(i) == s.charAt(j)) {
				
				return true;
			}
			i++;
			j--;
			
		}
		return false;
		
	}
}

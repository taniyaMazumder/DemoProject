// You have given a string and find caps char in that string
package Recursion;

public class FindFirstUpperCaseSearchRec {

	public static void main(String[] args) {
		String s = "geeksforgeeKs";
		System.out.println(findSearch(s,0));

	}
 // solution -1 - using linear search
	static char findSearch(String s, int index) {
		if(s.length() ==1) {
			return s.charAt(0);
		}
		char ch = s.charAt(index);
				
		char upperChar = Character.toUpperCase(ch);
		if(ch == upperChar) {
			return ch;
		}
		try {
		   return findSearch(s, index +1);
		} 
		catch(Exception e) {
			System.out.println("Exception occurs");
		}
		return 0;
	}
}

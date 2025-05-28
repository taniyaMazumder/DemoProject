// you have given nokia phone, 2 gives combination - abc, 3 gives combination - def like this 
package Recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhone {

	public static void main(String[] args) {
//		letterComb("", "12");
		System.out.println(letterCombinationsCount("12"));

	}

	//returning void and print the combinations first
	static void letterComb(String p, String up) {
		if(up.isEmpty()) {
			System.out.println(p);
			return;
		}
		int digit = up.charAt(0) - '0'; // convert the first char into int like '1' to 1
		
		for (int i = (digit -1) *3; i < digit *3; i++) {
			char ch = (char) ('a' +i); // type casting into by adding 'a' +3 = 'd' 
			letterComb(p + ch, up.substring(1));
		}
	}
	// returning as a list
	static List<String> letterCombinations(String digits) {
		 return helper("" , digits);
    }

	private static List<String> helper(String p, String up) {
		if(up.isEmpty()) {
			List<String> res = new ArrayList<>();
			res.add(p);
			return res;
		}
		int digit = up.charAt(0) - '0'; // convert the first char into int like '1' to 1
		List<String> ans = new ArrayList<>();
		
		for (int i = (digit -1) *3; i < digit *3; i++) {
			char ch = (char) ('a' +i); // type casting into by adding 'a' +3 = 'd' 
			ans.addAll(helper(p + ch, up.substring(1)));
		}
		return ans;
	}
	
	// find count of combinations
	static int letterCombinationsCount(String digits) {
		 return findcount("" , digits);
   }

	private static int findcount(String p, String up) {
		if(up.isEmpty()) {
			
			return 1;
		}
		int digit = up.charAt(0) - '0'; // convert the first char into int like '1' to 1
		int count =0;
		
		for (int i = (digit -1) *3; i < digit *3; i++) {
			char ch = (char) ('a' +i); // type casting into by adding 'a' +3 = 'd' 
			  count = count + findcount(p + ch, up.substring(1));
		}
		return count;
	}
}

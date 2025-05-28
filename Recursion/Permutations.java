package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
//		String up = "abc";
//		permutaions("", up);
//		System.out.println(permutaionsList("",up));
//		printPermutn("abb","");
//		System.out.println(printPermutnRet("","abc"));
		System.out.println(printPermutationCount("abcd",""));
	}
	static void permutaions(String p, String up) {
		if(up.isEmpty()) {
			System.out.println(p);
			return;
		}
		
		char ch = up.charAt(0);
		
		for (int i = 0; i <= p.length(); i++) {
			String first = p.substring(0, i);
			String second = p.substring(i, p.length());
			permutaions(first + ch + second, up.substring(1));
			
		}
	}
	/*
	 * Another way of printing permutations of a string using recursion
	 */
	
	// Java program to print all the permutations
	// of the given string
	

		// Function to print all the permutations of str
		static void printPermutn(String up, String p)
		{

			// If string is empty
			if (up.length() == 0) {
				System.out.print(p + " ");
				return;
			}

			for (int i = 0; i < up.length(); i++) {

				// ith character of str
				char ch = up.charAt(i);

				// Rest of the string after excluding
				// the ith character
				String ros = up.substring(0, i) +
							up.substring(i + 1); // res is unprocessed and ans is processed

				// Recursive call
				printPermutn(ros, p + ch);
			}
		}
		
		// returning as  a list another way
		
		static List<String> printPermutnRet(String p, String up){
			if(up.isEmpty()) {
				List<String> result = new ArrayList<>();
				result.add(p);
				return result;
			}
			List<String> list = new ArrayList<>();
			
			for(int i=0; i<up.length();i++) {
				char ch = up.charAt(i);
				
				String res = up.substring(0, i) + up.substring(i +1);
				list.addAll(printPermutnRet(p + ch, res));
			}
			return list;
		}

		// count the no of permutations count
		static int printPermutationCount(String up, String p)
		{

			// If string is empty
			if (up.length() == 0) {
				return 1;
			}
			int count =0;
			
			for (int i = 0; i < up.length(); i++) {

				// ith character of str
				char ch = up.charAt(i);

				// Rest of the string after excluding
				// the ith character
				String ros = up.substring(0, i) +
							up.substring(i + 1); // res is unprocessed and ans is processed

				// Recursive call
				count = count + printPermutationCount(ros, p + ch);
			}
			return count;
		}

	// returning as a list
	static List<String> permutaionsList(String p, String up) {
		if(up.isEmpty()) {
			List<String> res = new ArrayList<>();
			res.add(p);
			return res;
		}
		
		char ch = up.charAt(0);
		
		List<String> ans = new ArrayList<>();
		
		for (int i = 0; i <= p.length(); i++) {
			String first = p.substring(0, i);
			String second = p.substring(i, p.length());
			ans.addAll(permutaionsList(first + ch + second, up.substring(1)));
			
		}
		return ans;
	}
}

package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationWithSpace {

	public static void main(String[] args) {
		System.out.println(permute("abc"));

	}

	/*	public static void permutation(String ip, String op) {
		StringBuilder sb = new StringBuilder(op);
		// Base condition
		if(ip.length() == 0) {
			System.out.println(op);
            return;
		}
		
		String op1 = sb.toString();
		String op2 = sb.toString();
		
		op1 = sb.insert(sb.charAt(0), "-").toString();
		op1 = sb.append(sb.charAt(0)).toString();
		op2 = sb.append(sb.charAt(0)).toString();
		
		
		ip = ip.substring(1);
		
		permutation(ip,op1);
		permutation(ip,op2);
		return;
		
	}
	*/
	
		public static List<String>  permute(String ip) {
		List<String> result = new ArrayList<>();
		permutationSpace(ip,0,result);
		return result;
	}
	
	static void permutationSpace(String s, int index, List<String> list) {
		// Base Condition
		if(index == s.length() -1) {
			list.add(s);
			return;
		}
		
		// Exclude the space
		permutationSpace(s,index +1, list);
		
		StringBuilder sb = new StringBuilder(s);
		sb.insert(index +1, "-");
		
		// Include the space
		permutationSpace(sb.toString(),index +2, list);
	}
	
}

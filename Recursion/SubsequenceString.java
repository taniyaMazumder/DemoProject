package Recursion;

import java.util.ArrayList;

public class SubsequenceString {

	public static void main(String[] args) {
//		subset("" , "abc");
		ArrayList<String> list = new ArrayList<>();
		System.out.println(subsetAL("","abc",  list));

	}
	
	static void subset(String p, String up) {
		if(up.isEmpty()) {
			System.out.println(p);
			return;
		}
		char ch = up.charAt(0);
		
		subset(p , up.substring(1));
		subset(p +ch , up.substring(1));
		
	}
	// Returning Arraylist and passing as an arguments
	static ArrayList<String> subsetAL(String p, String up, ArrayList<String> al) {
		if(up.isEmpty()) {
			return al;
		}
		char ch = up.charAt(0);
		
		subsetAL(p +ch , up.substring(1),al);
		subsetAL(p , up.substring(1), al);
		al.add(p +ch);
		return al;
	}
	
	// returning arraylist with creating diff object in the func body itself
	static ArrayList<String> subsetALRet(String p, String up) {
		if(up.isEmpty()) {
			ArrayList<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}
		char ch = up.charAt(0);
		
		ArrayList<String> left = subsetALRet(p +ch , up.substring(1));
		ArrayList<String> right = subsetALRet(p , up.substring(1));
		
		left.addAll(right);
		return left;
	}
}

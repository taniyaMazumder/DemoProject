package Recursion;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class NdigitNoIncrDecrOrderRec {

	public static void main(String[] args) {
		int n = 2;
//		System.out.println(printNdigitIncrRet(n));
//		printNdigitDecr(n);
		System.out.println(printNdigitDecrRet(n));
	}

	private static void printNdigitIncr(int n, int start, String out) {
		// base condition
		if(n==0) {
			System.out.print(out +" ");
			return;
		}
		
		// start from (prev digit + 1) till 9
		for(int i=start; i<=9; i++) {
			// append current digit to number
			String str =  out + Integer.toString(i);
			printNdigitIncr(n-1, i+1, str);
		}
	}
// Return as a list
	private static ArrayList<Integer> printNdigitIncrRet(int n) {
		ArrayList<Integer> list = new ArrayList<>();// this has been taken for getting temp value from helper func
		helper(n, 0, "",list);
		ArrayList<Integer> ans = new ArrayList<>(); // this has been taken to get final ans
		for(int i : list) {
			if(String.valueOf(i).length() == n) {
				ans.add(i);
			}
		}
		return ans;
	}
	private static void helper(int n, int start, String out, ArrayList<Integer> al) {
		// base condition
		if(n==0) {
			al.add(Integer.parseInt(out));
			return;
		}
		
		// start from (prev digit + 1) till 9
		for(int i=start; i<=9; i++) {
			
			helper(n-1, i+1, out + i ,al);
		}
	
	}
	
/*
 * 	 ---------------------------------------------------------------------------------------------------------------------------------------
 *   Now Write a program to Print all n-digit numbers whose digits are strictly decreasing from left to right.
 *   
 */
	private static ArrayList<Integer> printNdigitDecrRet(int n) {
		ArrayList<Integer> list = new ArrayList<>();// this has been taken for getting temp value from helper func
		helper2(n, 9, "",list);
		ArrayList<Integer> ans = new ArrayList<>(); // this has been taken to get final ans
		for(int i : list) {
			if(String.valueOf(i).length() == n) {
				ans.add(i);
			}
		}
		return ans;
	}
	private static void helper2(int n, int end, String out, ArrayList<Integer> al) {
	// base condition
		if(n==0) {
			al.add(Integer.parseInt(out));
	    	return;
		}
		
		// start from (prev digit - 1) till 9
		for(int i=0 ; i<=end; i++) {
			helper2(n-1, i-1, out + i ,al);
		}
	
	}
}

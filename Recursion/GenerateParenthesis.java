package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public static void main(String[] args) {
		
		System.out.println(generateParenthesis(2));
	}

	static List<String> generateParenthesis(int n){
		String op = "";
		int open = n;
		int closed =n;
		List<String> list = new ArrayList<>();
		
		solve(open,closed, op, list);
		return list;
	}

	private static void solve(int open, int closed, String op, List<String> list) {
		// Base condition
		
		if(open ==0 && closed ==0) {
			list.add(op);
			return;
		}
		if(open !=0) {
			String op1 = op;
			StringBuilder sb1 = new StringBuilder(op1);
			sb1.append("(");
			solve(open -1,closed,sb1.toString(),list);
		}
		if(closed > open) {
			String op2 = op;
			StringBuilder sb2 = new StringBuilder(op2);
			sb2.append(")");
			solve(open,closed -1,sb2.toString(),list);
		}
		return;
	}
}
